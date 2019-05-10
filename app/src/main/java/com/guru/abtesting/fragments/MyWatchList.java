package com.guru.abtesting.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guru.abtesting.AppState;
import com.guru.abtesting.R;
import com.guru.abtesting.adapters.SymbolAdapter;
import com.guru.abtesting.utils.Symbol;

import java.util.ArrayList;
import java.util.List;

public class MyWatchList extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private static List<Symbol> symbolList = new ArrayList<>();
    public static RecyclerView recyclerView;
    private static SymbolAdapter mAdapter;
    private TextView arrow_nifty, arrow_sensex, floating_search, watchlist_icon, symbol_arrow, bid_arrow, ltp_arrow;

    String recycler_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_mywatchlist, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        arrow_nifty = (TextView) rootView.findViewById(R.id.arrow_nifty);
        arrow_sensex = (TextView) rootView.findViewById(R.id.arrow_sensex);
        floating_search = (TextView) rootView.findViewById(R.id.floating_search);
        watchlist_icon = (TextView) rootView.findViewById(R.id.watchlist_icon);
        symbol_arrow = (TextView) rootView.findViewById(R.id.symbol_arrow);
        bid_arrow = (TextView) rootView.findViewById(R.id.bid_arrow);
        ltp_arrow = (TextView) rootView.findViewById(R.id.ltp_arrow);

        mAdapter = new SymbolAdapter(symbolList);

        recycler_layout = AppState.firebaseRemoteConfig.getString("recycler_layout");

        if (recycler_layout.equals("false")) {
            //UI Option 1
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        } else {
            // UI Option 2
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Angel.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Angel_eye_font_icon_set_16.ttf");
        arrow_nifty.setTypeface(typeface);
        arrow_sensex.setTypeface(typeface);
        symbol_arrow.setTypeface(typeface);
        bid_arrow.setTypeface(typeface);
        ltp_arrow.setTypeface(typeface);
        floating_search.setTypeface(typeface);
        watchlist_icon.setTypeface(typeface2);
        arrow_nifty.setText("W");
        arrow_sensex.setText("X");
        floating_search.setText("o");
        watchlist_icon.setText("A");
        symbol_arrow.setText("V");
        bid_arrow.setText("V");
        ltp_arrow.setText("V");


        preparesymbolDataData();


        return rootView;
    }

    @Override
    public void onRefresh() {

    }


    public static void preparesymbolDataData() {

        symbolList.clear();

        Symbol symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ADANIPORTS", "NSE", "Adani Port & Sez LTD", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("AMBUJACEM", "NSE", "Ambuja Cements", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ASIAPAINT", "NSE", "Asian Paints Limited", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("AUROPHAARMA", "NSE", "Aurobindo Parms LTD", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("AXISBANK", "NSE", "Axis Bank Limited", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("BAJAJ-AUTO", "NSE", "Bajaj Auto-Limited", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("BANKBARODA", "NSE", "Bank of Baroda", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("BARATIAIRTL", "NSE", "BARATI Airtel Limited", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("BHEL", "NSE", "BHEL", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("BOSCHLTD", "NSE", "Bosch Limited", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("BPCL", "NSE", "BHARATH Petroleum Corp LT", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("CIPLA", "NSE", "CIPLA LTD", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("COALINDIA", "NSE", "Coal India LTD", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("DRREDDY", "NSE", "DR. Reddy's Lab", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("HCLTECH", "NSE", "HCL Technologies LTD", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        mAdapter.notifyDataSetChanged();
    }


}