package Fragments;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.illumicon.novena.R;

/**
 * Created by Edgar on 20/11/2016.
 */

public class OracionTodosLosDias extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.oraciontodoslosdias,
                container, false);

        WebView texto = (WebView)view.findViewById(R.id.oracionDiasText);

        texto.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        texto.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        if (Build.VERSION.SDK_INT >= 19) {
            texto.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            texto.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        texto.loadData(getString(R.string.oraciontodoslosdias), "text/html", "UTF-8");

        return view;
    }
}
