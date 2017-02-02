package Fragments;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.illumicon.novena.R;

/**
 * Created by Edgar on 21/11/2016.
 */

public class Cancion extends Fragment {

    public int myCancion;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cancion,
                container, false);

        WebView texto = (WebView)view.findViewById(R.id.canciontext);

        Resources res = getResources();
        String[] dias = res.getStringArray(R.array.canciones);
        String letra =  "";

        switch(myCancion)
        {
            case 0:
                letra = res.getString(R.string.tutaina);
                break;
            case 1:
                letra = res.getString(R.string.anton);
                break;
            case 2:
                letra= res.getString(R.string.nanitanana);
                break;
            case 3:
                letra = res.getString(R.string.pastores);
                break;
            case 4:
                letra = res.getString(R.string.burrito);
                break;
            case 5:
                letra = res.getString(R.string.noche);
                break;
            case 6:
                letra = res.getString(R.string.campana);
                break;
            case 7:
                letra = res.getString(R.string.peces);
                break;
            case 8:
                letra = res.getString(R.string.tamborilero);
                break;
            case 9:
                letra = res.getString(R.string.zagalillos);
                break;
            case 10:
                letra = res.getString(R.string.salve);
                break;
        }

        texto.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        texto.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        if (Build.VERSION.SDK_INT >= 19) {
            texto.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            texto.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        texto.loadData(letra, "text/html", "UTF-8");

        return view;
    }
}