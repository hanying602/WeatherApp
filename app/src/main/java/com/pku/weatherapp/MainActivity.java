package com.pku.weatherapp;

import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pku.weatherapp.util.NetUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkNetwork();
    }

    private void checkNetwork(){
        if(NetUtil.getNetworkState(this)!=NetUtil.NETWORN_NONE){
            Log.d(TAG, "checkNetwork: " + "網路OK");
            Toast.makeText(this,"網路OK",Toast.LENGTH_SHORT).show();
        }else {
            Log.d(TAG, "checkNetwork: " + "網路掛了");
            Toast.makeText(this,"網路掛了",Toast.LENGTH_SHORT).show();
        }
    }
}
