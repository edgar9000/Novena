package com.illumicon.novena;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Fragments.ListaCanciones;

public class Canciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);

        Fragment listaCanciones = new ListaCanciones();
        this.setFragment(listaCanciones);
    }

    public void setFragment(Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.cancionesLayout, fragment);
        if (!fragment.getClass().getSimpleName().equals(ListaCanciones.class.getSimpleName())) {
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}
