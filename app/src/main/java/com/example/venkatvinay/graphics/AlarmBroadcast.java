package com.example.venkatvinay.graphics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Venkat Vinay on 7/4/2016.
 */
public class AlarmBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"alarm",Toast.LENGTH_SHORT).show();



    }
}
