package com.guru.abtesting.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guru.abtesting.AppState;
import com.guru.abtesting.R;
import com.guru.abtesting.fragments.MyWatchList;
import com.guru.abtesting.utils.Symbol;

import java.util.List;

public class SymbolAdapter extends RecyclerView.Adapter<SymbolAdapter.MyViewHolder> {

    private List<Symbol> moviesList;
    Context context;
    Boolean checkArrow=true;
    String recycler_layout ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView symbolname, exch, details, bid_price, ask_val, ask_size, nifty_val, change, mywatchlist_list_arrow,watchlist_parent_dots;
        public ImageView bestfive;
        public LinearLayout groupLinear;

        public MyViewHolder(View view) {
            super(view);
            symbolname = (TextView) view.findViewById(R.id.symbolname);
            exch = (TextView) view.findViewById(R.id.exch);
            details = (TextView) view.findViewById(R.id.details);
            bid_price = (TextView) view.findViewById(R.id.bid_price);
            ask_val = (TextView) view.findViewById(R.id.ask_val);
            ask_size = (TextView) view.findViewById(R.id.ask_size);
            nifty_val = (TextView) view.findViewById(R.id.nifty_val);
            change = (TextView) view.findViewById(R.id.change);
            mywatchlist_list_arrow = (TextView) view.findViewById(R.id.mywatchlist_list_arrow);
            watchlist_parent_dots = (TextView) view.findViewById(R.id.watchlist_parent_dots);
            bestfive= (ImageView) view.findViewById(R.id.bestfive);
            groupLinear= (LinearLayout) view.findViewById(R.id.groupLinear);
        }
    }


    public SymbolAdapter(List<Symbol> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        recycler_layout = AppState.firebaseRemoteConfig.getString("recycler_layout");
        View itemView=null;
        if(recycler_layout.equals("false")){
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_list, parent, false);
        }else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_list2, parent, false);
        }



        context = itemView.getContext();


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Symbol movie = moviesList.get(position);
        holder.symbolname.setText(movie.getSymbolname());
        holder.exch.setText(movie.getExch());
        holder.details.setText(movie.getDetails());
        holder.bid_price.setText(movie.getBid_price());
        holder.ask_val.setText(movie.getAsk_val());
        holder.ask_size.setText(movie.getAsk_size());
        holder.nifty_val.setText("₹ " + movie.getNifty_val());
        holder.change.setText(movie.getChange());
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Angel.ttf");
        holder.watchlist_parent_dots.setTypeface(typeface);
        holder.watchlist_parent_dots.setText("i");


        if(checkArrow){
            holder.mywatchlist_list_arrow.setTypeface(typeface);
            holder.mywatchlist_list_arrow.setText("X");

            holder.nifty_val.setTextColor(Color.RED);
            holder.mywatchlist_list_arrow.setTextColor(Color.RED);
            if(checkArrow)
                checkArrow=false;
            else
                checkArrow=true;
        }else {
            holder.mywatchlist_list_arrow.setTypeface(typeface);
            holder.mywatchlist_list_arrow.setText("W");

            holder.nifty_val.setTextColor(Color.parseColor("#02569a"));
            holder.mywatchlist_list_arrow.setTextColor(Color.parseColor("#02569a"));
            if(checkArrow)
                checkArrow=false;
            else
                checkArrow=true;
        }

        holder.groupLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.bestfive.isShown()){
                    holder.bestfive.setVisibility(View.GONE);
                    holder.groupLinear.setBackgroundColor(Color.parseColor("#ffffff"));
                    MyWatchList.preparesymbolDataData();
                }else{
                    holder.bestfive.setVisibility(View.VISIBLE);
                    holder.groupLinear.setBackgroundColor(Color.parseColor("#e4e4e4"));
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}