package com.example.practical14;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TakeOrderActivity extends AppCompatActivity {

    EditText etPhone, etItem, etQuantity;
    Button btnSave;
    Practical14DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_order);

        etPhone = findViewById(R.id.et_phone);
        etItem = findViewById(R.id.et_item);
        etQuantity = findViewById(R.id.et_quantity);
        btnSave = findViewById(R.id.btn_save);

        dbHelper = new Practical14DatabaseHelper(this);

        btnSave.setOnClickListener(v -> {
            String phone = etPhone.getText().toString().trim();
            String item = etItem.getText().toString().trim();
            String qtyStr = etQuantity.getText().toString().trim();

            if(phone.isEmpty() || item.isEmpty() || qtyStr.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int qty = Integer.parseInt(qtyStr);
            Order order = new Order();
            order.setPhone(phone);
            order.setItem(item);
            order.setQuantity(qty);

            long id = dbHelper.addOrder(order);
            if(id > 0){
                Toast.makeText(this, "Order saved", Toast.LENGTH_SHORT).show();
                etPhone.setText("");
                etItem.setText("");
                etQuantity.setText("");
            } else {
                Toast.makeText(this, "Error saving order", Toast.LENGTH_SHORT).show();
            }
        });
    }
}