package com.example.dan;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSignUpScreen extends AppCompatActivity {

    //Variables
    Animation topAnim, bottomAnim;
    Button login, signUp, contactUs;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_sign_up_screen);

        login = findViewById(R.id.login);
        signUp = findViewById(R.id.signUp);
        contactUs = findViewById(R.id.contactUs);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        login.setAnimation(bottomAnim);
        signUp.setAnimation(bottomAnim);
        contactUs.setAnimation(topAnim);

    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    //When the Login Button is clicked.
    public void callLoginScreen(View view) {
        Button button = findViewById(R.id.login);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(animation);
        Intent intent = new Intent(getApplicationContext(), Login.class);
        //Add Transitions
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.login), "transition_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginSignUpScreen.this, pairs);
        startActivity(intent, options.toBundle());
    }

    //When the SignUp button is clicked.
    public void callSignUpScreen(View view) {
        Button button = findViewById(R.id.signUp);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(animation);
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.signUp), "transition_sign_up");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginSignUpScreen.this, pairs);
        startActivity(intent, options.toBundle());
    }

    //When the Contact Us button is clicked.
    public void contactUs(View view) {
        Intent intent = new Intent(getApplicationContext(), ContactUs.class);
        startActivity(intent);
    }

}