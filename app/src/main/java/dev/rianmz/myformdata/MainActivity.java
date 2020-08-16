package dev.rianmz.myformdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView fullname;
    private DatePicker birthdate;
    private int day;
    private int month;
    private int monthString;
    private int year;
    private TextView phone;
    private TextView email;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all elements from activity_main layout.
        fullname    = (TextView) findViewById(R.id.etFullName);
        birthdate   = (DatePicker) findViewById(R.id.dpBirthdate);
        phone       = (TextView) findViewById(R.id.etPhone);
        email       = (TextView) findViewById(R.id.etEmail);
        description = (TextView) findViewById(R.id.etDescription);

        // Get intent extras from edit activity.
        Intent editIntent = getIntent();
        Bundle extras = editIntent.getExtras();

        // Validate if extras exist.
        if (extras != null) {
            // Get all values from extras.
            String extraFullname    = extras.getString(getResources().getString(R.string.pfullname));
            int extraYear           = extras.getInt(getResources().getString(R.string.pyear));
            int extraMonth          = extras.getInt(getResources().getString(R.string.pmonth));
            int extraDay            = extras.getInt(getResources().getString(R.string.pday));
            String extraPhone       = extras.getString(getResources().getString(R.string.pphone));
            String extraEmail       = extras.getString(getResources().getString(R.string.pemail));
            String extraDescription = extras.getString(getResources().getString(R.string.pdescription));

            // Set new values on layout from extras.
            fullname.setText(extraFullname);
            phone.setText(extraPhone);
            birthdate.updateDate(extraYear, extraMonth, extraDay);
            email.setText(extraEmail);
            description.setText(extraDescription);
        }

        // Set event on click listener to next button.
        Button buttonNext = (Button) findViewById(R.id.bNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values from DatePicker.
                day          = birthdate.getDayOfMonth();
                month        = birthdate.getMonth();
                monthString  = month + 1; // Increment 1 month to correct string.
                year         = birthdate.getYear();
                String date  = day + "/" + monthString + "/" + year; // Date string to show.

                // Set extras to Intent.
                Intent intent = new Intent(MainActivity.this, ShowData.class);
                intent.putExtra(getResources().getString(R.string.pfullname), fullname.getText().toString());
                intent.putExtra(getResources().getString(R.string.pbirthday), date);
                intent.putExtra(getResources().getString(R.string.pyear), year);
                intent.putExtra(getResources().getString(R.string.pmonth), month);
                intent.putExtra(getResources().getString(R.string.pday), day);
                intent.putExtra(getResources().getString(R.string.pphone), phone.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), email.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescription), description.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}