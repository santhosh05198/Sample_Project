package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editText;
    private BroadcastReceiver networkStatus;
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.btnsend);
        editText = (EditText) findViewById(R.id.edt_id);
        button.setOnClickListener(V ->{
            String str = editText.getText().toString();
            Intent intent = new Intent(getApplicationContext(), SubActivity.class);
            intent.putExtra("message_key",str);
            startActivity(intent);

            NetworkReceiver receiver = new NetworkReceiver();
            filter = new IntentFilter("com.journaldev.broadcastreceiver.SOME_ACTION");

            String networkStatus = receiver.status;
            editText.setText("connection type: " + networkStatus);
            Toast.makeText(getApplicationContext(),networkStatus,Toast.LENGTH_LONG).show();

            if(TextUtils.isEmpty((CharSequence) editText)){
                editText.setError("Field is empty");
            }
        });
    }

//    @Override
//    protected void onResume(){
//        super.onResume();
//        registerReceiver(receiver,filter);
//    }
//
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkStatus);
    }
}