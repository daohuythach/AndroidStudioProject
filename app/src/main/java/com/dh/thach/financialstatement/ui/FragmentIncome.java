package com.dh.thach.financialstatement.ui;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dh.thach.financialstatement.R;
import com.dh.thach.financialstatement.adapter.FinancialRecyclerAdapter;
import com.dh.thach.financialstatement.database.FinancialDBHelper;
import com.dh.thach.financialstatement.utils.TypeFinancial;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentIncome extends Fragment {

    private Context mContext;

    private RecyclerView mFinancialRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private FinancialRecyclerAdapter mFinancialRecyclerAdapter;

    public FragmentIncome() {
        // Required empty public constructor
        //this.mContext = context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liabilities,container,false);
        TextView tv = view.findViewById(R.id.tv_textTile);
        tv.setText("INCOME");

        mFinancialRecyclerView = view.findViewById(R.id.list_view);
        mFinancialRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(container.getContext());
        mFinancialRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> content = new ArrayList<>();
        content.add("lua");
        content.add("ngo");
        content.add("khoai");
        content.add("san");
        mFinancialRecyclerAdapter  = new FinancialRecyclerAdapter(content);
        mFinancialRecyclerView.setAdapter(mFinancialRecyclerAdapter);
        return view;
    }

}
