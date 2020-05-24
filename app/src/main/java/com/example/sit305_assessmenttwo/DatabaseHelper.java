package com.example.sit305_assessmenttwo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int databaseVer = 1;

    private static final String databaseName = "itemDatabase";

    private static final String tableName = "itemTable";

    private static final String id = "id";
    private static final String itemID = "item_id";
    private static final String name = "name";
    private static final String brand = "brand";
    private static final String stock = "stock";

    // Table Create Statements
    private static final String createTable = "CREATE TABLE "
            + tableName + "(" + id + " INTEGER PRIMARY KEY,"
            + itemID + " INTEGER," + name + "TEXT," + brand + "TEXT," + stock + "INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVer);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS itemTable");
        // create new tables
        onCreate(db);
    }

    //Insert Commands

    public long createToDo(item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(itemID, item.getId());
        values.put(name, item.getId());
        values.put(brand, item.getId());
        values.put(stock, item.getId());
        long result = db.insert(tableName, null, values);
        return result;
    }

}


