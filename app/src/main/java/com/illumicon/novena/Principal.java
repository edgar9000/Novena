package com.illumicon.novena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.R.attr.button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageButton novena = (ImageButton) findViewById(R.id.novenaBtn);
        ImageButton canciones = (ImageButton) findViewById(R.id.cancionesBtn);

        novena.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Principal.this,Novena.class);
                intent.putExtra("activity_name","Novena");
                startActivity(intent);
            }
        });

        canciones.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Principal.this,Canciones.class);
                intent.putExtra("activity_name","Canciones");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
