package com.example.reproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Funcion para el boton Rock
    public void Rock(View view) { startActivity(new Intent(this, Rock.class)); }

    //Funcion para el boton Rock
    public void Disco(View view) { startActivity(new Intent(this, Disco.class)); }

    //Funcion para el boton Rock
    public void Techno(View view) { startActivity(new Intent(this, Techno.class)); }

    //Funcion para el boton Rock
    public void Pop(View view) { startActivity(new Intent(this, Pop.class)); }

    //Funcion para el boton Rock
    public void Reggae(View view) { startActivity(new Intent(this, Reggae.class)); }
}