package com.example.practical14;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "salesman.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "orders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_ITEM = "item";
    private static final String COLUMN_QTY = "quantity";

    public Practical14DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PHONE + " TEXT,"
                + COLUMN_ITEM + " TEXT,"
                + COLUMN_QTY + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert order
    public long addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PHONE, order.getPhone());
        values.put(COLUMN_ITEM, order.getItem());
        values.put(COLUMN_QTY, order.getQuantity());
        return db.insert(TABLE_NAME, null, values);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Order order = new Order();
                order.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                order.setPhone(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE)));
                order.setItem(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ITEM)));
                order.setQuantity(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QTY)));
                orders.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orders;
    }
}