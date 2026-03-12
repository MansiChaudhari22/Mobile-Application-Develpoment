package com.example.practical14;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewOrderActivity extends AppCompatActivity {

    ListView listView;
    Practical14DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        listView = findViewById(R.id.list_orders);
        dbHelper = new Practical14DatabaseHelper(this);

        loadOrders();
    }

    private void loadOrders() {
        List<Order> orders = dbHelper.getAllOrders();
        List<String> displayList = new ArrayList<>();
        for(Order o : orders){
            displayList.add("Phone: " + o.getPhone() + "\nItem: " + o.getItem() + "\nQty: " + o.getQuantity());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
    }
}