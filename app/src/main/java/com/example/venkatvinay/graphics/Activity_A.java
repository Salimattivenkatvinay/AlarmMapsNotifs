package com.example.venkatvinay.graphics;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Venkat Vinay on 7/1/2016.
 */
public class Activity_A extends AppCompatActivity {
Button btn1;
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("demo", "onStart");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        btn1= (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Activity_B.class));
            }
        });
        Log.i("demo", "onCreate");
    }




    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("demo", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("demo", "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("demo", "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("demo", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("demo", "onDestroy");
    }
}
