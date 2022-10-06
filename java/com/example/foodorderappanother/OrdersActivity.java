package com.example.foodorderappanother;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderappanother.Adapters.OrdersAdapter;
import com.example.foodorderappanother.Models.MainModel;
import com.example.foodorderappanother.Models.OrdersModel;
import com.example.foodorderappanother.databinding.ActivityDetailBinding;
import com.example.foodorderappanother.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();


        OrdersAdapter adapter = new OrdersAdapter(list , this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);

    }

}
