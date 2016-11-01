package com.example.vishnu.androiddataanalyser;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetConnection extends Activity {
    Context context;

    public NetConnection(Context context) {
        this.context = context;

    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {

                    return true;
                }

            }
        }
        return false;

    }
}

