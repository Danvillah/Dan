package com.example.dan;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class ContactUs extends AppCompatActivity {

    VideoView firstVideo;
    MediaController controlVideo;
    Animation topAnim;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.action_bar);
        toolbar.setAnimation(topAnim);
        setSupportActionBar(toolbar);

        firstVideo = findViewById(R.id.firstVideo);
        controlVideo = new MediaController(this);

        String onlineVideoPath = "https://www.shutterstock.com/video/clip-1041630691-abstract-pattern-circles-effect-displacement-white-clean";
        String offlineVideoPath = "android.resource://com.example.dan/" + R.raw.first_video;
        Uri onlineUri = Uri.parse(onlineVideoPath);
        Uri offlineUri = Uri.parse(offlineVideoPath);

        firstVideo.setVideoURI(onlineUri);
        firstVideo.setVideoURI(offlineUri);
        firstVideo.setMediaController(controlVideo);
        controlVideo.setAnchorView(firstVideo);
        firstVideo.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(R.string.decision);

            alertDialogBuilder.setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Intent positiveActivity = new Intent(getApplicationContext(), com.example.dan.LoginSignUpScreen.class);
                    startActivity(positiveActivity);
                }
            });

            alertDialogBuilder.setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else if (id == R.id.action_help) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.contact_developer) {
            Toast.makeText(this, "You will now be directed to developer", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_faq) {
            Toast.makeText(this, "You Just Clicked FAQ", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}