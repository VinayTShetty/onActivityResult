package com.onActivityResult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
  private EditText nameTexView, ageTextView, phoneNumberTextView, sexxTextView;
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
        nameTexView = (EditText) findViewById(R.id.name_id_editText);
        ageTextView = (EditText) findViewById(R.id.age_id_editText);
        phoneNumberTextView = (EditText) findViewById(R.id.phoneNUmber_id_editText);
        sexxTextView = (EditText) findViewById(R.id.sex_id_editText);
        /**
         * Buttons
         */
        navigateButton = (Button) findViewById(R.id.activity_button_navigate);
    }
    private void onClickButton(){
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameTexView.getText().toString();
                String age=ageTextView.getText().toString();
                String phoneNumber=phoneNumberTextView.getText().toString();
                String sex=sexxTextView.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(getResources().getString(R.string.NAME),name);
                intent.putExtra(getResources().getString(R.string.AGE),age);
                intent.putExtra(getResources().getString(R.string.PHONE_NO),phoneNumber);
                intent.putExtra(getResources().getString(R.string.SEX),sex);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}