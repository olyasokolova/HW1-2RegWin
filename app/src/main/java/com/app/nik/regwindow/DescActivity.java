package com.app.nik.regwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nik.regwindow.repositorii.Repository;

public class DescActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvDescs;
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescs = findViewById(R.id.tvDesc);
        ivPhoto = findViewById(R.id.ivPhoto);
        String title = getIntent().getExtras().getString(Repository.EXTRA_TITLE);
        String desc = getIntent().getExtras().getString(Repository.EXTRA_DESC);
        int pic = getIntent().getExtras().getInt(Repository.EXTRA_PIC);
        tvTitle.setText(title);
        tvDescs.setText(desc);
        ivPhoto.setImageResource(pic);

    }
}
