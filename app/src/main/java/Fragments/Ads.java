package Fragments;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.illumicon.novena.R;

/**
 * Created by Edgar on 20/11/2016.
 */

public class Ads extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ads,
                container, false);

        Resources res = getResources();
        String TOAST_TEXT = res.getString(R.string.banner);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        //Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();

        return view;
    }
}
