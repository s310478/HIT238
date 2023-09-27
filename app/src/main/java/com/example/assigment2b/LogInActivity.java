package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    //private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

        // Variables for Username, Email, Password, Log in & Register buttons
        public EditText txtU;
        public EditText txtE;
        public EditText txtP;
        public Button btnL;
        public Button btnR;

        //this.spin = (Spinner) findViewById(R.id.cmbRole);

        // String variables to hold values
        public String Username, Email, Password;


        public void btnLogInandRegister (View view){

            // Initialize the variables with UI components
            txtU = (EditText) findViewById(R.id.txtUsername);
            txtE = (EditText) findViewById(R.id.txtEmail);
            txtP = (EditText) findViewById(R.id.txtPassword);
            btnL = (Button) findViewById(R.id.btnLogIn);
            btnR = (Button) findViewById(R.id.btnRegister);

            // Extract the string values from the UI components
            Username = txtU.getText().toString();
            Email = txtE.getText().toString();
            Password = txtP.getText().toString();

            // Booleans for log in & register authentication
            // isUEmpty = false;
            Boolean isLogIn = true;
            Boolean isRegister = true;


            if (Username.isEmpty() == true) {
                txtU.setError("Name is a required field");
                isLogIn = false;
                isRegister = false;
                //isUEmpty = true;

            }

            if (Email.isEmpty() == true || Email.indexOf('@') == -1) {
                txtE.setError("Email is either empty or incorrectly formatted");
                isLogIn = true;
                isRegister = false; //not working

            }

            if (Password.isEmpty() == true) {
                txtP.setError("Password is a required field");
                isLogIn = false;
                isRegister = false;

            }

            if (isLogIn == true) {

                Intent i = new Intent(this, HomeActivity.class);
                i.putExtra("username", txtU.getText().toString());
                i.putExtra("email", txtE.getText().toString());
                i.putExtra("password", txtP.getText().toString());

                startActivity(i);
            }

            if (isRegister == true) {

                Intent i = new Intent(this, HomeActivity.class);
                i.putExtra("username", txtU.getText().toString());
                i.putExtra("email", txtE.getText().toString());
                i.putExtra("password", txtP.getText().toString());

                startActivity(i);
            }

        }

    //Bottom nav bar
    public void showHome(View view) {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    //Change class bellow to WishActivity when created
    public void showWish(View view) {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }
    //Change class bellow to CollectionActivity when created
    public void showCollection(View view) {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void showAccount(View view) {

        Intent i = new Intent(this, AccountActivity.class);
        startActivity(i);
    }

}