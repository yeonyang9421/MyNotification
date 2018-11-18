package kr.co.woobi.imyeon.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                notification();
                break;
            case R.id.button2:
                notification2();
                break;
            case R.id.button3:
                notification3();
                break;
            case R.id.button4:
                notification4();
                break;
            case R.id.button5:
                notification5();
                break;
            case R.id.button6:
                notification6();
                break;
            case R.id.button7:
                notification7();
                break;
            case R.id.button8:
                notification8();
                break;
        }

    }

    private void notification8() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("알림 8").setPriority(Notification.PRIORITY_HIGH).setDefaults(Notification.DEFAULT_VIBRATE);

        Intent resultIntent = new Intent(this, ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ResultActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());


    }
        private void notification7() {
            final NotificationManager mNotifyManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            final NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setContentTitle("알림 7 : Picture Download")
                    .setContentText("Download in progress")
                    .setSmallIcon(R.mipmap.ic_launcher);
// Start a lengthy operation in a background thread
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int incr;
                            // Do the "lengthy" operation 20 times
                            for (incr = 0; incr <= 100; incr+=20) {
                                // Sets the progress indicator to a max value, the
                                // current completion percentage, and "determinate"
                                // state
                                mBuilder.setProgress(0, 0, true);
                                // Displays the progress bar for the first time.
                                mNotifyManager.notify(0, mBuilder.build());
                                // Sleeps the thread, simulating an operation
                                // that takes time
                                try {
                                    // Sleep for 5 seconds
                                    Thread.sleep(1*1000);
                                } catch (InterruptedException e) {

                                }
                            }
                            // When the loop is finished, updates the notification
                            mBuilder.setContentText("Download complete")
                                    // Removes the progress bar
                                    .setProgress(0,0,false);
                            mNotifyManager.notify(6, mBuilder.build());
                        }
                    }
// Starts the thread by calling the run() method in its Runnable
            ).start();





    }
        private void notification6() {
           final NotificationManager mNotifyManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
          final NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setContentTitle("Picture Download")
                    .setContentText("알림 6 : Download in progress")
                    .setSmallIcon(R.mipmap.ic_launcher);
// Start a lengthy operation in a background thread
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int incr;
                            // Do the "lengthy" operation 20 times
                            for (incr = 0; incr <= 100; incr+=20) {
                                // Sets the progress indicator to a max value, the
                                // current completion percentage, and "determinate"
                                // state
                                mBuilder.setProgress(100, incr, false);
                                // Displays the progress bar for the first time.
                                mNotifyManager.notify(0, mBuilder.build());
                                // Sleeps the thread, simulating an operation
                                // that takes time
                                try {
                                    // Sleep for 5 seconds
                                    Thread.sleep(1*1000);
                                } catch (InterruptedException e) {

                                }
                            }
                            // When the loop is finished, updates the notification
                            mBuilder.setContentText("Download complete")
                                    // Removes the progress bar
                                    .setProgress(0,0,false);
                            mNotifyManager.notify(6, mBuilder.build());
                        }
                    }
// Starts the thread by calling the run() method in its Runnable
            ).start();


    }
        private void notification5() {
            // Instantiate a Builder object.
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setContentTitle("알림 5")
                    .setContentText("알림5에 뜨는 상세 메세지 내용")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true);
// Creates an Intent for the Activity
            Intent notifyIntent =
                    new Intent(this, ThirdActivity.class);
// Sets the Activity to start in a new, empty task
            notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
// Creates the PendingIntent
            PendingIntent notifyPendingIntent =
                    PendingIntent.getActivity(
                            this,
                            0,
                            notifyIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );

// Puts the PendingIntent into the notification builder
            builder.setContentIntent(notifyPendingIntent);
// Notifications are issued by sending them to the
// NotificationManager system service.
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Builds an anonymous Notification object from the builder, and
// passes it to the NotificationManager
            mNotificationManager.notify(5, builder.build());
    }


    private void notification4() {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack
        stackBuilder.addParentStack(ResultActivity.class);
// Adds the Intent to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
// Gets a PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("알림 4")
                .setContentText("알림4에 뜨는 상세 메세지 내용")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);
        builder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, builder.build());

    }

    private void notification3() {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyID = 1;
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("New Message")
                .setContentText("You've received new messages.")
                .setSmallIcon(R.mipmap.ic_launcher);
       int numMessages = 0;
        mNotifyBuilder.setContentText("알림3")
                .setNumber(++numMessages);
        mNotificationManager.notify(
                notifyID,
                mNotifyBuilder.build());
    }


    private void notification2() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Event tracker")
                .setContentText("Events received");

        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        String[] events = new String[6];

        events[0] = "1";
        events[1] = "2";
        events[2] = "3";
        events[3] = "4";
        events[4] = "5";
        events[4] = "6";

        inboxStyle.setBigContentTitle("Event tracker details:");

// Moves events into the expanded layout
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
// Moves the expanded layout object into the notification object.
        mBuilder.setStyle(inboxStyle);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }


    private void notification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        Intent resultIntent = new Intent(this, ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ResultActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }
}
