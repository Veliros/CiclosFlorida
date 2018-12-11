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
 *
 * @author marta, alex
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
        StringBuilder sb = new StringBuilder();
        // Lo mismo que en TipoCiclo.
        switch (v.getId()) {
            case R.id.btnEmpresa:
                for(CicloFlorida c : listado){
                    if(c.getFamiliaProfessional().compareTo("EMPRESA") == 0) sb.append(c.toString() + "\n");
                }
                break;
            case R.id.btnSport:
                for(CicloFlorida c : listado){
                    if(c.getFamiliaProfessional().compareTo("ESPORT") == 0) sb.append(c.toString() + "\n");
                }
                break;
            case R.id.btnInfo:
                for(CicloFlorida c : listado){
                    if(c.getFamiliaProfessional().compareTo("INFROMÀTICA") == 0) sb.append(c.toString() + "\n");
                }
                break;
        }

        mListener.listado(sb.toString());

    }

    /**
     * Método para crear los datos.
     */
    public void creaDades(){
        ciclo = new CicloFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        listado.add(ciclo);
        ciclo = new CicloFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        listado.add(ciclo);
        ciclo = new CicloFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        listado.add(ciclo);
        ciclo = new CicloFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        ciclo = new CicloFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        ciclo = new CicloFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        ciclo = new CicloFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        ciclo = new CicloFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        ciclo = new CicloFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
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
        void listado(String listado);

    }
}
