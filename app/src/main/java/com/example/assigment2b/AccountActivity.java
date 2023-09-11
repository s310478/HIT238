package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class AccountActivity extends AppCompatActivity {
    // Fot selecting Address
    String[] stateList = {"NT, Australia", "QLD, Australia", "NSW, Australia", "VIC, Australia",
            "TAS, Australia","SA, Australia", "WA, Australia"};

    private TextView txtUsr;


    private static final String TAG = "AccountActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        //Auto complete
        //initiate an auto complete text view
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoAddress);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, stateList);

        //auto.setAdapter(adapter);
        auto.setThreshold(1);//start searching from 1 character
        auto.setAdapter(adapter);   //set the adapter for displaying state name list


        // Pulled from this YT vid: https://www.youtube.com/watch?v=hwe1abDO2Ag
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AccountActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        // initialize
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
                mDisplayDate.setTextColor(Color.parseColor("#000000"));

            }

        };


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