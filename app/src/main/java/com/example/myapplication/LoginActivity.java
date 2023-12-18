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

    //private String nomeUsuario;
    private String userEmail;
    private String userSenha;
   // private  String userEmailSalvo = "wiloberd10@gmail.com";
   // private String userSenhaSalvo = "123";
    private EditText inputEmail;
    private  EditText inputSenha;
    private Button btnLogin;
    private Button btnCadastraSe;
    private TextView erroLogin;
    private SharedPreferences memoria;
    private SharedPreferences.Editor editor;
    private String userSalvo, emailSalvo, senhaSalvo;

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
        this.userSalvo = dadosCadastrarForm.getStringExtra("usuario");
        this.emailSalvo = dadosCadastrarForm.getStringExtra("email");
        this.senhaSalvo = dadosCadastrarForm.getStringExtra("senha");
        //erroLogin.setText(String.valueOf(dadosCadastrarForm.getStringExtra("senha")));

        memoria = getSharedPreferences("arquivoUsuarios", 0);
        editor = memoria.edit();
        editor.putString("userName", this.userSalvo);
        editor.putString("userEmail", this.emailSalvo);
        editor.putString("userSenha", this.senhaSalvo);
        editor.commit();

        userSalvo = memoria.getString("userName", "nome usuario não foi encontrado na memoria");
        emailSalvo = memoria.getString("userEmail", "email não foi encontrado na memoria");
        senhaSalvo = memoria.getString("userSenha", "senha não foi encontrado na memoria");

        //erroLogin.setText(("Nome usuario: " + userSalvo + " email: " + emailSalvo + " senha: " + senhaSalvo));

    }

    public void abrePerfil(View view){
        this.userEmail  = inputEmail.getText().toString();
        this.userSenha = inputSenha.getText().toString();

        if (userEmail.equals(emailSalvo) && (userSenha.equals(senhaSalvo))){
            Intent perfil = new Intent(LoginActivity.this, UserPerfilActivity.class);
            perfil.putExtra("nome", "Olá " + this.userSalvo +"!");
            startActivity(perfil);
        } else{
            erroLogin.setText("Email ou senha invalida.");
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