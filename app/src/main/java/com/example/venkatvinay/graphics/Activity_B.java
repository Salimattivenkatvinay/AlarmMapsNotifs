package com.example.venkatvinay.graphics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by Venkat Vinay on 7/1/2016.
 */
public class Activity_B extends AppCompatActivity {
Button btn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);



        btn2= (Button) findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
finish();
            }
        });
        Log.i("demo", "onCreate _B");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("demo", "onStart _B");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("demo", "onRestart _B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("demo", "onResume _B");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("demo", "onPause _B");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("demo", "onStop B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("demo", "onDestroy _B");
    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();

    }
}
