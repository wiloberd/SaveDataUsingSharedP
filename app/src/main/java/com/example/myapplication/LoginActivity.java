package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private String nomeUsuario;
    private String userEmail;
    private String userSenha;
    private  String userEmailSalvo = "wiloberd10@gmail.com";
    private String userSenhaSalvo = "123";
    private EditText inputEmail;
    private  EditText inputSenha;
    private Button btnLogin;
    private Button btnCadastraSe;
    private TextView erroLogin;
    private SharedPreferences memoria;
    private SharedPreferences.Editor editor;

    private String nomeSalvo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.idEmailLogin);
        inputSenha = findViewById(R.id.idSenhaLogin);
        btnLogin = findViewById(R.id.idBtnEntrarLogin);
        btnCadastraSe = findViewById(R.id.idBtnCadastrarLogin);

        erroLogin = findViewById(R.id.erroLoginTextView);

       Intent dadosCadastrarForm = getIntent();
        this.nomeUsuario = dadosCadastrarForm.getStringExtra("usuario");
        this.userEmail = dadosCadastrarForm.getStringExtra("email");
        this.userSenha = dadosCadastrarForm.getStringExtra("senha");
        //erroLogin.setText(String.valueOf(dadosCadastrarForm.getStringExtra("senha")));

        memoria = getSharedPreferences("arquivoUsuarios", 0);
        editor = memoria.edit();
        editor.putString("userName", this.nomeUsuario);
        editor.commit();

        nomeSalvo = memoria.getString("userName", "nenhum dados foi salvo na memoria");
        erroLogin.setText(("Nome recuperado: " + nomeSalvo));


    }

    public void abrePerfil(View view){
        this.userEmail  = inputEmail.getText().toString();
        this.userSenha = inputSenha.getText().toString();


        if (userEmail.equals(userEmailSalvo) && (userSenha.equals(userSenhaSalvo))){
            Intent perfil = new Intent(LoginActivity.this, UserPerfilActivity.class);
            perfil.putExtra("nome", "Olá " + this.userSenha +"!");
            startActivity(perfil);
        } else{
            erroLogin.setText("Email ou senha invalida " + this.userSenha);
        }
    }

    public void abreCadastrar(View view){
        Intent cadastrar = new Intent(LoginActivity.this, CadastrarActivity.class);
        startActivity(cadastrar);
    }

    public void abreMain(View view){
        Intent home = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(home);
    }

}