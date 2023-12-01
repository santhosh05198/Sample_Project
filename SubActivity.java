package com.example.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    TextView txtName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        txtName = (TextView)findViewById(R.id.tv_id);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        txtName.setText(str);
        intent.setAction("example.javatpoint.com.networkconnectivityservice");
        sendBroadcast(intent);
    }

}
