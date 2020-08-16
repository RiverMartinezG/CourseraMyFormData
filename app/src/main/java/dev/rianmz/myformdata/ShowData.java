package dev.rianmz.myformdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {
    private TextView tvFullname;
    private TextView tvBirthdate;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        // Get intent extras.
        Bundle parameters  = getIntent().getExtras();
        String fullname    = parameters.getString(getResources().getString(R.string.pfullname));
        String birthday    = parameters.getString(getResources().getString(R.string.pbirthday));
        final int year     = parameters.getInt(getResources().getString(R.string.pyear));
        final int month    = parameters.getInt(getResources().getString(R.string.pmonth));
        final int day      = parameters.getInt(getResources().getString(R.string.pday));
        String phone       = parameters.getString(getResources().getString(R.string.pphone));
        String email       = parameters.getString(getResources().getString(R.string.pemail));
        String description = parameters.getString(getResources().getString(R.string.pdescription));

        // Get all elements from activity_show_data layout.
        tvFullname    = (TextView) findViewById(R.id.tvFullName);
        tvBirthdate   = (TextView) findViewById(R.id.tvBirthDate);
        tvPhone       = (TextView) findViewById(R.id.tvPhone);
        tvEmail       = (TextView) findViewById(R.id.tvEmail);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        // Set new values on layout from extras.
        tvFullname.setText(fullname);
        tvBirthdate.setText(birthday);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvDescription.setText(description);

        // Set event on click listener to edit button.
        Button buttonEdit = (Button) findViewById(R.id.bEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set extras to Intent.
                Intent intent = new Intent(ShowData.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pfullname), tvFullname.getText().toString());
                intent.putExtra(getResources().getString(R.string.pyear), year);
                intent.putExtra(getResources().getString(R.string.pmonth), month);
                intent.putExtra(getResources().getString(R.string.pday), day);
                intent.putExtra(getResources().getString(R.string.pphone), tvPhone.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescription), tvDescription.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}