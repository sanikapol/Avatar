//Assignment Inclass 03
//File Name: Group12_InClass03
//Sanika Pol
//Snehal Kekane

package com.example.avatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);
        setTitle("Display Profile");

        if(getIntent()!=null && getIntent().getExtras()!=null){
            Log.d("avatar", "inside if");
            TextView tv_displayName =  findViewById(R.id.tv_diplayName);
            User user = (User) getIntent().getExtras().getSerializable(MainActivity.USER_KEY);
            //tv_displayName.setText(getIntent().getExtras().getSerializable(MainActivity.USER_KEY).toString());
            tv_displayName.setText(user.getFirstName().toString() + " " + user.getLastName().toString());
            TextView gender = findViewById(R.id.tv_gender);
            if(user.getGender().toString().equals("female"))
                gender.setText("Female");
            else if(user.getGender().toString().equals("male"))
                gender.setText("Male");

            Log.d("Avatar", user.getGender().toString());
            ImageView iv_profile = findViewById(R.id.iv_profile);
            if(user.getGender().toString().equals("female")){
                iv_profile.setImageDrawable(getDrawable(R.drawable.female));
            }
            else if(user.getGender().toString().equals("male")){
                iv_profile.setImageDrawable(getDrawable(R.drawable.male));
            }
        }

        Button btn_edit  = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
