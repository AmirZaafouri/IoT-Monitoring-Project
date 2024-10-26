package com.somon.bdcache;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {
    Button Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Next = (Button) findViewById(R.id.tonext);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.somon.bdcache.Homepage.this, " Welcome to next activity ", Toast.LENGTH_SHORT).show();
                //Add the code of the otheractivity
                Intent intent = new Intent(  com.somon.bdcache.Homepage.this,MainActivity.class);
                startActivity(intent);
            }
        });







    }
}