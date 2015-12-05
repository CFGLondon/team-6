package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.firasaltayeb.teamfourplustwo.BackEnd.Volunteers;
import com.firasaltayeb.teamfourplustwo.BackEnd.Volunteer;
import com.firasaltayeb.teamfourplustwo.R;

public class VolunteerActivity extends AppCompatActivity {

    EditText nameEditTxt;
    RadioButton radioButtonM;
    RadioButton radioButtonF;
    SeekBar seekBar;
    TextView seekBarTxtView;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        radioButtonM = (RadioButton) findViewById(R.id.radioButtonM);
        radioButtonF = (RadioButton) findViewById(R.id.radioButtonF);
        nameEditTxt = (EditText) findViewById(R.id.nameEditTxt);

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
        String name = nameEditTxt.getText().toString();

        String gender;
        if(radioButtonF.isChecked()){
            gender = "Female";
        }else{
            gender = "male";
        }

        int age = Integer.parseInt(seekBarTxtView.getText().toString());

        Log.d("name", name);
        Log.d("gender", gender);
        Log.d("Age", Integer.parseInt(seekBarTxtView.getText().toString()) + "");


        Volunteer volunteer =  new Volunteer(name,gender,age);
        Volunteers.AddVolunteers(volunteer);

    }
}
