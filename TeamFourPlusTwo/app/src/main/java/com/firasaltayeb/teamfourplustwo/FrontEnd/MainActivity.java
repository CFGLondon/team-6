package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.firasaltayeb.teamfourplustwo.BackEnd.JSONfunctions;
import com.firasaltayeb.teamfourplustwo.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> databaseInfo = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject jsonobject;
        jsonobject = JSONfunctions.getJSONfromURL("http:ec2-54-78-38-127.eu-west-1.compute.amazonaws.com");

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
