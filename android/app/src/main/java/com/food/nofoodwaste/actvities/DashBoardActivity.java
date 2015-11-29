package com.food.nofoodwaste.actvities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.food.nofoodwaste.R;
import com.food.nofoodwaste.utils.AppSharedPreferences;
import com.food.nofoodwaste.utils.MyConstants;

public class DashBoardActivity extends AppCompatActivity {

    private RelativeLayout layoutVolunteer;
    private boolean isVolunteer;
    AppSharedPreferences appSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        //initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layoutVolunteer = (RelativeLayout) findViewById(R.id.layout_volunteer);
        appSharedPreferences = new AppSharedPreferences(getApplicationContext());
        isVolunteer = appSharedPreferences.getBooleanPreferences(MyConstants.PREF_KEY_IS_VOLUNTEER);
        if (isVolunteer) {
            layoutVolunteer.setVisibility(View.VISIBLE);
        } else {
            layoutVolunteer.setVisibility(View.GONE);
        }

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.layout_donate_food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donationBtnClick();
            }
        });
        layoutVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volunteerBtnClick();
            }
        });
        findViewById(R.id.layout_map_a_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapLocationBtnClick();
            }
        });

    }

    private void donationBtnClick() {
        Intent intent = new Intent(getApplicationContext(), EnterDonationDetailsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    private void volunteerBtnClick() {
        Intent intent = new Intent(getApplicationContext(), AvailableDonationsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    private void mapLocationBtnClick() {
        Intent intent = new Intent(getApplicationContext(), MapALocationActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

}
