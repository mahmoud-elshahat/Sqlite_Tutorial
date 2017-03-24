package com.example.mahmoudahmed.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ADD extends AppCompatActivity {

    EditText name;
    EditText price;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final DatabaseManager databaseManager=new DatabaseManager(getApplicationContext());

        name= (EditText) findViewById(R.id.name);
        price= (EditText) findViewById(R.id.price);
        add= (Button) findViewById(R.id.addButton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product=new Product(Integer.parseInt(price.getText().toString()),name.getText().toString());
                databaseManager.addProduct(product);
            }
        });

    }
}
