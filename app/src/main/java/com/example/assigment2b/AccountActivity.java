package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    private TextView txtUsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        this.txtUsr = (TextView) findViewById(R.id.lblUser);

        Intent i = getIntent();
        String username = i.getStringExtra("username");
        if (username == null) {
            txtUsr.setText("Log In");
        }else {
            txtUsr.setText(username);
        }
    }
    //For username across pages/activities
    public TextView txtU;


    public void showLogIn(View view) {

        Intent i = new Intent(this, LogInActivity.class);
        startActivity(i);
    }

    public void showHome(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        startActivity(i);
    }

    public void showWish(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        startActivity(i);
    }

    public void showCollection(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        startActivity(i);
    }

    public void showAccount(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, AccountActivity.class);
        i.putExtra("username", txtU.getText().toString());
        startActivity(i);
    }
}