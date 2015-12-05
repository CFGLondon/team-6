package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firasaltayeb.teamfourplustwo.R;

public class ResultActivity extends AppCompatActivity {

    TextView txtViewFirstName;
    TextView txtViewLastName;
    TextView ageTxtView;
    TextView txtViewIneterst;
    TextView genderTxtView;
    TextView txtViewAddress;
    TextView txtViewBlack;
    TextView txtViewWhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();

        String message;
        String message2;
        String message3;
        String message4;
        String message5;
        String message6;
        String message7;
        String message8;


        try {
             message = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE);
             message2 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE2);
             message3 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE3);
             message4 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE4);
             message5 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE5);
             message6 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE6);
             message7 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE7);
             message8 = intent.getStringExtra(ElderlyActivity.EXTRA_MESSAGE8);
        }catch (Exception e){
             message = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE);
             message2 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE2);
             message3 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE3);
             message4 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE4);
             message5 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE5);
             message6 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE6);
             message7 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE7);
             message8 = intent.getStringExtra(VolunteerActivity.EXTRA_MESSAGE8);
        }

        txtViewFirstName = (TextView) findViewById(R.id.txtViewFirstName);
        txtViewLastName = (TextView) findViewById(R.id.txtViewLastName);
        ageTxtView = (TextView) findViewById(R.id.ageTxtView);
        txtViewIneterst = (TextView) findViewById(R.id.txtViewIneterst);
        genderTxtView = (TextView) findViewById(R.id.genderTxtView);
        txtViewAddress = (TextView) findViewById(R.id.txtViewAddress);
        txtViewBlack = (TextView) findViewById(R.id.txtViewBlack);
        txtViewWhite = (TextView) findViewById(R.id.txtViewWhite);


        txtViewFirstName.setText(message);
        txtViewLastName.setText(message2);
        ageTxtView.setText(message3);
        txtViewIneterst.setText(message4);
        genderTxtView.setText(message5);
        txtViewAddress.setText(message6);
        txtViewBlack.setText(message7);
        txtViewWhite.setText(message8);
    }
}
