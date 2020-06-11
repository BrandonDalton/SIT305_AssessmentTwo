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
        inputName = findViewById(R.id.nameInput);
        inputBrand = findViewById(R.id.brandInput);
        inputStock = findViewById(R.id.stockInput);
        buttonEdit = findViewById(R.id.editItems);
        buttonDelete = findViewById(R.id.deleteItem);
        dbHelper = new DatabaseHelper(this);

        Intent receivedIntent = getIntent();

        itemID = receivedIntent.getIntExtra("id", -1);
        itemNameOld = receivedIntent.getStringExtra("itemName");
        brandName = receivedIntent.getStringExtra("brandName");
        stock = receivedIntent.getStringExtra("stock");

        inputName.setText(itemNameOld);
        inputBrand.setText(brandName);
        inputStock.setText(stock);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = inputName.getText().toString();
                String brandName = inputBrand.getText().toString();
                String stock = inputStock.getText().toString();

                dbHelper.updateItem(itemID, itemName, brandName, stock);
                Intent intent = new Intent(editItem.this, inventory.class);
                startActivity(intent);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteItem(itemID, itemNameOld);
                Intent intent = new Intent(editItem.this, inventory.class);
                startActivity(intent);
            }
        });

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
