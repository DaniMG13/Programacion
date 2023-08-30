package com.vgsg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btninit = (Button) findViewById(R.id.btninit);
        btninit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt = (EditText) findViewById(R.id.txtuser);
                String usuario = txt.getText().toString();
                Intent i = new Intent(Login.this,MainActivity.class);

                SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("user", usuario);
                editor.commit();
                startActivity(i);
                finish();
            }
        });
    }
}