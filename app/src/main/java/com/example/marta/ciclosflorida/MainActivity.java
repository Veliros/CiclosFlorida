package com.example.marta.ciclosflorida;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.View;


import java.util.ArrayList;

/**
 * @author marta, alex
 */
public class MainActivity extends Activity implements Titulaciones.comunicaTitu {

    private ArrayList<CicloFlorida> aListado;
    private static final int ID_SUBACTIVITY = 1;

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

    }

    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    //Gestionem la informació que ens proporciona el subactivity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_SUBACTIVITY) {
            if (resultCode == RESULT_OK) {

            }

        }
    }

    /**
     * Devuelve el listado de los grados de empresa.
     * @param listado
     */
    @Override
    public void listado(ArrayList<CicloFlorida> listado) {
        String titulo, tipo, descripcion, familiaProf;

        titulo = ciclo.getTitol();
        tipo = ciclo.getTipus();
        descripcion = ciclo.getDescripcio();
        familiaProf = ciclo.getFamiliaProfessional();

        // Guardamos los datos en un Bundle
        Bundle datos = new Bundle();
        datos.putString("titulo", titulo);
        datos.putString("tipo", tipo);
        datos.putString("descripcion", descripcion);
        datos.putString("familiaProf", familiaProf);

        // Lanzamos la subactivity.
        Intent i = new Intent(getApplicationContext(),subActivity.class);
        i.putExtras(datos);
        startActivityForResult(i,ID_SUBACTIVITY);

    }


}
