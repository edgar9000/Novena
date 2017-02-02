package com.illumicon.novena;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Contracts.IActivity;
import Contracts.IModel;
import Fragments.ListaCanciones;
import Fragments.OracionTodosLosDias;
import Fragments.Toolbar;
import Model.NovenaModel;

public class Novena extends AppCompatActivity implements IActivity {

    public IModel model;
    Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        model = new NovenaModel();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novena);

        if (findViewById(R.id.novenaLayout) != null) {

            if (savedInstanceState != null) {
                return;
            }

            this.setFragment(model.getNextItem());

            //firstFragment.setArguments(getIntent().getExtras());

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            //transaction.replace(R.id.novenaLayout, firstFragment);

            // Add the fragment to the 'fragment_container' FrameLayout
        }
    }

    public void setFragment(Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.novenaLayout, fragment);
        if (!fragment.getClass().getSimpleName().equals(OracionTodosLosDias.class.getSimpleName())) {
            ft.addToBackStack(null);
        }

        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (this.model.getCurrentFragmentName().equals(OracionTodosLosDias.class.getSimpleName()))
        {
            Intent intent=new Intent(Novena.this,Principal.class);
            intent.putExtra("activity_name","Principal");
            startActivity(intent);
        }
        else
        {
            this.setFragment(this.model.getPreviousItem());
        }

        Toolbar toolbar = (Toolbar)this.getSupportFragmentManager().findFragmentById(R.id.toolbar);
        toolbar.validateToolbar();
    }
}
