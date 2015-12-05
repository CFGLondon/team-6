package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.firasaltayeb.teamfourplustwo.BackEnd.Elderlies;
import com.firasaltayeb.teamfourplustwo.BackEnd.Elderly;
import com.firasaltayeb.teamfourplustwo.R;


public class ElderlyActivity extends AppCompatActivity {


    EditText nameEditTxt;
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
        nameEditTxt = (EditText) findViewById(R.id.nameEditTxt);
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
        String name = nameEditTxt.getText().toString();
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

        Log.d("name", name);
        Log.d("address", address);
        Log.d("blackList", blackList);
        Log.d("whiteList", whiteList);
        Log.d("gender", gender);
        Log.d("Age", Integer.parseInt(seekBarTxtView.getText().toString()) + "");



        Elderly elderly =  new Elderly(name,gender,age,address,blackList,whiteList);
        Elderlies.AddElderlies(elderly);

    }
}
