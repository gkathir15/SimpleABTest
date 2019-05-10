package com.guru.abtesting.fragments;

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

import com.guru.abtesting.AppState;
import com.guru.abtesting.R;
import com.guru.abtesting.adapters.SymbolAdapter;
import com.guru.abtesting.utils.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Nifty50 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private List<Symbol> symbolList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SymbolAdapter mAdapter;
    String recycler_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nifty50, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        recycler_layout = AppState.firebaseRemoteConfig.getString("recycler_layout");
        mAdapter = new SymbolAdapter(symbolList);
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

        preparesymbolDataData();

        return rootView;
    }

    @Override
    public void onRefresh() {

    }


    private void preparesymbolDataData() {

        Symbol symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        symbolData = new Symbol("ACC", "NSE", "ACC LIMITED", "1602.62(200)", "1604.45", "(67)", "1600.00", "-16.50(-1.01%)");
        symbolList.add(symbolData);

        mAdapter.notifyDataSetChanged();
    }
}