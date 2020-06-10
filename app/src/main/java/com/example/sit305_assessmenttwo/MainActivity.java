package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Variable Declarations

    //Menu Options Array
    String menuOptions[] = {"Inventory Management", "Image Taker", "Information Centre", "Option Four"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity Intent Creation
        final Intent inventoryActivity =  new Intent(this, inventory.class);
        final Intent imagecaptureActivity =  new Intent(this, imagecapture.class);
        final Intent youtubeActivity = new Intent(this, youtubeactivity.class);


        //List Creation
        final ListView menuList = (ListView)findViewById(R.id.mainMenuList);
        //Assigning Data To Adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuOptions);
        //Linking Adapter Data to listView to populate
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //If Click Is First Item
                if (position == 0) {
                    startActivity(inventoryActivity);

                }
                //If Click Is Second Item
                if (position == 1) {
                    startActivity(imagecaptureActivity);
                }
                //If Click Is Third Item
                if (position == 2) {
                    startActivity(youtubeActivity);
                }
                //If Click Is Fourth Item
                if (position == 3) {

                }
            }
        });
    }
}
