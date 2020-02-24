//Assignment Inclass 03
//File Name: Group12_InClass03
//Sanika Pol
//Snehal Kekane

package com.example.avatar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_male, iv_female;
    public   static final String GENDER = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setTitle("Select Avatar");

        iv_female = findViewById(R.id.iv_female);
        iv_male = findViewById(R.id.iv_male);

        iv_male.setOnClickListener(this);
        iv_female.setOnClickListener(this);


    }

    public void onClick(View view){
        if(view == iv_female){
            Intent returnedData = new Intent();
            returnedData.putExtra(GENDER,"female");
            setResult(RESULT_OK,returnedData);
            finish();
        }
        else if(view == iv_male){
            Intent returnedData = new Intent();
            returnedData.putExtra(GENDER,"male");
            setResult(RESULT_OK,returnedData);
            finish();
        }
    }
}
