package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TextView txtUsr;
    public TextView txtU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        this.txtUsr = (TextView) findViewById(R.id.lblUser);

        // Display username entered at log in activity, otherwise 'Log In' is displayed.
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        if (username == null) {
            txtUsr.setText("Log In");
        }else {
            txtUsr.setText(username);
        }
    }

    // Wish notification
   public void addWish(View view) {

       Toast.makeText(getApplicationContext(), "Added to Wishlist", Toast.LENGTH_LONG).show();
   }

   // Collection notification
    public void addCollection(View view) {

        Toast.makeText(getApplicationContext(), "Added to Collection", Toast.LENGTH_LONG).show();
    }





    //Bottom task bar & log in buttons
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

        //Change this to WishActivity.class when created
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        startActivity(i);
    }

    public void showCollection(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        //Change this to CollectionActivity.class when created
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