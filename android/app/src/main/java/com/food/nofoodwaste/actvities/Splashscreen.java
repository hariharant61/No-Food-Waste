package com.food.nofoodwaste.actvities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.food.nofoodwaste.R;
import com.food.nofoodwaste.utils.AppSharedPreferences;
import com.food.nofoodwaste.utils.MyConstants;

public class Splashscreen extends Activity {

    public int Time_DelayForRequest = 1000;
    public int splashScreentime = 2 * Time_DelayForRequest;
    Thread background;
    AppSharedPreferences appSharedPreferences;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        appSharedPreferences = new AppSharedPreferences(Splashscreen.this);
        final boolean isLoggedIn = appSharedPreferences.getBooleanPreferences(MyConstants.PREF_KEY_IS_LOGGEDIN);

        background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep
                    sleep(splashScreentime);

                    if (isLoggedIn) {
                        Intent myIntent = new Intent(Splashscreen.this, DashBoardActivity.class);
                        startActivity(myIntent);

                    } else {
                        Intent myIntent = new Intent(Splashscreen.this, LoginActivity.class);
                        startActivity(myIntent);

                    }
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        background.start();
    }
}
