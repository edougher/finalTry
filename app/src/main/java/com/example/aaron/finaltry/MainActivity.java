package com.example.aaron.finaltry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtLogin = (TextView) findViewById(R.id.loginTxt);
        final TextView txtPassword = (TextView) findViewById(R.id.passWord);
        Button btnLogin = (Button) findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(txtLogin.getText().toString(), txtPassword.getText().toString());
            }
        });

    }

    private void login(String userName, String userPassword) {

        if ((userName.equals("Erin") && (userPassword.equals("password")))) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        } else {
            Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show();
        }
    }
}
