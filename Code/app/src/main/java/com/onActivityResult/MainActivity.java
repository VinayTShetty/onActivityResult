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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeViews();
        onClickButton();
        makeTextInvisible();
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

    private void makeTextInvisible() {
        nameTexView.setVisibility(View.INVISIBLE);
        ageTextView.setVisibility(View.INVISIBLE);
        phoneNumberTextView.setVisibility(View.INVISIBLE);
        sexxTextView.setVisibility(View.INVISIBLE);
    }

    private void onClickButton() {
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("NAME");
                System.out.println(result);
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