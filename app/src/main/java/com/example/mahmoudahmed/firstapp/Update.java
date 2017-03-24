package com.example.mahmoudahmed.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    Button update;
    DatabaseManager databaseManager;
    EditText newName;
    EditText newPrice;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update= (Button) findViewById(R.id.updateButton);
        newPrice= (EditText) findViewById(R.id.price);
        newName= (EditText) findViewById(R.id.name);
        id= (EditText) findViewById(R.id.id);

        databaseManager=new DatabaseManager(getApplicationContext());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product=new Product
                        (Integer.parseInt(id.getText().toString()),
                                newName.getText().toString(),Integer.parseInt(newPrice.getText().toString()));
                databaseManager.updateProduct(product);

            }
        });
    }
}
