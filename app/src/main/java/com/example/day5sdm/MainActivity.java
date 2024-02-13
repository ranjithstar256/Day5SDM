package com.example.day5sdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                shownofn();
            }
        });
    }

    public void shownofn() {
        NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this, channelId)
                 .setSmallIcon(android.R.drawable.btn_plus)
                .setContentTitle("You can also 'Learn Android'")
                 .setContentText("Contact AndroidManifester today!!");

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}