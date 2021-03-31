package com.onActivityResult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
  private EditText nameTexView, ageTextView, phoneNumberTextView;
  private   Button navigateButton;
  RadioButton male_RadioButton,female_RadioButton;
  RadioGroup radioGroup_mf;
  String male_female="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intializeViews();
        onClickButton();
        registerOnClicListner();
    }
    private void intializeViews() {
        /**
         * TextViews
         */
        nameTexView = (EditText) findViewById(R.id.name_id_editText);
        ageTextView = (EditText) findViewById(R.id.age_id_editText);
        phoneNumberTextView = (EditText) findViewById(R.id.phoneNUmber_id_editText);
        /**
         * Buttons
         */
        navigateButton = (Button) findViewById(R.id.activity_button_navigate);
        male_RadioButton=(RadioButton)findViewById(R.id.radio_button_male_id);
        female_RadioButton=(RadioButton)findViewById(R.id.radio_button_female_id);
        radioGroup_mf=(RadioGroup)findViewById(R.id.radio_group_mf_id);
    }
    private void registerOnClicListner(){
        radioGroup_mf.setOnCheckedChangeListener(this);
    }
    private void onClickButton(){
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameTexView.getText().toString();
                String age=ageTextView.getText().toString();
                String phoneNumber=phoneNumberTextView.getText().toString();
                Intent intent=new Intent();
                if(male_female.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Please Select Gender",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra(getResources().getString(R.string.NAME),name);
                intent.putExtra(getResources().getString(R.string.AGE),age);
                intent.putExtra(getResources().getString(R.string.PHONE_NO),phoneNumber);
                intent.putExtra(getResources().getString(R.string.SEX),male_female);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(male_RadioButton.getId()==checkedId){
                    male_female="M";
                }else if(female_RadioButton.getId()==checkedId){
                    male_female="F";
                }
    }
}