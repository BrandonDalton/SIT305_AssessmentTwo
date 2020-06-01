package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inventory extends AppCompatActivity {

    DatabaseHelper dbHelper;
    private Button buttonAdd, buttonView;
    private EditText inputName, inputBrand, inputStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        buttonAdd = findViewById(R.id.addButton);
        buttonView = findViewById(R.id.viewItems);
        inputName = findViewById(R.id.nameInput);
        inputBrand = findViewById(R.id.brandInput);
        inputStock = findViewById(R.id.stockInput);
        dbHelper = new DatabaseHelper(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = inputName.getText().toString();
                String brandInput = inputBrand.getText().toString();
                String stockInput = inputStock.getText().toString();
                AddItem(nameInput, brandInput, stockInput);
                //Error Handling
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inventory.this, ViewListItem.class);
                startActivity(intent);
            }
        });

    }

    public void AddItem(String name, String brand, String stock) {
        boolean addResult = dbHelper.addItem(name, brand, stock);
        inputName.setText("");
        inputBrand.setText("");
        inputStock.setText("");

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
