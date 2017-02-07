package com.example.venkatvinay.graphics;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * Created by Venkat Vinay on 7/5/2016.
 */
public class Notificationactivity extends AppCompatActivity {
Button btn_show_notification;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btn_show_notification= (Button) findViewById(R.id.btn_show_notification);

        btn_show_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // showNotification();
                //setBigTextNotification();
                //new generatePictureStyleNotification().execute();
                setInboxNotification();
            }
        });
    }
    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notificationactivity.this);
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Ticker");
        builder.setAutoCancel(true);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
    }
    private void setBigTextNotification(){
        NotificationCompat.BigTextStyle style=new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Big Text Content Title");
        style.setSummaryText("By - Swetha");
        style.bigText("sdfsdf sdfsd dfsdf sdf sfd sfd sdf sdsddfsdfs sdfsd dfs sdfd sddf ");



        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notificationactivity.this);
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Ticker");
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND);

        builder.setStyle(style);

        Notification notification = builder.build();
       // notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
      //  notification.setSound(Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.demonstrative));
        NotificationManager notificationManager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
    }
    public class generatePictureStyleNotification extends AsyncTask<String, Void, Bitmap> {

        private Context mContext;
        private String title, message, imageUrl;



        @Override
        protected Bitmap doInBackground(String... params) {
            InputStream in;
            try {
                URL url = new URL("http://www.gannett-cdn.com/-mm-/3c12e6a398b55d472a3a09f14ab8ac4987e435a2/r=880/http/videos.usatoday.net/Brightcove2/29906170001/2016/06/29906170001_4921499122001_4921477632001-vs.jpg");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                in = connection.getInputStream();
                bmp = BitmapFactory.decodeStream(in);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            setBigPicNotification();
        }
    }
    Bitmap bmp;
    private void setBigPicNotification(){

        //Bitmap bmp=BitmapFactory.decodeResource(this.getResources(), R.drawable.profilepic);
        NotificationCompat.BigPictureStyle style=new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("Big Picture Content Title");
        style.bigPicture(bmp);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notificationactivity.this);
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Ticker");
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND);

        builder.setStyle(style);

        Notification notification = builder.build();
        // notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        //  notification.setSound(Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.demonstrative));
        NotificationManager notificationManager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);

    }
    private void setInboxNotification(){
        NotificationCompat.InboxStyle style=new NotificationCompat.InboxStyle();
        style.setBigContentTitle("Inbox Content Title");
        style.setSummaryText("By - Swetha");
        style.addLine("1. Tip one by sdfsd sfsd sdf sfd sf sdfsdf ssdf");
        style.addLine("2. Swetha one by sdfsd sfsd sdf sfd sf sdfsdf ssdf");
        style.addLine("3. Spanada one by sdfsd sfsd sdf sfd sf sdfsdf ssdf");

        Intent resultIntent = new Intent(this, GoogleMapsActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(GoogleMapsActivity.class);

// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notificationactivity.this);
        builder.setContentTitle("Content Title");
        builder.setContentIntent(resultPendingIntent);
        builder.setContentText("Content Text");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Ticker");
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND);

        builder.setStyle(style);

        Notification notification = builder.build();
        // notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        //  notification.setSound(Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.demonstrative));
        NotificationManager notificationManager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
    }
}
