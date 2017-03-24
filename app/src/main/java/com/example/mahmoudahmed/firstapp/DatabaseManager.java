package com.example.mahmoudahmed.firstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Mahmoud Ahmed on 3/24/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="lol.db";
    private static final String TABLE_NAME="product";


    public DatabaseManager(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE product(id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT ,price INTEGER)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + "product");
        onCreate(db);
    }


    public void addProduct(Product contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query="INSERT INTO product(name,price) VALUES('"+contact.name+"',"+contact.price+")";
        db.execSQL(query);
        db.close();
    }
    public void updateProduct(Product contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query="UPDATE product SET name= '"+contact.name+"',"+"price = "+contact.price+" WHERE id="+contact.id;
        db.execSQL(query);
        db.close();
    }
    public void deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query="DELETE FROM product WHERE id="+id;
        db.execSQL(query);
        db.close();
    }
    public ArrayList<Product> getAll()
    {
        ArrayList<Product>products=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String Select="SELECT * FROM product";

        Cursor cursor = db.rawQuery(Select, null);
        if (cursor.moveToFirst()) {
            do {
                Product contact = new Product
                        (Integer.parseInt(cursor.getString(0)),cursor.getString(1),Integer.parseInt(cursor.getString(2)));
                products.add(contact);
            } while (cursor.moveToNext());
        }
        return products;
    }

}
