package com.example.controle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Salle extends AppCompatActivity {
    Button salle1;
    Button salle2;
    Button salle3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salle);
        salle1 = findViewById(R.id.firstsalle);
        salle2 = findViewById(R.id.secondsalle);
        salle3 = findViewById(R.id.thirdsalle);
        salle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.controle.Salle.this, " Salle une ", Toast.LENGTH_SHORT).show();
                //Add the code of the otheractivity
                Intent intent = new Intent(  com.example.controle.Salle.this, com.example.controle.CAPTEUR.class);
                startActivity(intent);

            }
        });
        salle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.controle.Salle.this, " Deuxième Salle  ", Toast.LENGTH_SHORT).show();
                //Add the new activity's code
                Intent intent = new Intent(  com.example.controle.Salle.this,CapteurValue.class);
                startActivity(intent);
            }
        });
        salle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.controle.Salle.this, "  Troisième Salle  ", Toast.LENGTH_SHORT).show();
                //Add the new activity's code
                Intent intent = new Intent(  com.example.controle.Salle.this,Capteurs.class);
                startActivity(intent);

            }
        });


    }
    private void FindViewById(int firstsalle) {
    }
}