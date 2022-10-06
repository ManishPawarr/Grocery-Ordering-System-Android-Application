package com.example.foodorderappanother;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomersActivity extends AppCompatActivity {

    EditText nameBox, phoneBox, emailaddressBox, addressBox, cityBox, pincodeBox, nearbylandmarkBox, usernameBox, passwordBox, confirmpasswordBox;
    Button registerButton;
    DBHelper myDB;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        textView = (TextView) findViewById(R.id.wantsignup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomersActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(CustomersActivity.this, "Please Login", Toast.LENGTH_LONG).show();
            }
        });
        final DBHelper helper = new DBHelper(this);
        nameBox = (EditText)findViewById(R.id.nameBox2);
        phoneBox = (EditText) findViewById(R.id.phoneBox2);
        emailaddressBox = (EditText) findViewById(R.id.emailaddressBox);
        addressBox = (EditText) findViewById(R.id.addressBox);
        cityBox = (EditText) findViewById(R.id.cityBox);
        pincodeBox = (EditText) findViewById(R.id.pincodeBox);
        nearbylandmarkBox = (EditText) findViewById(R.id.nearbylandmarkBox);
        usernameBox = (EditText) findViewById(R.id.usernameBox);
        passwordBox = (EditText) findViewById(R.id.passwordBox);
        confirmpasswordBox = (EditText) findViewById(R.id.confirmpasswordBox);

        registerButton= (Button)findViewById(R.id.registerButton);

        myDB = new DBHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameBox.getText().toString();
                String phone = phoneBox.getText().toString();
                String emailaddress = emailaddressBox.getText().toString();
                String address = addressBox.getText().toString();
                String city = cityBox.getText().toString();
                String pincode = pincodeBox.getText().toString();
                String nearbylandmark = nearbylandmarkBox.getText().toString();
                String username = usernameBox.getText().toString();
                String password = passwordBox.getText().toString();
                String confirmpassword = confirmpasswordBox.getText().toString();

                if (name.equals("") || phone.equals("") || emailaddress.equals("") || address.equals("") || city.equals("") || pincode.equals("") || nearbylandmark.equals("") ||username.equals("") || password.equals("") || confirmpassword.equals("") )
                {
                    Toast.makeText(CustomersActivity.this, "Fill all the fields.", Toast.LENGTH_SHORT).show();
                }else {
                    if (password.equals(confirmpassword))
                    {
                        Boolean usercheckResult = myDB.checkusername(username);
                        if (usercheckResult == false)
                        {
                            Boolean regResult = myDB.insertData(username,password);
                            if (regResult == true)
                            {


                                Toast.makeText(CustomersActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(CustomersActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(CustomersActivity.this, "User already exists. \n Please Sign In ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(CustomersActivity.this, "Password Not Matching.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
