package com.example.venkatvinay.graphics;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
Button setalarm,repeat,stop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        setalarm= (Button) findViewById(R.id.btn_addalarm);
        repeat= (Button) findViewById(R.id.btn_repeat);
        stop= (Button) findViewById(R.id.stop);


        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneTimeAlaram();
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      repeatingAlaram();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
cancelAlaram();
            }
        });
    }
    public void oneTimeAlaram() {
        Calendar timeOff9 = Calendar.getInstance();
        timeOff9.set(Calendar.HOUR_OF_DAY, 18);
        timeOff9.set(Calendar.MINUTE, 44);
        timeOff9.set(Calendar.SECOND, 0);
        Intent intent = new Intent(this, AlarmBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //System.currentTimeMillis()
        //alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(20*1000)  , pendingIntent);
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis()  , pendingIntent);
      // Toast.makeText(this, "Alarm set in " + 20 + " seconds",Toast.LENGTH_LONG).show();
    }
    public void repeatingAlaram() {

        Intent intent = new Intent(this, AlarmBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //System.currentTimeMillis()
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),2*1000  , pendingIntent);

        // Toast.makeText(this, "Alarm set in " + 20 + " seconds",Toast.LENGTH_LONG).show();
    }
    public void cancelAlaram() {

        Intent intent = new Intent(this, AlarmBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //System.currentTimeMillis()
        alarmManager.cancel(pendingIntent);

        // Toast.makeText(this, "Alarm set in " + 20 + " seconds",Toast.LENGTH_LONG).show();
    }


}
