package Model;

import android.support.v4.app.Fragment;

import java.util.Map;
import java.util.TreeMap;

import Contracts.IModel;
import Fragments.Cancion;
import Fragments.ConsideracionesDiarias;
import Fragments.DiasNovena;
import Fragments.Gozos;
import Fragments.ListaCanciones;
import Fragments.OracionALaVirgen;
import Fragments.OracionJesus;
import Fragments.OracionSanJose;
import Fragments.OracionTodosLosDias;

/**
 * Created by Edgar on 20/11/2016.
 */

public class NovenaModel implements IModel {

    Map<Integer,Fragment> fragmentos;
    Integer index;

    public NovenaModel()
    {
        index = 0;
        fragmentos = new TreeMap<Integer, Fragment>();
        fragmentos.put(1, new OracionTodosLosDias());
        fragmentos.put(2, new OracionALaVirgen());
        fragmentos.put(3, new OracionSanJose());
        fragmentos.put(4, new ConsideracionesDiarias());
        fragmentos.put(5, new DiasNovena());
        fragmentos.put(6, new Gozos());
        fragmentos.put(7, new OracionJesus());
        fragmentos.put(8, new ListaCanciones());
        fragmentos.put(9, new Cancion());
    }

    public Fragment getNextItem()
    {
        index++;

        if (index > fragmentos.size())
        {
            index = 1;
        }

        return fragmentos.get(index);
    }

    public Fragment getPreviousItem()
    {
        index--;

        if (index < 1)
        {
            index = 1;
        }

        return fragmentos.get(index);
    }

    public String getCurrentFragmentName()
    {
        Integer currentIndex = index;

        if (currentIndex == 0)
        {
            currentIndex++;
        }
        return fragmentos.get(currentIndex).getClass().getSimpleName();
    }

    public Fragment getCurrentFragment()
    {
        Integer currentIndex = index;

        if (currentIndex == 0)
        {
            currentIndex++;
        }
        return fragmentos.get(currentIndex);
    }
}
