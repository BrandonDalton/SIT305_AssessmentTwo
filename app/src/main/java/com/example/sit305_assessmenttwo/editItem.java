package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editItem extends AppCompatActivity {
    //Variable Declaration
    DatabaseHelper dbHelper;

    private String itemNameOld;
    private String brandName;
    private String stock;
    private int itemID;

    private Button buttonEdit, buttonDelete;
    private EditText inputName, inputBrand, inputStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //Link UserInterface Values
        inputName = findViewById(R.id.nameInput);
        inputBrand = findViewById(R.id.brandInput);
        inputStock = findViewById(R.id.stockInput);
        buttonEdit = findViewById(R.id.editItems);
        buttonDelete = findViewById(R.id.deleteItem);
        //Create Database Helper For Functions
        dbHelper = new DatabaseHelper(this);
        //Get The Values from the previous Intent
        Intent receivedIntent = getIntent();

        //Get Old Values To Populate Field
        itemID = receivedIntent.getIntExtra("id", -1);
        itemNameOld = receivedIntent.getStringExtra("itemName");
        brandName = receivedIntent.getStringExtra("brandName");
        stock = receivedIntent.getStringExtra("stock");

        inputName.setText(itemNameOld);
        inputBrand.setText(brandName);
        inputStock.setText(stock);

        //Edit button is clicked
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Text Values
                String itemName = inputName.getText().toString();
                String brandName = inputBrand.getText().toString();
                String stock = inputStock.getText().toString();
                //Run Update Item Function
                dbHelper.updateItem(itemID, itemName, brandName, stock);
                //Send Back
                Intent intent = new Intent(editItem.this, inventory.class);
                startActivity(intent);
                toastMessage("Item Edited");
            }
        });
        //Delete Button Is Clicked
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Run Delete Item Function
                dbHelper.deleteItem(itemID, itemNameOld);
                //Send Back
                Intent intent = new Intent(editItem.this, inventory.class);
                startActivity(intent);
                toastMessage("Item Deleted");
            }
        });

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
