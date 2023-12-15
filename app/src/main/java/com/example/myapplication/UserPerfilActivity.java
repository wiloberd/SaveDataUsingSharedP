package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);

        Intent intent = getIntent();
        String saudacaoUser = intent.getStringExtra("nome");

        TextView viewSaudacao = findViewById(R.id.viewSaudacao);
        viewSaudacao.setText(saudacaoUser);

    }


    public  void abreLoginRegister(View view){
        Intent i = new Intent(UserPerfilActivity.this, LoginActivity.class);
        startActivity(i);

    }
}