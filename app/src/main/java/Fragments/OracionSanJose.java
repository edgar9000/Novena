package Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.illumicon.novena.R;

/**
 * Created by Edgar on 20/11/2016.
 */

public class OracionSanJose extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.oracionsanjose,
                container, false);

        WebView texto = (WebView)view.findViewById(R.id.sanJosetext);

        texto.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        texto.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        if (Build.VERSION.SDK_INT >= 19) {
            texto.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            texto.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        texto.loadData(getString(R.string.oracionsanjose), "text/html", "UTF-8");

        return view;
    }
}
