package com.example.sit305_assessmenttwo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static  final String db_name = "items.db";

    private static final String tb_name = "items_table";
    private static final String col_1 = "ID";
    private static final String col_2 = "name";
    private static final String col_3 = "brand";
    private static final String col_4 = "stock";

    public DatabaseHelper(Context context) {
        super(context, tb_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable  = "CREATE TABLE " + tb_name + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, " + col_2 +" TEXT," + col_3 +" TEXT," + col_4 +" TEXT)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tb_name);
        onCreate(db);

    }

    public boolean addItem(String name, String brand, String stock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues inputs = new ContentValues();
        inputs.put(col_2, name);
        inputs.put(col_3, brand);
        inputs.put(col_4, stock);

        long result = db.insert(tb_name, null, inputs);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getItems() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + tb_name;
        Cursor results = db.rawQuery(query, null);
        return results;
    }



}
