package com.onActivityResult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView nameTexView, ageTextView, phoneNumberTextView, sexxTextView;
    private Button navigateButton;
    private static final int REQUEST_CODE=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeViews();
        onClickButton();
        makeTextInvisible_Visible(true);
    }

    private void intializeViews() {
        /**
         * TextViews
         */
        nameTexView = (TextView) findViewById(R.id.name_id_textView);
        ageTextView = (TextView) findViewById(R.id.age_id_textView);
        phoneNumberTextView = (TextView) findViewById(R.id.phoneNUmber_id_textView);
        sexxTextView = (TextView) findViewById(R.id.sex_id_textView);
        /**
         * Buttons
         */
        navigateButton = (Button) findViewById(R.id.activity_button_navigate);

    }

    private void makeTextInvisible_Visible(boolean true_visible) {
        if(true_visible){
            nameTexView.setVisibility(View.INVISIBLE);
            ageTextView.setVisibility(View.INVISIBLE);
            phoneNumberTextView.setVisibility(View.INVISIBLE);
            sexxTextView.setVisibility(View.INVISIBLE);
        }else {
            nameTexView.setVisibility(View.VISIBLE);
            ageTextView.setVisibility(View.VISIBLE);
            phoneNumberTextView.setVisibility(View.VISIBLE);
            sexxTextView.setVisibility(View.VISIBLE);
        }
    }

    private void assignDetialsToText(String name,String age,String phoneNUmber,String sex){
        nameTexView.setText(name);
        ageTextView.setText(age);
        phoneNumberTextView.setText(phoneNUmber);
        sexxTextView.setText(sex);
    }

    private void onClickButton() {
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra(getResources().getString(R.string.NAME));
                String age = data.getStringExtra(getResources().getString(R.string.AGE));
                String phoneNumber = data.getStringExtra(getResources().getString(R.string.PHONE_NO));
                String sex = data.getStringExtra(getResources().getString(R.string.SEX));
                makeTextInvisible_Visible(false);
                assignDetialsToText(name,age,phoneNumber,sex);
            }
            if (resultCode == RESULT_CANCELED) {

            }
        }
    }

    /**
     * Link:-
     * https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
     */
}