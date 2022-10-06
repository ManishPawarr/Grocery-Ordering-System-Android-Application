package com.example.foodorderappanother;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderappanother.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    TextView addq,subq;
    TextView quantitynumber , pricetag;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addq = findViewById(R.id.add);
        subq = findViewById(R.id.subtract);
        quantitynumber = findViewById(R.id.quantity);
        pricetag = findViewById(R.id.pricelabel);

        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type", 0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");

            binding.detailImage.setImageResource(image);
            binding.pricelabel.setText(String.format("%d", price));
            binding.productname.setText(name);
            binding.detailDescription.setText(description);

            addq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int basePrice = price;
                    quantity++;
                    displayQuantity();
                    int pricevalue = basePrice * quantity;
                    String setNewPrice = String.valueOf(pricevalue);
                    pricetag.setText(setNewPrice);

                }
            });

            subq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int basePrice = price;
                    if (quantity == 0)
                    {
                        Toast.makeText(DetailActivity.this, "Can't Decrese value below 0", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        quantity--;
                        displayQuantity();
                        int pricevalue = basePrice * quantity;
                        String setNewPrice = String.valueOf(pricevalue);
                        pricetag.setText(setNewPrice);
                    }

                }
            });


            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isInserted = helper.insertOrder(
                            Integer.parseInt(pricetag.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            name,
//                            Integer.parseInt(binding.quantity.getText().toString())
                            Integer.parseInt(quantitynumber.getText().toString())
                    );

                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor = helper.getOrderById(id);

            int image = cursor.getInt(2);

            binding.detailImage.setImageResource(image);
            binding.pricelabel.setText(String.format("%d", cursor.getInt(1)));
            binding.productname.setText(cursor.getString(5));
            binding.detailDescription.setText(cursor.getString(4));   /*This value of colIndex are from DBHelper.java*/
            binding.insertButton.setText("Update Now");
            addq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int updateprice = Integer.parseInt(pricetag.getText().toString());
                    int basePrice = updateprice;
                    quantity++;
                    displayQuantity();
                    int pricevalue = basePrice * quantity;
                    String setNewPrice = String.valueOf(pricevalue);
                    pricetag.setText(setNewPrice);

                }
            });

            subq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int updateprice = Integer.parseInt(pricetag.getText().toString());
                    int basePrice = updateprice;
                    if (quantity == 0)
                    {
                        Toast.makeText(DetailActivity.this, "Can't Decrese value below 0", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        quantity--;
                        displayQuantity();
                        int pricevalue = basePrice * quantity;
                        String setNewPrice = String.valueOf(pricevalue);
                        pricetag.setText(setNewPrice);
                    }

                }
            });
            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdated = helper.updateOrder(
                            id,
                            Integer.parseInt(pricetag.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.productname.getText().toString(),
                            1
                    );
                    if (isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }
}