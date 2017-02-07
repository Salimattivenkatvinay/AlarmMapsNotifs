package com.example.venkatvinay.graphics;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Venkat Vinay on 7/2/2016.
 */
public class ThreadingActivityEx extends AppCompatActivity {
Button btn_submit;
    int res=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadin_ex);


        Handler hh=new Handler();
        hh.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(getApplicationContext(),"Handler :",Toast.LENGTH_LONG).show();

            }
        },5000);
    }
    /*
    private void myTrread(){
        Runnable rr=new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection;
                try {
                    connection = (HttpURLConnection) new URL("http://bytecodetechnosolutions.com").openConnection();
                    res= connection.getResponseCode();
                    Log.i("demo", ""+res);

                    *//*;
                    hd.post(runnable1);*//*
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };
        Thread t=new Thread(rr);
        t.start();
    }*/

}
