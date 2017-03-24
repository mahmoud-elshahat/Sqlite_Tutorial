package com.example.mahmoudahmed.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete extends AppCompatActivity {

    Button delete;
    EditText  id;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        databaseManager=new DatabaseManager(getApplicationContext());
        id= (EditText) findViewById(R.id.id);
        delete= (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.deleteProduct(Integer.parseInt(id.getText().toString()));
            }
        });
    }
}
