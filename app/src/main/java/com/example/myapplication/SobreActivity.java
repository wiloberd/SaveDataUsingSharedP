package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SobreActivity extends AppCompatActivity {

    private EditText etUser, etPass;

    private CheckBox cbRememberUser;

    private SharedPreferences mySavedData;
    private SharedPreferences.Editor mySavedDataEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        cbRememberUser = findViewById(R.id.cbRememberUser);

        mySavedData = getSharedPreferences("mySavedDataFile", Context.MODE_PRIVATE);
        mySavedDataEditor = mySavedData.edit();

        if(mySavedData.getBoolean("remUser",false)) {

            etUser.setText(mySavedData.getString("user", "nil"));
            etPass.setText(mySavedData.getString("pass", "nil"));
            cbRememberUser.setChecked(true);

        }

    }

    public void onClickLogin(View view) {

        if (cbRememberUser.isChecked()) {

            mySavedDataEditor.putString("user", etUser.getText().toString());
            mySavedDataEditor.putString("pass", etPass.getText().toString());
            mySavedDataEditor.putBoolean("remUser", true);
            mySavedDataEditor.commit();

        } else {

            mySavedDataEditor.putBoolean("remUser", false);
            mySavedDataEditor.commit();

        }

        Toast.makeText(getApplicationContext(), "Login em progresso...", Toast.LENGTH_LONG).show();

    }
}