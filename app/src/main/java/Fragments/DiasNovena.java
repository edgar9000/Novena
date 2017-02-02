package Fragments;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.illumicon.novena.R;

/**
 * Created by Edgar on 20/11/2016.
 */

public class DiasNovena extends Fragment {

    private FragmentActivity myContext;
    public int myPage;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.diasnovena,
                container, false);

        FragmentManager fragManager = myContext.getSupportFragmentManager();

        Toolbar toolbar = (Toolbar)fragManager.findFragmentById(R.id.toolbar);
        toolbar.validateToolbar();

        WebView texto = (WebView)view.findViewById(R.id.diaText);
        texto.setBackgroundColor(Color.TRANSPARENT);
        texto.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        Resources res = getResources();
        String[] dias = res.getStringArray(R.array.dias_novena);

        texto.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        texto.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        /*
        if (Build.VERSION.SDK_INT >= 19) {
            texto.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            texto.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        */

        texto.loadData(dias[myPage], "text/html", "UTF-8");
        
        return view;
    }
}
