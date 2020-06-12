package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inventory extends AppCompatActivity {
    //Variables
    DatabaseHelper dbHelper;
    private Button buttonAdd, buttonView, buttonBack;
    private EditText inputName, inputBrand, inputStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        //Set Up User Interface Values
        buttonAdd = findViewById(R.id.addItem);
        buttonView = findViewById(R.id.viewItems);
        buttonBack = findViewById(R.id.backButton);
        inputName = findViewById(R.id.nameInput);
        inputBrand = findViewById(R.id.brandInput);
        inputStock = findViewById(R.id.stockInput);
        dbHelper = new DatabaseHelper(this);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inventory.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Values In Inputs and Run Add Item Function
                String nameInput = inputName.getText().toString();
                String brandInput = inputBrand.getText().toString();
                String stockInput = inputStock.getText().toString();
                AddItem(nameInput, brandInput, stockInput);
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Runs View Intent
                Intent intent = new Intent(inventory.this, ViewListItem.class);
                startActivity(intent);
            }
        });

    }

    public void AddItem(String name, String brand, String stock) {
        //Runs Add Item Function
        boolean addResult = dbHelper.addItem(name, brand, stock);
        //Resets Text To Empty
        inputName.setText("");
        inputBrand.setText("");
        inputStock.setText("");
        //Displays Message Feedback
        if(addResult) {
            toastMessage("Item Inserted");
        } else {
            toastMessage("Error");
        }

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
