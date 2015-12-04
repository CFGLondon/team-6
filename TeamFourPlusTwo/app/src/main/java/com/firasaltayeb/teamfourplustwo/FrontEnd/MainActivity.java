package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firasaltayeb.teamfourplustwo.R;

public class MainActivity extends AppCompatActivity {

    public Button volunteer;
    public Button elderly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volunteer = (Button) findViewById(R.id.btnVolunteer);
        elderly = (Button) findViewById(R.id.btnElderly);
    }


    public void startVolunteerActivity(View view) {
        Intent intent = new Intent(this, VolunteerActivity.class);
        startActivity(intent);
    }

    public void startElderlyActivity(View view) {
        Intent intent = new Intent(this, ElderlyActivity.class);
        startActivity(intent);
    }
}
