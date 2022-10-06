package com.example.foodorderappanother;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


import com.example.foodorderappanother.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table users " +
                        "(username Text primary key ," +
                        " password Text)"
        );


        sqLiteDatabase.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement ," +
                        "price int ," +
                        "image int ," +
                        "quantity int ," +
                        "description text ," +
                        "foodname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP table if exists orders");
        sqLiteDatabase.execSQL("DROP table if exists users");

        onCreate(sqLiteDatabase);
    }


    public Boolean insertData(String username, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password", password);
        long result = database.insert("users",null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where username = ?",new String[]{username});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkusernamePassword(String username, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where username = ? and password = ?",new String[]{username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean insertOrder(int price, int image, String description, String foodname, int quantity)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("price" , price);
        values.put("image" , image);
        values.put("description" , description);
        values.put("foodname" , foodname);
        values.put("quantity" , quantity);

        long id = database.insert("orders" , null, values);
        if (id <= 0){
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList<OrdersModel> getOrders() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders" , null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0) + "");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) + "");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    public Cursor getOrderById(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = "+id , null);

        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

    public boolean updateOrder(int id , int price, int image, String description, String foodname, int quantity) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", id);
        values.put("price", price);
        values.put("image", image);
        values.put("description", description);
        values.put("foodname", foodname);
        values.put("quantity", quantity);

        long row = database.update("orders", values, "id = " + id, null);
        if (row <= 0){
            return false;
        }
        else {
            return true;
        }
    }

    public int deletedOrder(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders" , "id="+id , null);

    }


}

