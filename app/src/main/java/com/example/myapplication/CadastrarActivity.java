package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    private String nomeUsuario = "usuarioManual";
    private String email ="emailManual";
    private String senha = "senhaManual";

    private EditText editUsuario;
    private EditText editEmail;
    private EditText editSenha;
    private Button btnCadastrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editUsuario = findViewById(R.id.idUsuarioCadastrar);
        editEmail = findViewById(R.id.idEmailCadastrar);
        editSenha = findViewById(R.id.idSenhaCadstrar);
        btnCadastrarUsuario = findViewById(R.id.btnCadastrarUsuario);

    }


    public void abreMain(View view){
        Intent home = new Intent(CadastrarActivity.this, MainActivity.class);
        startActivity(home);
    }

    public void abreLogin(View view){
        Intent login = new Intent(CadastrarActivity.this, LoginActivity.class);
        startActivity(login);
    }

    public void cadastrarForm(View view){
        this.nomeUsuario = editUsuario.getText().toString();
        this.email = editEmail.getText().toString();
        this.senha = editSenha.getText().toString();

        Intent home = new Intent(CadastrarActivity.this, LoginActivity.class);
        home.putExtra("usuario", this.nomeUsuario);
        home.putExtra("email", this.email);
        home.putExtra("senha", this.senha);
        Toast.makeText(this, "enviado para o form " + this.senha + this.email + this.nomeUsuario , Toast.LENGTH_SHORT).show();

       startActivity(home);
    }

}