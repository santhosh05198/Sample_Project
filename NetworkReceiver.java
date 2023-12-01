package com.example.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {
    static String status = null;
    @Override
    public void onReceive(Context context, Intent intent) {
        status = NetworkState.getConnectivityStatusString(context);
        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
        if (status == "Wifi enabled"){
            showToast("WiFi enabled");
        } else if (status == "Mobile data enabled") {
            showToast("Mobile data enabled");
        } else if (status == "Not connected to Internet") {
            showToast("Not connected to Internet");
        }
    }

    private void showToast(String wiFiEnabled) {
        showToast("WiFi enabled");
    }
}
