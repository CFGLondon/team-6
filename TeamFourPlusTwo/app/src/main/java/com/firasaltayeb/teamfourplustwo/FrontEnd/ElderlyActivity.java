package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firasaltayeb.teamfourplustwo.BackEnd.Elderlies;
import com.firasaltayeb.teamfourplustwo.BackEnd.Elderly;
import com.firasaltayeb.teamfourplustwo.BackEnd.Volunteers;
import com.firasaltayeb.teamfourplustwo.BackEnd.Volunteer;
import com.firasaltayeb.teamfourplustwo.R;

public class ElderlyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.firasaltayeb.teamfourplustwo.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "com.firasaltayeb.teamfourplustwo.MESSAGE2";
    public final static String EXTRA_MESSAGE3 = "com.firasaltayeb.teamfourplustwo.MESSAGE3";
    public final static String EXTRA_MESSAGE4 = "com.firasaltayeb.teamfourplustwo.MESSAGE4";
    public final static String EXTRA_MESSAGE5 = "com.firasaltayeb.teamfourplustwo.MESSAGE5";
    public final static String EXTRA_MESSAGE6 = "com.firasaltayeb.teamfourplustwo.MESSAGE6";
    public final static String EXTRA_MESSAGE7 = "com.firasaltayeb.teamfourplustwo.MESSAGE7";
    public final static String EXTRA_MESSAGE8 = "com.firasaltayeb.teamfourplustwo.MESSAGE8";

    EditText editTxtFirstName;
    EditText editTxtLastName;
    EditText editTxtInterest;
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
        setContentView(R.layout.activity_elderly);
        radioButtonM = (RadioButton) findViewById(R.id.radioButtonM);
        radioButtonF = (RadioButton) findViewById(R.id.radioButtonF);
        editTxtFirstName = (EditText) findViewById(R.id.editTxtFirstName);
        editTxtLastName = (EditText) findViewById(R.id.editTxtLastName);
        editTxtAddress = (EditText) findViewById(R.id.editTxtAddress);
        editTxtInterest = (EditText) findViewById(R.id.editTxtInterest);
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
        String interest = editTxtInterest.getText().toString();
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
        Log.d("interest", interest);
        Log.d("address", address);
        Log.d("blackList", blackList);
        Log.d("whiteList", whiteList);
        Log.d("gender", gender);
        Log.d("Age", Integer.parseInt(seekBarTxtView.getText().toString()) + "");

        Elderly elderly =  new Elderly(firstName,lastName,gender,age,interest,address,blackList,whiteList);
        Elderlies.AddElderlies(elderly);
        Toast.makeText(getApplicationContext(), "Details saved",
                Toast.LENGTH_LONG).show();

    }

    public void connect(View view) {
        String firstName = editTxtFirstName.getText().toString();
        String lastName = editTxtLastName.getText().toString();
        String interest = editTxtInterest.getText().toString();
        String address = editTxtAddress.getText().toString();
        String blackList = editTxtBlack.getText().toString();
        String whiteList = editTxtWhite.getText().toString();

        Intent intent = new Intent(this, ResultActivity.class);

        String gender;
        if(radioButtonF.isChecked()){
            gender = "Female";
        }else{
            gender = "male";
        }

        int age = Integer.parseInt(seekBarTxtView.getText().toString());

        Elderly elderly =  new Elderly(firstName,lastName,gender,age,interest,address,blackList,whiteList);

        for(Volunteer volunteersItem : Volunteers.VolunteersArray) {
            if (volunteersItem.getInterest().equals(elderly.getInterest()) &&
                    volunteersItem.getWhiteList().equals(elderly.getWhiteList())) {
                Log.d("Volunteer", "exist");
                intent.putExtra(EXTRA_MESSAGE, volunteersItem.getFirstName());
                intent.putExtra(EXTRA_MESSAGE2, volunteersItem.getLastName());
                intent.putExtra(EXTRA_MESSAGE3, volunteersItem.getAge()+"");
                intent.putExtra(EXTRA_MESSAGE4, volunteersItem.getInterest());
                intent.putExtra(EXTRA_MESSAGE5, volunteersItem.getGender());
                intent.putExtra(EXTRA_MESSAGE6, volunteersItem.getAddress());
                intent.putExtra(EXTRA_MESSAGE7, volunteersItem.getBlackList());
                intent.putExtra(EXTRA_MESSAGE8, volunteersItem.getWhiteList());
                startActivity(intent);

            }
            else {
                Log.d("Volunteer", "does not exist");
            }
        }

    }
}
