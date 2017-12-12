package com.example.aaron.finaltry;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {



    private String firstName = "";
    private String lastName = "";
    private String phone = "";
    private String birthDate = "";
    private String isDegreeCertificate = "";
    private String degreeCert = "";

    private Toast toastError = null;
    private CheckedTextView checkedTextView1;
    private CheckedTextView checkedTextView2;
    private CheckedTextView checkedTextView3;
    private CheckedTextView checkedTextView4;

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        checkedTextView1 = (CheckedTextView) findViewById(R.id.checkedTextView1);
        checkedTextView2 = (CheckedTextView) findViewById(R.id.checkedTextView2);
        checkedTextView3 = (CheckedTextView) findViewById(R.id.checkedTextView3);
        checkedTextView4 = (CheckedTextView) findViewById(R.id.checkedTextView4);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioButton7 = (RadioButton) findViewById(R.id.radioButton7);
        radioButton8 = (RadioButton) findViewById(R.id.radioButton8);

        final Button button3 = (Button) findViewById(R.id.button3);

        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            firstName = extras.getString("FirstName");
            lastName = extras.getString("LastName");
            phone = extras.getString("Phone");
            birthDate = extras.getString("BirthDate");
            isDegreeCertificate = extras.getString("isDegreeCertificate");
            degreeCert = extras.getString("degreeCert");
        }

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioButton;

                String checkedTextView1Text = "";
                String checkedTextView2Text = "";
                String checkedTextView3Text = "";
                String checkedTextView4Text = "";

                String radio1Txt = "";
                String radio2Txt = "";
                String radio3Txt = "";
                String radio4Txt = "";

                radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
                radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
                radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
                radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
                int selectedTime1 = 0; int selectedTime2 = 0; int selectedTime3 = 0; int selectedTime4 = 0;

                if (checkedTextView1.isChecked()){
                    checkedTextView1Text = checkedTextView1.getText().toString();
                    selectedTime1 = radioGroup1.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime1);
                    radio1Txt = radioButton.getText().toString();
                }

                if (checkedTextView2.isChecked()){
                    checkedTextView1Text = checkedTextView1.getText().toString();
                    selectedTime2 = radioGroup2.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime2);
                    radio1Txt = radioButton.getText().toString();
                }
                if (checkedTextView3.isChecked()){
                    checkedTextView1Text = checkedTextView1.getText().toString();
                    selectedTime3 = radioGroup3.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime3);
                    radio1Txt = radioButton.getText().toString();
                }
                if (checkedTextView4.isChecked()){
                    checkedTextView1Text = checkedTextView1.getText().toString();
                    selectedTime4 = radioGroup4.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime4);
                    radio1Txt = radioButton.getText().toString();
                }

                if(radioCheck(selectedTime1,selectedTime2, selectedTime3, selectedTime4)){
                    Intent nextScreen = new Intent(Main3Activity.this, Main4Activity.class);
                    nextScreen.putExtra("FirstName",firstName);
                    nextScreen.putExtra("LastName",lastName);
                    nextScreen.putExtra("Phone",phone);
                    nextScreen.putExtra("BirthDate",birthDate);
                    nextScreen.putExtra("isDegreeCertificate", isDegreeCertificate);
                    nextScreen.putExtra("degreeCert",degreeCert);

                    nextScreen.putExtra("Class1", checkedTextView1Text);
                    nextScreen.putExtra("selected1", radio1Txt);

                    nextScreen.putExtra("Class2",checkedTextView2Text);
                    nextScreen.putExtra("selected2",radio2Txt);

                    nextScreen.putExtra("Class3", checkedTextView3Text);
                    nextScreen.putExtra("selected3", radio3Txt);

                    nextScreen.putExtra("Class4", checkedTextView4Text);
                    nextScreen.putExtra("selected4", radio4Txt);

                    startActivity(nextScreen);
                }else {
                    toastError.makeText(getApplicationContext(),"Timeslot Conflict.", toastError.LENGTH_SHORT).show();
                }
            }
        });

        checkedTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedTextView1.isChecked()){
                    enableDisable(checkedTextView1, radioButton1,radioButton2, Color.WHITE, false);
                }else{
                    enableDisable(checkedTextView1, radioButton1, radioButton2, Color.GRAY, true);
                }
            }
        });

        checkedTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedTextView2.isChecked()){
                    enableDisable(checkedTextView2, radioButton3,radioButton4, Color.WHITE, false);
                }else{
                    enableDisable(checkedTextView2, radioButton3, radioButton4, Color.GRAY, true);
                }
            }
        });

        checkedTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedTextView3.isChecked()){
                    enableDisable(checkedTextView3, radioButton5,radioButton6, Color.WHITE, false);
                }else{
                    enableDisable(checkedTextView3, radioButton5, radioButton6, Color.GRAY, true);
                }
            }
        });

        checkedTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedTextView4.isChecked()){
                    enableDisable(checkedTextView4, radioButton7,radioButton8, Color.WHITE, false);
                }else{
                    enableDisable(checkedTextView4, radioButton7, radioButton8, Color.GRAY, true);
                }
            }
        });
    }

    public void enableDisable(CheckedTextView checkedTextView, RadioButton radioButton1, RadioButton radioButton2, Integer bgColor, Boolean state){
        checkedTextView.setChecked(state);
        checkedTextView.setBackgroundColor(bgColor);
        radioButton1.setEnabled(state);
        radioButton2.setEnabled(state);

        if (!state){
            radioButton1.setChecked(state);
            radioButton2.setChecked(state);
        }
    }

    public boolean radioCheck(int selectedTime1, int selectedTime2, int selectedTime3, int selectedTime4){

        if((selectedTime1 == R.id.radioButton2) && (selectedTime4 == R.id.radioButton7)){
            radioButton2.setError("TimeLot Conflict");
            radioButton7.setError("Timelot Conflict");
            return false;
        }

        if((selectedTime1 == R.id.radioButton1) && (selectedTime2 == R.id.radioButton3)){
            radioButton1.setError("TimeLot Conflict");
            radioButton3.setError("Timelot Conflict");
            return false;
        }

        if((selectedTime3 == R.id.radioButton5) && (selectedTime4 == R.id.radioButton8)){
            radioButton5.setError("TimeLot Conflict");
            radioButton8.setError("Timelot Conflict");
            return false;
        }

        return true;
    }
}
