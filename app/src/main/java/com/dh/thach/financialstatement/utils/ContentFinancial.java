package com.dh.thach.financialstatement.utils;

import android.content.ContentValues;

import org.jetbrains.annotations.NotNull;

public class ContentFinancial {
    private String mName;
    private String mDescription;
    private String mType;
    private int mCost;
    private int mCostFlow;
    private int mCostDown;
    private int mSharesOwed;

    public ContentFinancial(@NotNull String name,String description, int cost, int costFlow, int costDown, int sharesOwed,@NotNull String type){
        this.mName = name;
        this.mDescription = description;
        this.mCost = cost;
        this.mCostFlow = costFlow;
        this.mCostDown = costDown;
        this.mSharesOwed = sharesOwed;
        this.mType = type;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getType() {
        return mType;
    }

    public int getCost() {
        return mCost;
    }

    public int getCostFlow() {
        return mCostFlow;
    }

    public int getCostDown() {
        return mCostDown;
    }

    public int getSharesOwed() {
        return mSharesOwed;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public void setCost(int mCost) {
        this.mCost = mCost;
    }

    public void setCostFlow(int mCostFlow) {
        this.mCostFlow = mCostFlow;
    }

    public void setCostDown(int mCostDown) {
        this.mCostDown = mCostDown;
    }

    public void setSharesOwed(int mSharesOwed) {
        this.mSharesOwed = mSharesOwed;
    }
}

