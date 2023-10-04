package com.example.assigment2b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TextView txtUsr; // Used to display username in log in field (top right)
    private String email;  // Used to store email for other activities
    private String password; // Used to store password for other activities
    private String role;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Initialize username
        this.txtUsr = (TextView) findViewById(R.id.lblUser);

        // Display username entered at log in activity, otherwise 'Log In' is displayed.
        Intent i = getIntent();
        String username = i.getStringExtra("username");

        email = i.getStringExtra("email"); // email is assigned from the intent
        password = i.getStringExtra("password"); // password is assigned from the intent
        role = i.getStringExtra("role");

        if (username == null || username == "Log In") {
            txtUsr.setText("Log In"); // Display "Log in" or
        }else {
            txtUsr.setText(username); // Display username
        }

        // Enable edit price button visibility based on role and set onClick listeners
        int visibility = "Admin".equals(role) ? View.VISIBLE : View.GONE;

        // A map of edit price button ids to corresponding price text view ids
        int[][] idPairs = {
                {R.id.editPrice1, R.id.price1},
                {R.id.editPrice2, R.id.price2},
                {R.id.editPrice3, R.id.price3}
        };

        // Loop idPairs
        for (int[] pair : idPairs) {
            Button button = findViewById(pair[0]); // get button
            TextView priceTextView = findViewById(pair[1]); // get price

            button.setVisibility(visibility); // set visibility of button

            //
            button.setOnClickListener(v -> {
                showEditPriceDialog(priceTextView);
            });
        }
    }

    private void showEditPriceDialog(TextView priceTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Price");

        // Set up the input
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL); // for decimal numbers
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", (dialog, which) -> {
            String newPrice = input.getText().toString();
            priceTextView.setText(newPrice);
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }



    // Wish notification
   public void addWish(View view) {

       Toast.makeText(getApplicationContext(), "Added to Wishlist", Toast.LENGTH_LONG).show();
   }

   // Collection notification
    public void addCollection(View view) {

        Toast.makeText(getApplicationContext(), "Added to Collection", Toast.LENGTH_LONG).show();
    }

    // Used to pass on current username to other activities
    public TextView txtU;

    // Bottom nav bar & log in buttons
    public void showLogIn(View view) {

        Intent i = new Intent(this, LogInActivity.class);
        startActivity(i);
    }

    public void showHome(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("email", email);
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);
    }

    public void showWish(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        //Change this to WishActivity.class when created
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("email", email);
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);
    }

    public void showCollection(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        //Change this to CollectionActivity.class when created
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("email", email);
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);
    }

    public void showAccount(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, AccountActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("email", email);
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);

    }
}