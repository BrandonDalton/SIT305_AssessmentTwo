package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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
    }
}
