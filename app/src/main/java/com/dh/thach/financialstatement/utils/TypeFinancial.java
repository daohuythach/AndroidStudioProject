package com.dh.thach.financialstatement.utils;

import android.content.ContentValues;

import com.dh.thach.financialstatement.database.FinancialDBHelper;

import static com.dh.thach.financialstatement.database.FinancialDBHelper.COLUMN_CASH_FLOW;
import static com.dh.thach.financialstatement.database.FinancialDBHelper.COLUMN_COST;
import static com.dh.thach.financialstatement.database.FinancialDBHelper.COLUMN_DESCRIPTION;
import static com.dh.thach.financialstatement.database.FinancialDBHelper.COLUMN_DOWN_FLOW;
import static com.dh.thach.financialstatement.database.FinancialDBHelper.COLUMN_SHARES_OWNED;
import static com.dh.thach.financialstatement.database.FinancialDBHelper.COLUMN_TYPE;

public class TypeFinancial {
    public static final String TYPE_PAY = "pay";
    public static final String TYPE_GET = "get";
    public static final String TYPE_SALARY = "salary";
    public static final String REAL_ESTATE_BUSINESS = "real estate business";
    public static final String STOCK = "stock";
    public static final String TYPE_NOTHING = "nothing";
    public static final String TYPE_EXPENSES = "expenses";



    public static ContentValues getContentFinContentValues(ContentFinancial contentFinancial){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FinancialDBHelper.COLUMN_NAME, contentFinancial.getName());
        contentValues.put(COLUMN_DESCRIPTION, contentFinancial.getDescription());
        contentValues.put(COLUMN_COST, contentFinancial.getCost());
        contentValues.put(COLUMN_CASH_FLOW, contentFinancial.getCostFlow());
        contentValues.put(COLUMN_DOWN_FLOW, contentFinancial.getCostDown());
        contentValues.put(COLUMN_SHARES_OWNED, contentFinancial.getSharesOwed());
        contentValues.put(COLUMN_TYPE, contentFinancial.getType());

        return contentValues;
    }
}
