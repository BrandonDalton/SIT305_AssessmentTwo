package com.example.sit305_assessmenttwo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Name of Database If Needed in Future
    private  static  final String db_name = "items.db";
    //Variables For The SQL Table
    private static final String tb_name = "items_table";
    private static final String col_1 = "ID";
    private static final String col_2 = "name";
    private static final String col_3 = "brand";
    private static final String col_4 = "stock";

    public DatabaseHelper(Context context) {
        super(context, tb_name, null, 1);
    }
    //First Time Running Will Create The Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable  = "CREATE TABLE " + tb_name + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, " + col_2 +" TEXT," + col_3 +" TEXT," + col_4 +" TEXT)";

        db.execSQL(createTable);
    }
    //If Table Needs To Be Upgraded Drop The Old Table then Run Create
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tb_name);
        onCreate(db);

    }
    //Add Item To Row
    public boolean addItem(String name, String brand, String stock) {
        //Prep Database To Be Written To
        SQLiteDatabase db = this.getWritableDatabase();
        //Values To Be Inputted
        ContentValues inputs = new ContentValues();
        inputs.put(col_2, name);
        inputs.put(col_3, brand);
        inputs.put(col_4, stock);
        //Run Insert Function
        //Function Returns a Long -1 if the Insert Fails
        //Will Use The Value To Determine If It Was Successful
        long result = db.insert(tb_name, null, inputs);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    //Update Item Based On Selected Item
    public void updateItem(int id, String newName, String newBrand, String newStock) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Query To Be Passed
        String query = "UPDATE " + tb_name + " SET " + col_2 + " = '" +  newName + "', " + col_3 + " = '" +  newBrand + "', " +  col_4 + " = '" +  newStock + "' WHERE " + col_1 + " = '" + id + "'";
        //Executes The Query
        db.execSQL(query);
    }

    //Deletes The Item Based on the ID and Name Selected
    public void deleteItem(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Query
        String query = "DELETE FROM " + tb_name + " WHERE " + col_1 + " = '" + id + "'" + " AND " + col_2 + " = '" + name + "'";
        //Executes The Query
        db.execSQL(query);
    }
    //Retrieves The Items
    public Cursor getItems() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Get All Items
        String query = "SELECT * FROM " + tb_name;
        //Query is Returned as Cursor to Iterate Through
        Cursor results = db.rawQuery(query, null);
        return results;
    }
    //Retrieves The Item ID from the Database
    public Cursor getItemID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + col_1 + " FROM " + tb_name + " WHERE " + col_2 + " = '" + name + "'";
        Cursor results = db.rawQuery(query, null);
        return results;
    }
}
