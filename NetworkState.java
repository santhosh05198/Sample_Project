package com.example.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkState {

    public static int TYPE_NOT_CONNECTED = 0;
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;

    }

    public static String getConnectivityStatusString(Context context) {
            int conn = NetworkState.getConnectivityStatus(context);
            String status = null;

            if(conn == NetworkState.TYPE_WIFI){
                status = "Wifi enabled";
            } else if (conn == NetworkState.TYPE_MOBILE) {
                status = "Mobile data enabled";
            } else if (conn == NetworkState.TYPE_NOT_CONNECTED) {
                status = "Not connected to Internet";
            }
            return status;
        }

    }

