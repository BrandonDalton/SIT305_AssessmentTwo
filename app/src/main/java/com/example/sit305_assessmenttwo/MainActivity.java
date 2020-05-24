package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Variable Declarations

    //Menu Options Array
    String menuOptions[] = {"Option One", "Option Two", "Option Three", "Option Four"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List Creation
        final ListView menuList = (ListView)findViewById(R.id.mainMenuList);
        //Assigning Data To Adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuOptions);
        //Linking Adapter Data to listView to populate
        menuList.setAdapter(adapter);
    }
}
