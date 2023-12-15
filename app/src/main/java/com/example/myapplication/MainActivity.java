package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mySavedData;
    private SharedPreferences.Editor mySavedDataEditor;

    private Button btnLoginRegister;

    private TextView headerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnLoginRegister = findViewById(R.id.loginRegister);

        headerText = findViewById(R.id.text1);

        mySavedData = getSharedPreferences("mySavedDataFile", Context.MODE_PRIVATE);
        mySavedDataEditor = mySavedData.edit();

        if(mySavedData.getBoolean("remUser",false)) {
            headerText.setText("Olá "+mySavedData.getString("user", "nil")+", Esse é o IFC Camboriú");

        }

    }



    public  void abreLoginRegister(View view){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);

    }



}