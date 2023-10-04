package com.example.assigment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AccountActivity extends AppCompatActivity {
    // For selecting Country
    String[] countryList = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor",
            "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau",
            "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone",
            "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine"};


    private TextView txtUsr; // Used to display username in log in field (top right)
    private EditText txtUsrF; // Used to display username in username field
    private EditText txtE;
    private TextView txtP;
    private TextView txtD; // Used to store D.O.B.
    private String email; // Used to store email for other activities
    private String password; // Used to store password for other activities
    private String role;

    // For editing profile pic
    private ImageView imgProfile;
    private Button btnProfile;
    Uri imageUri;

    // For Profile pic
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1){

            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, 2909);

            imageUri = data.getData();
            imgProfile.setImageURI(imageUri);
        }
    }


    // For D.O.B.
    private static final String TAG = "AccountActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Profile pic stuff Initialization
        btnProfile = (Button)findViewById(R.id.btnProfile);
        imgProfile = (ImageView)findViewById(R.id.imgProfile);



        // D.O.B. Initialization
        mDisplayDate = (TextView) findViewById(R.id.tvDOB);

        // Auto complete for Country
        // Initiate an auto complete text view
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoAddress);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, countryList);

        auto.setThreshold(1);//start searching from 1 character
        auto.setAdapter(adapter);   //set the adapter for displaying state name list


        // Pulled from this YT vid: https://www.youtube.com/watch?v=hwe1abDO2Ag
        // D.O.B. - Shows date picker dialog
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

        // D.O.B. - selected date
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




        // Display username entered at log in activity, otherwise 'Log In' is displayed.
        this.txtUsr = (TextView) findViewById(R.id.lblUser); // for username at log in (top right)
        this.txtUsrF = (EditText) findViewById(R.id.txtUsername2); // for username in username field
        this.txtE = (EditText) findViewById(R.id.txtEmail2); // assign txtE = email field
        this.txtP = (EditText) findViewById(R.id.txtPassword2); // assign txtP = email field
        this.txtD = (TextView) findViewById(R.id.tvDOB); // assign txtD = D.O.B.


        Intent i = getIntent();
        String username = i.getStringExtra("username");
        role = i.getStringExtra("role"); // assign role from intent
        if (username == null || "Log In".equals(username)) {
            txtUsr.setText("Log In"); // Display "Log in" if no username
            txtUsrF.setText(""); // Display no name in username field
        } else {
            txtUsr.setText(username);   // Display username at log in (top right)
            txtUsrF.setText(username); // Display username in username field
        }

        // Display Email in email field
        email = i.getStringExtra("email");
        if (email == null || email.isEmpty()) {
            txtE.setText("");
        } else {
            txtE.setText(email);
        }

        // Display Password in password field
        password = i.getStringExtra("password");
        if (password == null || password.isEmpty()) {
            txtP.setText("");
        } else {
            txtP.setText(password);
        }

        // Display D.O.B in D.O.B field

    }

    // For Profile pic edit button
    public void editPic(View v)
    {
        Intent PickerIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //noinspection deprecation
        startActivityForResult(PickerIntent, 1);
    }

    // String variables to hold values
    public String Username2, Email2, Password2;

    // For Save button
    public void newSave(View view) {
        // Initialize the variables with UI components
        txtU = (EditText) findViewById(R.id.txtUsername2);
        txtE = (EditText) findViewById(R.id.txtEmail2);
        txtP = (EditText) findViewById(R.id.txtPassword2);
        txtD = (TextView) findViewById(R.id.tvDOB);

        // Extract the string values from the UI components
        Username2 = txtU.getText().toString();
        Email2 = txtE.getText().toString();
        Password2 = txtP.getText().toString();

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("email", txtE.getText().toString());
        i.putExtra("password", txtP.getText().toString());

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        startActivity(i);
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
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);
    }

    public void showCollection(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        //Change this to CollectionActivity.class when created
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("password", password);
        i.putExtra("role", role);
        startActivity(i);
    }

    public void showAccount(View view) {

        txtU = (TextView) findViewById(R.id.lblUser);

        Intent i = new Intent(this, AccountActivity.class);
        i.putExtra("username", txtU.getText().toString());
        i.putExtra("password", password);
        i.putExtra("email", email);
        i.putExtra("role", role);
        startActivity(i);
    }
}