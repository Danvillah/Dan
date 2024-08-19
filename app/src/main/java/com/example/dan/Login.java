package com.example.dan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    //When the Back button is clicked.
    public void callLoginSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginSignUpScreen.class);
        startActivity(intent);
    }

    //When the Login button is clicked.
    public void callUserAccount(View view) {

        if (isConnected(this)) {
            showCustomDialog();
        }
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.login_direct), "transition_login_user");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }

    //Actions to perform when not connected to internet.
    private boolean isConnected(Login login) {

        ConnectivityManager connectivityManager = (ConnectivityManager) login.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConnect = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConnect = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConnect != null && wifiConnect.isConnected()) || (mobileConnect != null && mobileConnect.isConnected());
    }

    //Dialog to show when not connected to internet.
    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setMessage("Connect to the internet to proceed further");
        builder.setCancelable(false);
        builder.setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(), LoginSignUpScreen.class));
                finish();
            }
        });
    }

    //When the Create Account button is clicked.
    public void callSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
    }


}