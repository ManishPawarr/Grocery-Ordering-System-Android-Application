package com.example.foodorderappanother;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderappanother.Adapters.MainAdapter;
import com.example.foodorderappanother.Models.MainModel;
import com.example.foodorderappanother.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.wheat, "Sharbati Whole Wheat Atta" , "391" , "10 Kg"));
        list.add(new MainModel(R.drawable.rice, "Basmati Rice (Long Grain)" , "589" , "10 Kg"));
        list.add(new MainModel(R.drawable.sugar, "Organic Tattva Brown Sugar" , "129" , "1 Kg"));
        list.add(new MainModel(R.drawable.salt, "Tata Iodized Salt" , "21" , "1 Kg"));
        list.add(new MainModel(R.drawable.chilipowder, "Aditya's Chilli Powder" , "375" , "1 Kg"));
        list.add(new MainModel(R.drawable.cookingoil, "Sunflower Cooking Oil Can" , "249" , "1 L"));
        list.add(new MainModel(R.drawable.cashew, "Indian Whole Cashews" , "489" , "500 g"));
        list.add(new MainModel(R.drawable.almond, "Fit Popular Almonds" , "150" , "500 g"));
        list.add(new MainModel(R.drawable.pistachios, "Roasted and Salted Pistachios" , "499" , "500 g"));
        list.add(new MainModel(R.drawable.saffron, "Patanjali Saffron" , "160" , "1 g"));
        list.add(new MainModel(R.drawable.makhana, " Foods Roasted Makhana" , "499" , "1 Kg"));
        list.add(new MainModel(R.drawable.strawberry, "Smint Sugarfree Strawberry" , "225" , "200 g"));
        list.add(new MainModel(R.drawable.blueberry, "Premium Dried Blueberry" , "199" , "200 g"));
        list.add(new MainModel(R.drawable.raspberry, "Manish's Raspberry" , "149" , "200 g"));
        list.add(new MainModel(R.drawable.toordal, "Toor Dal (Split) " , "140" , "1 Kg"));
        list.add(new MainModel(R.drawable.moongdal, "Yellow Moong Dal (Split)" , "125" , "1Kg"));
        list.add(new MainModel(R.drawable.chanadal, "Classic Chana Dal (Split)" , "90" , "1 Kg"));
        list.add(new MainModel(R.drawable.redmasoordal, "Organic Red Masoor Dal (Split)" , "115" , "1 Kg"));
        list.add(new MainModel(R.drawable.mixdal, "Organics Organic Mix Dal (Split)" , "225" , "1 Kg"));
        list.add(new MainModel(R.drawable.mariegold, "Marie Gold Biscuits" , "105" , "1000 g(Pack of 5)"));
        list.add(new MainModel(R.drawable.parleg, "Parle G Gold Biscuits" , "112" , "1 Kg"));
        list.add(new MainModel(R.drawable.oreo, "Oreo Choco Creme Cookies" , "72" , "300 g"));
        list.add(new MainModel(R.drawable.darkfantasy, "Sunfeast Dark Choco Biscuits" , "212" , "600 g(Pack of 2)"));
        list.add(new MainModel(R.drawable.goodday, "Good Day Cookies" , "45" , "200 g"));
        list.add(new MainModel(R.drawable.maaza, "Maaza Mango" , "65" , "1.2 L"));
        list.add(new MainModel(R.drawable.sprite, "Sprite PET Bottle" , "89" , "2.25 L"));
        list.add(new MainModel(R.drawable.pepsi, "Pepsi Plastic Bottle" , "82" , "2.25 L"));
        list.add(new MainModel(R.drawable.mirinda, "Mirinda Plastic Bottle" , "82" , "2.25 L"));
        list.add(new MainModel(R.drawable.maggie, "Maggi Masala Noodles" , "136" , "12 x 70 g"));
        list.add(new MainModel(R.drawable.noodles, "Ching's Secret Noodles" , "83" , "600 g"));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ordersicon:
                startActivity(new Intent(MainActivity.this , OrdersActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}