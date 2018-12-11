package com.example.marta.ciclosflorida;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;


/**
 * Main activity
 *
 * @author marta, alex
 */
public class MainActivity extends Activity implements Titulaciones.comunicaTitu {

    private FragmentManager fm;
    private FragmentTransaction ft;

    private Titulaciones fragmentTit;
    private TipoCiclo fragmentCiclo;
    private Listado fragmentListado;
    private CicloFlorida ciclo;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos los objetos de java a los fragments que hemos diseñado en el xml.
        fm = getFragmentManager();

        fragmentTit = (Titulaciones) fm.findFragmentById(R.id.fragment_titulaciones);

        fragmentCiclo = new TipoCiclo();
        fragmentListado = new Listado();

        ft = fm.beginTransaction();
        ft.add(R.id.fragment_listado, fragmentListado);
        ft.add(R.id.fragment_tCiclos, fragmentCiclo);
        ft.commit();

        fragmentTit.creaDades();
    }

    /**
     *
     * @param listado
     */
    @Override
    public void listado(String listado) {
        ft = fm.beginTransaction();

        if (fm.findFragmentById(R.id.fragment_listado)==null) {
            ft.add(R.id.fragment_listado, fragmentListado);
        }else {
            ft.replace(R.id.fragment_listado, fragmentListado);
        }

        ft.addToBackStack(null);
        ft.commit();
    }
}
