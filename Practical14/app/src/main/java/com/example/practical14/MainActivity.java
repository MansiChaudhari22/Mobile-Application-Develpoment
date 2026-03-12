package com.example.practical14;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button takeOrderBtn, viewOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takeOrderBtn = findViewById(R.id.btn_take_order);
        viewOrderBtn = findViewById(R.id.btn_view_order);

        takeOrderBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TakeOrderActivity.class)));

        viewOrderBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ViewOrderActivity.class)));
    }
}