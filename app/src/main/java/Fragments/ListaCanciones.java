package Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.illumicon.novena.Canciones;
import com.illumicon.novena.Novena;
import com.illumicon.novena.R;

/**
 * Created by Edgar on 21/11/2016.
 */

public class ListaCanciones extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listacanciones,
                container, false);

        Resources res = getResources();
        String[] canciones = res.getStringArray(R.array.canciones);

        ArrayAdapter cancionesAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                canciones);

        ListView listView = (ListView) view.findViewById(android.R.id.list);
        listView.setAdapter(cancionesAdapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {


        FragmentActivity myContext = (FragmentActivity) getActivity();

        if (myContext.getClass().getSimpleName().equals(Canciones.class.getSimpleName()))
        {
            Canciones misCanciones = (Canciones)getActivity();

            Cancion cancion = new Cancion();
            cancion.myCancion = position;

            misCanciones.setFragment(cancion);
        }
        else if (myContext.getClass().getSimpleName().equals(Novena.class.getSimpleName()))
        {
            Novena miNovena = (Novena)getActivity();

            Fragment fragmento = miNovena.model.getNextItem();
            if (fragmento.getClass().getSimpleName().equals(Cancion.class.getSimpleName()))
            {
                ((Cancion)fragmento).myCancion = position;
            }

            miNovena.setFragment(fragmento);
        }
    }
}
