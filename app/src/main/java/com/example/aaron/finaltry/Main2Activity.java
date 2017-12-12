package com.example.aaron.finaltry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Spinner spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        final Spinner spinnerCert = (Spinner) findViewById(R.id.spinnerCertificate);
        final Spinner spinnerDegree = (Spinner) findViewById(R.id.spinnerDegree);
        final Switch swDegree = (Switch) findViewById(R.id.switchDegree);
        final Button btnNext = (Button) findViewById(R.id.button);

        final EditText etFirstName = (EditText) findViewById(R.id.etFirstName);
        final EditText etLastName = (EditText) findViewById(R.id.etLastName);
        final EditText etPhone = (EditText) findViewById(R.id.phoneNumber);
        final EditText etDay = (EditText) findViewById(R.id.etDay);
        final EditText etYear = (EditText) findViewById(R.id.etYear);

        final TextView txtCert = (TextView) findViewById(R.id.lblCertificate);
        final TextView txtMajor = (TextView) findViewById(R.id.lblMajor);

        etFirstName.requestFocus();

        swDegree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    spinnerDegree.setVisibility(View.VISIBLE);
                    txtMajor.setVisibility(View.VISIBLE);
                    spinnerCert.setVisibility(View.GONE);
                    txtCert.setVisibility(View.GONE);

                }else{
                    spinnerDegree.setVisibility(View.GONE);
                    txtMajor.setVisibility(View.GONE);
                    spinnerCert.setVisibility(View.VISIBLE);
                    txtCert.setVisibility(View.VISIBLE);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    String doBirth;
                    doBirth = spinnerMonth.getSelectedItem().toString() + "/" + etDay.getText().toString() + "/" + etYear.getText().toString();

                    Intent nextScreen = new Intent(Main2Activity.this, Main3Activity.class);
                    nextScreen.putExtra("First Name", etFirstName.getText().toString());
                    nextScreen.putExtra("Last Name", etLastName.getText().toString());
                    nextScreen.putExtra("Phone", etPhone.getText().toString());
                    nextScreen.putExtra("Date Of Birth", doBirth);


                    if (spinnerDegree.getVisibility() == View.VISIBLE){
                        nextScreen.putExtra("isDegreeCert","Degree");
                        nextScreen.putExtra("degreeCert", spinnerDegree.getSelectedItem().toString());

                    }else {
                        nextScreen.putExtra("isDegreeCert", "Certificate");
                        nextScreen.putExtra("degreeCert", spinnerCert.getSelectedItem().toString());
                    }

                    startActivity(nextScreen);
                }
            }
        });
    }

    private boolean checkData(){
        final EditText etFirstName = (EditText) findViewById(R.id.etFirstName);
        final EditText etLastName = (EditText) findViewById(R.id.etLastName);
        final EditText etPhone = (EditText) findViewById(R.id.phoneNumber);
        final EditText etDay = (EditText) findViewById(R.id.etDay);
        final EditText etYear = (EditText) findViewById(R.id.etYear);

        if(etFirstName.getText().toString().isEmpty()){
            etFirstName.setError("Invalid First Name");
            etFirstName.requestFocus();
            return false;
        }

        if (etLastName.getText().toString().isEmpty()){
            etLastName.setError("Invalid Last Name");
            etLastName.requestFocus();
            return false;
        }

        if (etPhone.getText().toString().isEmpty()){
            etPhone.setError("Please Enter a Phone Number");
            etPhone.requestFocus();
            return false;
        }

        if (etDay.getText().toString().isEmpty()){
            etDay.setError("Please Enter The Day you Were Born");
            etDay.requestFocus();
            return false;
        }

        if (etYear.getText().toString().isEmpty()){
            etYear.setError("Please Enter What Year You Were Born");
            etYear.requestFocus();
            return false;
        }

        return true;

    }
    }

