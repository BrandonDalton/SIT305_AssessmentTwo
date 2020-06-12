package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewListItem extends AppCompatActivity {
    //Variable Declaration
    DatabaseHelper db;
    item item;
    ArrayList<item> itemlists;
    ListView resultsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_item);
        //Variable & Object Declaration
        resultsListView = findViewById(R.id.listView);
        db = new DatabaseHelper(this);
        itemlists = new ArrayList<>();
        //Run Populate List
        populateList();

    }

    private void populateList() {
        //Run Get Items Which Retrieves All Items Within In List
        Cursor results = db.getItems();

        //While There Is A Result
        while(results.moveToNext()) {
            //Get The Strings In Each Column
           item = new item(results.getString(1), results.getString(2), results.getString(3));
           //Add It To List
           itemlists.add(item);
        }
        //Display List
        itemListViewAdapter adapter = new itemListViewAdapter(this, R.layout.list_adapter_adapter , itemlists);
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

                } if(errorID > -1) {
                    Intent editScreen = new Intent(ViewListItem.this, editItem.class);
                    //If Item Is Clicked Go To Edit Screen Activity and Pass Through Values
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
