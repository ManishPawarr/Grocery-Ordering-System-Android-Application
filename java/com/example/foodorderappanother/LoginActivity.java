package com.example.foodorderappanother;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    EditText userlogin, passwordlogin;
    TextView textView;
    Button loginButton;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView) findViewById(R.id.wantsignup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CustomersActivity.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Please SignUp", Toast.LENGTH_LONG).show();
            }
        });

        userlogin = (EditText) findViewById(R.id.userloginBox);
        passwordlogin = (EditText) findViewById(R.id.passwordloginBox);
        loginButton = (Button) findViewById(R.id.loginButton);

        myDB = new DBHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userlogin.getText().toString();
                String password = passwordlogin.getText().toString();

                if (username.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter username and password.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.checkusernamePassword(username,password);
                    if (result==true)
                    {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }   else
                        {
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
