package com.example.venkatvinay.graphics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class BroadCastReceiverDemo extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"SMS Received...",Toast.LENGTH_LONG).show();
        Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) (pdusObj != null ? pdusObj[0] : null));
                String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                String message = currentMessage.getDisplayMessageBody();
                Toast.makeText(context,"Data :"+phoneNumber+message,Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ignored){}
    }
}
