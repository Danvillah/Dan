package com.example.dan;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);

    }

    //When the Close button is clicked.
    public void cancelCodeVerification(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
    }

    public void callNextCodeVerification(View view) {
        Button button = findViewById(R.id.verify_code);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(animation);
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        //Add Transitions
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.verify_code), "verify_code");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VerifyOTP.this, pairs);
        startActivity(intent, options.toBundle());
    }
}
