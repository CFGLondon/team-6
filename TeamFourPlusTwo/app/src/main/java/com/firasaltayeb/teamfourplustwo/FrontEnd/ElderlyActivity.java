package com.firasaltayeb.teamfourplustwo.FrontEnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.firasaltayeb.teamfourplustwo.R;


public class ElderlyActivity extends AppCompatActivity {

    RadioButton radioButtonM;
    RadioButton radioButtonF;
    SeekBar seekBar;
    TextView seekBarTxtView;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonM = (RadioButton) findViewById(R.id.radioButtonM);
        radioButtonF = (RadioButton) findViewById(R.id.radioButtonF);

        seekBar();

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //linearLayout.setBackgroundColor(Color.RED);
                //Log.d("color", parent.getItemAtPosition(position) + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void seekBar() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarTxtView = (TextView) findViewById(R.id.seekBarTxtView);
        seekBarTxtView.setText(seekBar.getProgress() + "");
        seekBar.setMax(102);
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
     * Called when the user clicks the Send button
     */
    public void saveMessage(View view) {
        // Do something in response to button
        EditText nameEditTxt = (EditText) findViewById(R.id.nameEditTxt);

        String message = nameEditTxt.getText().toString();
        String message2 = seekBarTxtView.getText().toString();
        String message3;

        if (radioButtonM.isChecked()) {
            message3 = "male";
        } else {
            message3 = "female";
        }
    }
}
