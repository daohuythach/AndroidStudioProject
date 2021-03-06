package com.dh.thach.financialstatement.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dh.thach.financialstatement.R;

import java.util.ArrayList;

public class FinancialRecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter {
    private ArrayList<String> mDataSet;
    //private Context mContext;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_item);
        }
    }

    public FinancialRecyclerAdapter(ArrayList<String> myDataSet){
        this.mDataSet = myDataSet;
        //this.mContext = context;
    }
    public void addItemInPosition(int position, String value){
        mDataSet.add(position,value);
        // notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    //replace content of a View

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).mTextView.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


}
