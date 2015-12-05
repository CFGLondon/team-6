package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.firasaltayeb.teamfourplustwo.BackEnd.Volunteers;
import com.firasaltayeb.teamfourplustwo.BackEnd.Volunteer;
import com.firasaltayeb.teamfourplustwo.R;

public class VolunteerActivity extends AppCompatActivity {

    EditText editTxtFirstName;
    EditText editTxtLastName;
    EditText editTxtAddress;
    EditText editTxtBlack;
    EditText editTxtWhite;
    RadioButton radioButtonM;
    RadioButton radioButtonF;
    SeekBar seekBar;
    TextView seekBarTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        radioButtonM = (RadioButton) findViewById(R.id.radioButtonM);
        radioButtonF = (RadioButton) findViewById(R.id.radioButtonF);
        editTxtFirstName = (EditText) findViewById(R.id.editTxtFirstName);
        editTxtLastName = (EditText) findViewById(R.id.editTxtLastName);
        editTxtAddress = (EditText) findViewById(R.id.editTxtAddress);
        editTxtBlack = (EditText) findViewById(R.id.editTxtBlack);
        editTxtWhite = (EditText) findViewById(R.id.editTxtWhite);

        seekBar();
    }

    public void seekBar() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarTxtView = (TextView) findViewById(R.id.seekBarTxtView);
        seekBarTxtView.setText(seekBar.getProgress() + "");
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarTxtView.setText(progress + "");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
    }

    /**
     * Called when the user clicks the Save button
     */
    public void saveMessage(View view) {
        String firstName = editTxtFirstName.getText().toString();
        String lastName = editTxtLastName.getText().toString();
        String address = editTxtAddress.getText().toString();
        String blackList = editTxtBlack.getText().toString();
        String whiteList = editTxtWhite.getText().toString();

        String gender;
        if(radioButtonF.isChecked()){
            gender = "Female";
        }else{
            gender = "male";
        }

        int age = Integer.parseInt(seekBarTxtView.getText().toString());

        Log.d("firstName", firstName);
        Log.d("lastName", lastName);
        Log.d("address", address);
        Log.d("blackList", blackList);
        Log.d("whiteList", whiteList);
        Log.d("gender", gender);
        Log.d("Age", Integer.parseInt(seekBarTxtView.getText().toString()) + "");

        Volunteer volunteer =  new Volunteer(firstName,lastName,gender,age,address,blackList,whiteList);
        Volunteers.AddVolunteers(volunteer);

    }

    public void connect(View view) {
    }
}
