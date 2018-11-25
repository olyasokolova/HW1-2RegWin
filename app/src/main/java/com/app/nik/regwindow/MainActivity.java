package com.app.nik.regwindow;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String srnName="";
    String phoneNum="";
    String age="";
    String postNum;
    String frstName="";
    boolean flg = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnReg = findViewById(R.id.btnReg);
        final EditText editFrstName = findViewById(R.id.editFrstName);
        EditText editSrnName = findViewById(R.id.editSrnName);
        final EditText editPhoneNum = findViewById(R.id.editPhoneNum);
        EditText editAge = findViewById(R.id.editAge);
        EditText editPostNum = findViewById(R.id.editPostNum);
        final RadioButton male = findViewById(R.id.male);
        final RadioButton fem = findViewById(R.id.fem);
        ImageView editImage = findViewById(R.id.editImage);
        Button intentPhone = findViewById(R.id.intentPhone);
        Button intentPost = findViewById(R.id.intentPost);
        editFrstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            srnName=s.toString();
            }
        });

        editPhoneNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            phoneNum=s.toString();
            }
        });
        editAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            age=s.toString();
            }
        });
        editPostNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            postNum = s.toString();
            }
        });
        editFrstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            frstName = s.toString();
            }
        });
        editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("image/*");
                startActivity(intent);*/
                int RESULT_GALLERY = 0;
                Intent galleryIntent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent , RESULT_GALLERY );
            }
        });
        intentPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Uri number = Uri.parse(phoneNum);
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(callIntent);
            }
        });
        intentPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                startActivity(emailIntent);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(
                        !frstName.isEmpty()&&!srnName.isEmpty()&&!postNum.isEmpty()&&!phoneNum.isEmpty()&&!age.isEmpty()&&(male.isChecked()||fem.isChecked())&&phoneNum.length()<=10&&postNum.contains("@")
                        )
                {
                    Toast.makeText(MainActivity.this,"Вы зарегистрировались",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                }

                 else
                {Toast.makeText(MainActivity.this,"Не все поля заполнены правильно",Toast.LENGTH_LONG).show();
               }




            }
        });

    }
}
