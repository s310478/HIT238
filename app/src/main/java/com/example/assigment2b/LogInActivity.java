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

        //this.spin = (Spinner) findViewById(R.id.cmbRole);

        // String variables to hold values
        public String Username, Email, Password;


        public void btnLogInandRegister (View view) {

            // Initialize the variables with UI components
            txtU = (EditText) findViewById(R.id.txtUsername);
            txtE = (EditText) findViewById(R.id.txtEmail);
            txtP = (EditText) findViewById(R.id.txtPassword);

            // Extract the string values from the UI components
            Username = txtU.getText().toString();
            Email = txtE.getText().toString();
            Password = txtP.getText().toString();

            // Booleans for log in & register authentication
            Boolean isLogIn = true;
            Boolean isRegister = true;

            // Identifies button pressed
            boolean isLoginButton = view.getId() == R.id.btnLogIn;
            boolean isRegisterButton = view.getId() == R.id.btnRegister;
            // Identify role choice
            Spinner spinner = findViewById(R.id.cmbRole);
            String Role = spinner.getSelectedItem().toString();

            // Logic for log in
            if (isLoginButton) {
                if ((!Username.isEmpty() || !Email.isEmpty() && Email.contains("@")) && !Password.isEmpty()) {
                    // Navigate to home activity after successful login
                    Intent i = new Intent(this, HomeActivity.class);
                    i.putExtra("username", Username);
                    i.putExtra("email", Email);
                    i.putExtra("password", Password);
                    i.putExtra("role", Role);
                    startActivity(i);
                } else {
                    if (Username.isEmpty() && Email.isEmpty()) {
                        txtU.setError("Either Username or Email is required");
                        txtE.setError("Either Username or Email is required");
                    } else if (!Email.isEmpty() && !Email.contains("@")) {
                        txtE.setError("A valid Email is required '@'");
                    }
                    if (Password.isEmpty()) {
                        txtP.setError("Password is required");
                    }
                }
            }

            // Logic for registration
            if (isRegisterButton) {
                if (!Username.isEmpty() && !Email.isEmpty() && Email.contains("@") && !Password.isEmpty()) {
                    // Navigate to home activity after successful registration
                    Intent i = new Intent(this, HomeActivity.class);
                    i.putExtra("username", Username);
                    i.putExtra("email", Email);
                    i.putExtra("password", Password);
                    i.putExtra("role", Role);
                    startActivity(i);
                } else {
                    if (Username.isEmpty()) txtU.setError("Name is required");
                    if (Email.isEmpty() || !Email.contains("@"))
                        txtE.setError("Valid Email is required '@'");
                    if (Password.isEmpty()) txtP.setError("Password is required");
                }
            }
        }


    //Nav bar
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