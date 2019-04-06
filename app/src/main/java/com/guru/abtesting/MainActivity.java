package com.guru.abtesting;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import static com.guru.abtesting.R.color.hello;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    FirebaseRemoteConfig mFirebaseRemoteConfig;
    ConstraintLayout constraintLayout;
    String TAG = "TESTID";
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mainText = findViewById(R.id.main);
        constraintLayout = findViewById(R.id.root);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchWelcome();
                Bundle bundle = new Bundle();
                bundle.putString("DEVICE",Build.MODEL);
                bundle.putString("COLOR", String.valueOf(constraintLayout.getBackground().getAlpha()));
                mFirebaseAnalytics.logEvent("BACKGROUND_CLICK",bundle);
            }
        });


        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);

        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);

        fetchWelcome();
        Bundle b = new Bundle();
        b.putString("DEVICE",Build.MODEL);
        mFirebaseAnalytics.logEvent("onCreate",b);
    }


    private void fetchWelcome() {
        mainText.setText(mFirebaseRemoteConfig.getString(TAG));

        long cacheExpiration = 3600; // 1 hour in seconds.
        if (mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration =0;
        }

        // [START fetch_config_with_callback]
        // cacheExpirationSeconds is set to cacheExpiration here, indicating the next fetch request
        // will use fetch data from the Remote Config service, rather than cached parameter values,
        // if cached parameter values are more than cacheExpiration seconds old.
        // See Best Practices in the README for more information.
        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Fetch Succeeded",
                                    Toast.LENGTH_SHORT).show();

                            // After config data is successfully fetched, it must be activated before newly fetched
                            // values are returned.
                            mFirebaseRemoteConfig.activateFetched();
                        } else {
                            Toast.makeText(MainActivity.this, "Fetch Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                        displayWelcomeMessage();
                    }
                });
        // [END fetch_config_with_callback]
    }


    private void displayWelcomeMessage() {
        // [START get_config_values]
        String remoteConVal = mFirebaseRemoteConfig.getString(TAG);
        // [END get_config_values]
        mainText.setText(remoteConVal);
        if (remoteConVal.equalsIgnoreCase("hello")) {
            constraintLayout.setBackground(getDrawable(R.color.hello));
        } else if (remoteConVal.equalsIgnoreCase("hola")) {
            constraintLayout.setBackground(getDrawable(R.color.hola));
        } else if (remoteConVal.equalsIgnoreCase("hey"))
            constraintLayout.setBackground(getDrawable(R.color.hey));
        else
            constraintLayout.setBackground(getDrawable(R.color.oops));
    }
}
