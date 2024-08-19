package com.example.dan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUp2nd extends AppCompatActivity {

    //Variables
    ImageView backButton;
    TextView titleText;
    Button next, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2nd);

        //Hooks
        backButton = findViewById(R.id.sign_up_back_button);
        titleText = findViewById(R.id.sign_up_title_text);
        next = findViewById(R.id.sign_up_next_button);
        login = findViewById(R.id.sign_up_login_button);

    }

    //When the Back button is clicked.
    public void callPreviousSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        //Add Transitions
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backButton, "create_account_back_button");
        pairs[1] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[2] = new Pair<View, String>(next, "transition_next_sign_up");
        pairs[3] = new Pair<View, String>(login, "transition_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2nd.this, pairs);
        startActivity(intent, options.toBundle());
    }

    //When the Next button is clicked.
    public void callNextSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp3rd.class);
        //Add Transitions
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backButton, "create_account_back_button");
        pairs[1] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[2] = new Pair<View, String>(next, "transition_next_sign_up");
        pairs[3] = new Pair<View, String>(login, "transition_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2nd.this, pairs);
        startActivity(intent, options.toBundle());
    }

    //When the Login button is clicked.
    public void callLoginScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

}