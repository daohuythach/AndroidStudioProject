package com.dh.thach.financialstatement.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dh.thach.financialstatement.adapter.FinancialRecyclerAdapter;
import com.dh.thach.financialstatement.R;

import java.util.ArrayList;
import java.util.Random;

public class FinancialStatementActivity extends AppCompatActivity {
    private RecyclerView mFinancialRecyclerView;
    private FinancialRecyclerAdapter mFinancialRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_statement);
        mFinancialRecyclerView = findViewById(R.id.financial_recycler_view);
        mFinancialRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mFinancialRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> content = new ArrayList<>();
        content.add("lua");
        content.add("ngo");
        content.add("khoai");
        content.add("san");

        mFinancialRecyclerAdapter  = new FinancialRecyclerAdapter(content);
        mFinancialRecyclerView.setAdapter(mFinancialRecyclerAdapter);

        Button btnInsert = findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = mFinancialRecyclerAdapter.getItemCount();
                Random random = new Random();
                random.nextInt();
                int in = random.nextInt(i);
                Log.d("DHT","random index is " + i);
                mFinancialRecyclerAdapter.addItemInPosition(in,"new text" + in);
                mFinancialRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }


}
