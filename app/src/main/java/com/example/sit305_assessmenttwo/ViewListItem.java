package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewListItem extends AppCompatActivity {

    DatabaseHelper db;
    item item;
    ArrayList<item> itemlists;
    ListView resultsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_item);
        resultsListView = findViewById(R.id.listView);
        db = new DatabaseHelper(this);
        itemlists = new ArrayList<>();
        
        populateList();

    }

    private void populateList() {
        Cursor results = db.getItems();


        while(results.moveToNext()) {
           item = new item(results.getString(1), results.getString(2), results.getString(3));
           itemlists.add(item);
        }

        item_listAdapter adapter = new item_listAdapter(this, R.layout.list_adapter_adapter , itemlists);
        resultsListView.setAdapter(adapter);

        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Retrieve The Item
                item name = (com.example.sit305_assessmenttwo.item) parent.getItemAtPosition(position);
                //Get The Name of The Item
                String itemName = name.getName();
                String brandName = name.getBrand();
                String stock = name.getStock();

                //Get ID Of Item
                Cursor result = db.getItemID(itemName);
                
                //Give Something incase of null value to not break App

                int errorID = -1;
                while(result.moveToNext()) {
                    errorID = result.getInt(0);
                    Log.d("tests" , "ID IS" + errorID);

                } if(errorID > -1) {
                    Intent editScreen = new Intent(ViewListItem.this, editItem.class);
                    editScreen.putExtra("id", errorID);
                    editScreen.putExtra("itemName", itemName);
                    editScreen.putExtra("brandName", brandName);
                    editScreen.putExtra("stock", stock);
                    startActivity(editScreen);

                } else {
                    toastMessage("No Item Is Listed");
                }

            }
        });
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
