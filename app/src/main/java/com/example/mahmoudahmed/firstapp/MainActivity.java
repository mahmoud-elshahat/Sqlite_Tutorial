package com.example.mahmoudahmed.firstapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.mahmoudahmed.firstapp.R.id.update;


public class MainActivity extends AppCompatActivity {
    Button ADD;
    Button DELETE;
    Button UPDATE;
    ListView listView;
    ArrayList<String> values;
    ArrayList<Product>products;
    DatabaseManager databaseManager;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseManager=new DatabaseManager(MainActivity.this);
        listView= (ListView) findViewById(R.id.list);
        ADD= (Button) findViewById(R.id.add);
        DELETE= (Button) findViewById(R.id.delete);
        UPDATE= (Button) findViewById(update);

        products=new ArrayList<>();
        products=databaseManager.getAll();
        values =new ArrayList<>();
        if(products!=null)
        {
            for(int i=0 ;i<products.size();i++)
            {
                String line=products.get(i).id+"    "+products.get(i).name+"    "+products.get(i).price;
                values.add(line);
            }
            adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,values);
            listView.setAdapter(adapter);
        }



        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ADD.class);
                startActivity(intent);
            }
        });
        UPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Update.class);
                startActivity(intent);
            }
        });
        DELETE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Delete.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Update();
    }

    public void Update()
    {
        products=databaseManager.getAll();
        if(products!=null)
        {
            values=new ArrayList<>();
            Log.v("TAG","HERE");
            for(int i=0 ;i<products.size();i++)
            {
                String line=products.get(i).id+"    "+products.get(i).name+"    "+products.get(i).price;
                values.add(line);
            }
            adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,values);
            listView.setAdapter(adapter);
        }
    }
}
