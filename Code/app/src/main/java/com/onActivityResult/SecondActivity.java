package com.onActivityResult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
  private   TextView nameTexView, ageTextView, phoneNumberTextView, sexxTextView;
  private   Button navigateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intializeViews();
        onClickButton();
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
    private void onClickButton(){
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}