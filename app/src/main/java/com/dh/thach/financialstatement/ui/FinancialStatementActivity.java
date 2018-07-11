package com.dh.thach.financialstatement.ui;

import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dh.thach.financialstatement.adapter.FinancialRecyclerAdapter;
import com.dh.thach.financialstatement.R;
import com.dh.thach.financialstatement.database.FinancialDBHelper;
import com.dh.thach.financialstatement.utils.TypeFinancial;

import java.util.ArrayList;
import java.util.Random;

public class FinancialStatementActivity extends AppCompatActivity {
    private RecyclerView mFinancialRecyclerView;
    private FinancialRecyclerAdapter mFinancialRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FinancialDBHelper mDbHelper;
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
        mDbHelper = new FinancialDBHelper(this);
        Cursor cursor = mDbHelper.getAllContent();
        if(cursor == null){
            mDbHelper.insertContent("Salary","13000k",13000,0,0,0, TypeFinancial.TYPE_SALARY);
        }else{
            cursor.moveToFirst();
            if(cursor.getCount() <= 0){
                mDbHelper.insertContent("Salary","13000k",13000,0,0,0, TypeFinancial.TYPE_SALARY);
            }else{
                Log.d("DHT",cursor.getString(cursor.getColumnIndexOrThrow(FinancialDBHelper.COLUMN_NAME) + cursor.getCount()));
                cursor.close();
            }
        }

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

    @Override
    protected void onDestroy() {
        if(mDbHelper != null) mDbHelper.close();
        super.onDestroy();
    }

}
