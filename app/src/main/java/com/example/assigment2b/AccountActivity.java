package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void showLogIn(View view) {

        Intent i = new Intent(this, LogInActivity.class);
        startActivity(i);
    }

    public void showHome(View view) {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void showWish(View view) {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void showCollection(View view) {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void showAccount(View view) {

        Intent i = new Intent(this, AccountActivity.class);
        startActivity(i);
    }
}