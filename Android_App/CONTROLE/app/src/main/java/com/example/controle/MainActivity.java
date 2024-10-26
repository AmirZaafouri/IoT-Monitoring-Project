package com.example.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private EditText epassword;
    private Button eLogin;
    ImageView imageView12,imageView9,imageView10;
    private final String userName = "FSM";
    private final String Password = "FSM";
    boolean isvalid = false;
    private int counter = 5;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView12=findViewById(R.id.imageView12);
        imageView10=findViewById(R.id.imageView10);
        imageView9=findViewById(R.id.imageView9);
        eName = findViewById(R.id.etName);
        epassword = findViewById(R.id.etpassword);
        eLogin = findViewById(R.id.etLogin);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.bg_color)));

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputpassword = epassword.getText().toString();
                if (inputName.isEmpty() ||(inputpassword.isEmpty()))
                {
                    Toast.makeText(MainActivity.this, "please enter all details correctly!!!", Toast.LENGTH_SHORT).show();
                }else{
                    isvalid  = validate(inputName, inputpassword) ;
                    if (!isvalid) {
                        counter--;
                        Toast.makeText(MainActivity.this, "incorrect credentials entered!!!", Toast.LENGTH_SHORT).show();

//                        if (counter == 0) {
//                            eLogin.setEnabled(false);
//                        } else {
//                            Toast.makeText(MainActivity.this, " Login successful !", Toast.LENGTH_SHORT).show();
//                            //Add the code to go to new activity
//                            Intent intent = new Intent(MainActivity.this, Salle.class);
//                            startActivity(intent);
//
//
//                        }

                    }else{
                        Toast.makeText(MainActivity.this, " Login successful !", Toast.LENGTH_SHORT).show();
                            //Add the code to go to new activity
                            Intent intent = new Intent(MainActivity.this, Salle.class);
                            startActivity(intent);
                    }
                }


            }
        });
    }
    private boolean validate(String inputName,String inputpassword){
        if(userName.equals(inputName) && Password.equals(inputpassword)){
            return true;
        }
        return false;


    }
}