package com.dh.thach.financialstatement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.jetbrains.annotations.*;

public class FinancialDBHelper extends SQLiteOpenHelper {

    //init all column of table
    public static final String DATABASE_NAME = "financial.db";
    public static final String TABLE_NAME = "financial";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_COST = "cost";
    public static final String COLUMN_CASH_FLOW = "cash_flow";
    public static final String COLUMN_DOWN_FLOW = "down_flow";
    public static final String COLUMN_SHARES_OWNED = "shares_owned";
    public static final String COLUMN_TYPE = "type"; //nothing, pay, get, expenses, salary, asset

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT NOT NULL," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_COST + " INTEGER," +
                    COLUMN_CASH_FLOW + " INTEGER," +
                    COLUMN_DOWN_FLOW + " INTEGER," +
                    COLUMN_SHARES_OWNED + " INTEGER," +
                    COLUMN_TYPE + " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private Context context;

     public FinancialDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public FinancialDBHelper(Context context){
         super(context,DATABASE_NAME,null,1);
         this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public long insertContent (@NotNull String name, String description, int cost, int cashFlow,int downFlow,int sharesOwed,@NotNull String type ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_DESCRIPTION, description);
        contentValues.put(COLUMN_COST, cost);
        contentValues.put(COLUMN_CASH_FLOW, cashFlow);
        contentValues.put(COLUMN_DOWN_FLOW, downFlow);
        contentValues.put(COLUMN_SHARES_OWNED, sharesOwed);
        contentValues.put(COLUMN_TYPE, type);
        long newId = db.insert(TABLE_NAME, null, contentValues);
        return newId;
    }

    public Cursor getAllContent(){
         SQLiteDatabase db = this.getReadableDatabase();
         String sql = "SELECT * FROM " + TABLE_NAME;
         Cursor res = db.rawQuery(sql,null);
         return res;
    }
    public Cursor getDataWithCondition(String selection, String[] selectionArgs){
        SQLiteDatabase db = this.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_COST,
                COLUMN_CASH_FLOW,
                COLUMN_DOWN_FLOW,
                COLUMN_SHARES_OWNED,
                COLUMN_TYPE,
        };

//// Filter results WHERE "title" = 'My Title'
//        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
//        String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                COLUMN_ID + " DESC";

        Cursor cursor = db.query(
                TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        return cursor;
    }

    public int updateData(String selection, String[] selectionArgs, ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

// New value for one column
//        String title = "MyNewTitle";
//        ContentValues values = new ContentValues();
//        values.put(FeedEntry.COLUMN_NAME_TITLE, title);

// Which row to update, based on the title
//        String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
//        String[] selectionArgs = { "MyOldTitle" };

        int count = db.update(
                TABLE_NAME,
                contentValues,
                selection,
                selectionArgs);
        return count;
    }
}
