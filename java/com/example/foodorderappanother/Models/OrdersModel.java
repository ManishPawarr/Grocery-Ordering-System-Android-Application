package com.example.foodorderappanother.Models;

import android.os.Bundle;
import android.widget.TextView;

import com.example.foodorderappanother.DetailActivity;
import com.example.foodorderappanother.databinding.ActivityDetailBinding;
import com.example.foodorderappanother.databinding.ActivityOrdersBinding;

public class OrdersModel {


    int orderImage;
    String soldItemName , price , orderNumber;


    public OrdersModel() {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
