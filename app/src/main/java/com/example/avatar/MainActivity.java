//Assignment Inclass 03
//File Name: Group12_InClass03
//Sanika Pol
//Snehal Kekane

package com.example.avatar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE = 0X001;
    public static final String USER_KEY = "USER";
    ImageView iv_avatar;
    Button btn_save;
    EditText et_firstName;
    EditText et_lastName;
    String userGender="";
    TextView tv_selectAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("My Profile");

        iv_avatar = findViewById(R.id.iv_Avatar);

        iv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSelectAvatar = new Intent(MainActivity.this, SelectActivity.class);
                startActivityForResult(toSelectAvatar,REQ_CODE);
            }
        });

        btn_save = findViewById(R.id.btn_Save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_firstName = findViewById(R.id.et_firstName);
                et_lastName = findViewById(R.id.et_lastName);
                Toast toast;
                tv_selectAvatar = findViewById(R.id.tv_SelectAvatar);
                if(et_firstName.getText().toString().equals("") || et_lastName.getText().toString().equals("")) {
                    if (et_firstName.getText().toString().equals("")) {
                        et_firstName.setError("Can't be empty");
                        Toast.makeText(MainActivity.this, "Can't be empty!!", Toast.LENGTH_SHORT).show();
                    }
                    if (et_lastName.getText().toString().equals("")) {
                        et_lastName.setError("Can't be empty");
                        Toast.makeText(MainActivity.this, "Can't be empty!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(userGender.equals("")){
                    tv_selectAvatar.setText("Please Select Avatar");
                }
                else{
                    tv_selectAvatar.setText("Select Avatar");
                    Log.d("avatar", userGender);
                    User user = new User(userGender,et_firstName.getText().toString(), et_lastName.getText().toString());
                    Intent displayProfile = new Intent(MainActivity.this, DisplayProfile.class);
                    displayProfile.putExtra(USER_KEY,user);
                    startActivity(displayProfile);
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE && resultCode == RESULT_OK && data!=null){
            String gender = data.getExtras().getString(SelectActivity.GENDER);
            tv_selectAvatar.setText("Select Avatar");
            if(gender.equals("female")){
                iv_avatar.setImageDrawable(getDrawable(R.drawable.female));
                userGender = "female";
                Log.d("avatar", userGender);
            }
            else {
                iv_avatar.setImageDrawable(getDrawable(R.drawable.male));
                userGender = "male";
                Log.d("avatar", userGender);
            }
        }

    }

}
