package com.example.practical14;

public class Order {
    private int id;
    private String phone;
    private String item;
    private int quantity;

    public Order() {}

    public Order(int id, String phone, String item, int quantity) {
        this.id = id;
        this.phone = phone;
        this.item = item;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}