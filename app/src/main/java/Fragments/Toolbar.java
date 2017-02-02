package Fragments;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.illumicon.novena.Novena;
import com.illumicon.novena.Principal;
import com.illumicon.novena.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import Contracts.IActivity;
import Contracts.IModel;

import static Contracts.IActivity.modelo;
import static android.R.attr.bitmap;

/**
 * Created by Edgar on 20/11/2016.
 */

public class Toolbar extends Fragment {

    View view;
    Activity currentActivity;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.toolbar, container, false);

        ImageButton forwardButton =(ImageButton) view.findViewById(R.id.forwardBtn);
        ImageButton backButton = (ImageButton) view.findViewById(R.id.backBtn);
        //ImageButton homeButton = (ImageButton) view.findViewById(R.id.homeBtn);
        //ImageButton facebookButton = (ImageButton) view.findViewById(R.id.facebookBtn);
        currentActivity = getActivity();
        validateToolbar();

        forwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try
                {
                    final String clase = currentActivity.getLocalClassName();
                    String claseNovena = Novena.class.getSimpleName();

                    if (clase.equals(claseNovena))
                    {
                        Novena miNovena = (Novena)currentActivity;
                        miNovena.setFragment(miNovena.model.getNextItem());
                    }
                    validateToolbar();

                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try
                {
                    final String clase = currentActivity.getLocalClassName();
                    String claseNovena = Novena.class.getSimpleName();

                    if (clase.equals(claseNovena))
                    {
                        Novena miNovena = (Novena)currentActivity;
                        miNovena.setFragment(miNovena.model.getPreviousItem());
                    }
                    validateToolbar();

                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });

        /*
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Principal.class);
                intent.putExtra("activity_name","Principal");
                startActivity(intent);
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                WebView con = (WebView) v.getRootView().findViewById(R.id.diaText);
                FrameLayout novenaView = (FrameLayout) v.getRootView().findViewById(R.id.novenaLayout);

                //Bitmap screenShot = getScreenShot(v);
                //File file = store(screenShot, "ScreenShot");
                //shareImage(file);

                int wid = novenaView.getMeasuredWidth();
                int hei =  novenaView.getMeasuredHeight();

                novenaView.layout(0, 0, wid, hei);

                novenaView.setDrawingCacheEnabled(true);
                novenaView.buildDrawingCache(true);

                Bitmap b = Bitmap.createBitmap(novenaView.getDrawingCache());
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.PNG, 100, bytes);

                //ImageView imagen = (ImageView) v.getRootView().findViewById(R.id.vista);
                //imagen.setImageBitmap(b);

                //con.setDrawingCacheEnabled(false);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/png");
                intent.putExtra(Intent.EXTRA_TEXT,
                        "Check out App at: https://play.google.com/store/apps/details?id=com.soundcloud.android");
                intent.putExtra(Intent.EXTRA_STREAM, b);
                startActivity(intent);

                /*
                novenaView.setDrawingCacheEnabled(true);
                // this is the important code :)
                // Without it the view will have a dimension of 0,0 and the bitmap will be null
                int wid = novenaView.getMeasuredWidth();
                int hei =  novenaView.getMeasuredHeight();

                novenaView.layout(0, 0, wid, hei);

                novenaView.buildDrawingCache(true);
                Bitmap b = Bitmap.createBitmap(novenaView.getDrawingCache());

                Intent intent = new Intent(Intent.ACTION_SEND);
                */

                /*
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,
                        "Check out App at: https://play.google.com/store/apps/details?id=com.soundcloud.android");
                intent.setType("image/png");
                intent.putExtra(Intent.EXTRA_STREAM, b);
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
                */

                /*
                final Intent emailIntent1 = new Intent(     android.content.Intent.ACTION_SEND);
                emailIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent1.putExtra(Intent.EXTRA_STREAM, b);
                emailIntent1.putExtra(Intent.EXTRA_TEXT,
                        "Check out App at: https://play.google.com/store/apps/details?id=com.soundcloud.android");
                emailIntent1.setType("image/png");
                startActivity(Intent.createChooser(emailIntent1, "Compartir"));


            }
        });

        */

        return view;
    }

    public void validateToolbar()
    {
        ImageButton backButton = (ImageButton) view.findViewById(R.id.backBtn);
        ImageButton forwardButton =(ImageButton) view.findViewById(R.id.forwardBtn);

        String fragmentName = ((Novena)currentActivity).model.getCurrentFragmentName();
        forwardButton.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);

        if (fragmentName.equals(OracionTodosLosDias.class.getSimpleName())) {
            backButton.setVisibility(View.INVISIBLE);
        }

        if (fragmentName.equals(ConsideracionesDiarias.class.getSimpleName())) {
            forwardButton.setVisibility(View.INVISIBLE);
        }

        if (fragmentName.equals(DiasNovena.class.getSimpleName())) {
            forwardButton.setVisibility(View.VISIBLE);
        }

        if (fragmentName.equals(ListaCanciones.class.getSimpleName())) {
            forwardButton.setVisibility(View.INVISIBLE);
        }
    }

    public Bitmap getScreenShot(View view) {
        View screenView = view.getRootView().findViewById(R.id.novenaLayout);
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public File store(Bitmap bm, String fileName){
        final String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
        File dir = new File(dirPath);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(dirPath, fileName);
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 85, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    private void shareImage(File file){
        Uri uri = Uri.fromFile(file);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        try {
            startActivity(Intent.createChooser(intent, "Share Screenshot"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), "No App Available", Toast.LENGTH_SHORT).show();
        }
    }
}
