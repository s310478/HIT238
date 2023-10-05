package com.example.assigment2b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
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

        // Initialize SharedPreferences - to save values
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

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

        // Retrieve saved prices from SharedPreferences and update the price
            String savedPrice = preferences.getString("savedPrice" + pair[1], "$0.00");
            priceTextView.setText(savedPrice);

            button.setOnClickListener(v -> {
                showEditPriceDialog(priceTextView, pair[1]);
            });
        }

        // For Star Ratings - keep their value
        // Array of RatingBar IDs
        int[] ratingBarIds = {R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3};


        // Loops ratingBars
        for (int id : ratingBarIds) {
            RatingBar ratingBar = findViewById(id);

            // Load the saved rating for each RatingBar
            float savedRating = preferences.getFloat("rating" + id, 0);
            ratingBar.setRating(savedRating);

            ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
                // Save the rating when it's changed, using the RatingBar's ID to distinguish each rating
                editor.putFloat("rating" + id, rating);
                editor.apply();
            });
        }
    }


    //Displays a dialog allowing the user to edit the price
    private void showEditPriceDialog(TextView priceTextView, int priceId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Price");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String newPrice = input.getText().toString();
            priceTextView.setText("$" + newPrice);

            // Save the new price in SharedPreferences associated with the specific TextView ID
            SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("savedPrice" + priceId, "$" + newPrice);
            editor.apply();
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

    public void navigateToActivity(View view, Class<?> targetActivity) {
        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, targetActivity);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("email", email);
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);
    }

    public void showHome(View view) {
        navigateToActivity(view, HomeActivity.class);
    }

    public void showWish(View view) {
        // Change this to WishActivity.class when created
        navigateToActivity(view, HomeActivity.class);
    }

    public void showCollection(View view) {
        // Change this to CollectionActivity.class when created
        navigateToActivity(view, HomeActivity.class);
    }

    public void showAccount(View view) {
        navigateToActivity(view, AccountActivity.class);
    }

}