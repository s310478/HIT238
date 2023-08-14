package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        // Declaring the variables within a class-scope
        // so that all the variables are available for
        // both the button-methods.

        public EditText txtU;
        public EditText txtE;
        public EditText txtP;
        public Button btnL;
        public Button btnR;

    /*
       Similar types of variables can be declared
       in One line, for instance: Name, Phone
       and Email all are of type String
    */

        public String Username, Email, Password;


        public void btnLogIn (View view){

            // Getting a Reference to the Views
            txtU = (EditText) findViewById(R.id.txtUsername);
            txtE = (EditText) findViewById(R.id.txtEmail);
            txtP = (EditText) findViewById(R.id.txtPassword);
            btnL = (Button) findViewById(R.id.btnLogIn);
            btnR = (Button) findViewById(R.id.btnRegister);

        /*
         getText() returns a text Object, toString()
         converts it to a text
        */

            Username = txtU.getText().toString();
            Email = txtE.getText().toString();
            Password = txtP.getText().toString();

            Boolean isUEmpty = false;
            Boolean isLogIn = true;


            if (Username.isEmpty() == true) {
                txtU.setError("Name is a required field");
                isLogIn = false;
                isUEmpty = true;

            }

            if (Email.isEmpty() == true || Email.indexOf('@') == -1) {
                txtE.setError("Email is either empty or incorrectly formatted");
                isLogIn = false;

            }

            if (Password.isEmpty() == true) {
                txtP.setError("Password is a required field");
                isLogIn = false;

            }
            /* Both the conditions need to be True
            if (Username.matches(".*\\d.*") && isUEmpty == false) {
                txtU.setError("Name can only have characters");
                isVerified = false;
            }
            */


            if (isLogIn == true) {

                btnL.setText("Log In");
                btnL.setEnabled(false);
                btnR.setEnabled(true);

                // setFocusable(false) will lock the text boxes,
                // the effect is not visible, but once you try
                // to update the text, you will find it NOT editable

                txtU.setFocusable(false);
                txtP.setFocusable(false);
                txtE.setFocusable(false);
                Toast.makeText(getApplicationContext(), "Log In", Toast.LENGTH_SHORT).show();

            }

        }

        public void btnRegister (View view){

            if (btnR.getText().toString().equals("Register")) {
                txtU.setText("");
                txtP.setText("");
                txtE.setText("");
                btnR.setText("Exit");
                Toast.makeText(getApplicationContext(), "Registered Successfully - Name: " + Username, Toast.LENGTH_LONG).show();
            } else {
                finish();
                System.exit(0);
            }

        }
    }