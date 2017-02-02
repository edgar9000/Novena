package Fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.illumicon.novena.Novena;
import com.illumicon.novena.R;

import java.io.Console;

/**
 * Created by Edgar on 20/11/2016.
 */

public class ConsideracionesDiarias extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.consideracionesdiarias,
                container, false);

        String[] diasArray = {
                "Novena día primero | 16 de diciembre",
                "Novena día segundo | 17 de diciembre",
                "Novena día tercero | 18 de diciembre",
                "Novena día cuarto  | 19 de diciembre",
                "Novena día quinto  | 20 de diciembre",
                "Novena día sexto   | 21 de diciembre",
                "Novena día séptimo | 22 de diciembre",
                "Novena día octavo  | 23 de diciembre",
                "Novena día noveno  | 24 de diciembre"};

        ArrayAdapter diasAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                diasArray);

        ListView listView = (ListView) view.findViewById(android.R.id.list);
        listView.setAdapter(diasAdapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {

        Novena miNovena = (Novena)getActivity();

        Fragment fragmento = miNovena.model.getNextItem();
        if (fragmento.getClass().getSimpleName().equals(DiasNovena.class.getSimpleName()))
        {
            ((DiasNovena)fragmento).myPage = position;
        }

        miNovena.setFragment(fragmento);
    }
}
