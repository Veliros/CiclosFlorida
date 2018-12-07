package com.example.marta.ciclosflorida;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Titulaciones.comunicaTitu} interface
 * to handle interaction events.
 * Use the {@link Titulaciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Titulaciones extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "titulo";
    private static final String ARG_PARAM2 = "tipo";
    private static final String ARG_PARAM3 = "descripcion";
    private static final String ARG_PARAM4 = "familia_profesional";

    // Parámetros:
    private String titulo, familiaProf, tipo, descripcion;
    private CicloFlorida ciclo;

    // Botones:
    private Button btnSport, btnEmpresa, btnInformatica;
    // TextView:
    private TextView tvListado;
    // ArrayList:
    private ArrayList<CicloFlorida> listado;

    private comunicaTitu mListener;

    public Titulaciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tit     Título
     * @param tipo    Tipo
     * @param desc    Descripción
     * @param famProf Familia profesional
     * @return A new instance of fragment Titulaciones.
     */
    public static Titulaciones newInstance(String tit, String tipo, String desc,
                                           String famProf) {
        Titulaciones fragment = new Titulaciones();
        Bundle args = new Bundle();
        args.putString("titulo", tit);
        args.putString("tipo", tipo);
        args.putString("descripcion", desc);
        args.putString("familia_profesional", famProf);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titulo = getArguments().getString(ARG_PARAM1);
            tipo = getArguments().getString(ARG_PARAM2);
            descripcion = getArguments().getString(ARG_PARAM3);
            familiaProf = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_titulaciones, container, false);

        btnEmpresa = (Button) v.findViewById(R.id.btnEmpresa);
        btnInformatica = (Button) v.findViewById(R.id.btnInfo);
        btnSport = (Button) v.findViewById(R.id.btnSport);

        tvListado = (TextView) v.findViewById(R.id.tvListado);

        // Cogemos el listado de objetos:
        //listado = ciclo.

        // Asignando Listeners a cada botón:
        btnSport.setOnClickListener(this);
        btnInformatica.setOnClickListener(this);
        btnEmpresa.setOnClickListener(this);

        return v;
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof comunicaTitu) {
            mListener = (comunicaTitu) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * Cambiado el mListener
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Acciones de distintos botones.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEmpresa:
                mListener.listado(listado);
                break;
            case R.id.btnSport:
                mListener.listado(listado);
                break;
            case R.id.btnInfo:
                mListener.listado(listado);
                break;
        }

    }

    /**
     * Método de comprobación de titulaciones.
     */
    protected void comprobarTitulacion() {
        String familiaProfesional = ciclo.getFamiliaProfessional();

        for (CicloFlorida c : listado) {
            switch (familiaProfesional) {
                case "ESPORT":
                    tvListado.setText("\tDeportes:\n" + c.toString());
                    break;
                case "EMPRESA":
                    tvListado.setText("\tEmpresa:\n" + c.toString());
                    break;
                case "INFORMÀTICA":
                    tvListado.setText("\tInformática:\n" + c.toString());
                    break;
            }
        }

    }


    /**
     * Interfaz para comunicar datos entre fragments, premitiendo interacción.
     */
    public interface comunicaTitu {
        /**
         * Pasa el listado de grado superior/grado medio de empresa.
         *
         * @param listado
         */
        void listado(ArrayList<CicloFlorida> listado);

    }
}
