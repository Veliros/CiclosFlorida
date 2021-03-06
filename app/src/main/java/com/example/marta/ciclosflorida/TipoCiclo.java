package com.example.marta.ciclosflorida;

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
 * Use the {@link TipoCiclo#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author marta, alex
 */
public class TipoCiclo extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Botones y textview:
    private Button gMedio, gSuperior;
    private TextView tvListado;

    // ArrayLists:
    private ArrayList<CicloFlorida> listaGrados;

    public TipoCiclo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipoCiclo.
     */
    // TODO: Rename and change types and number of parameters
    public static TipoCiclo newInstance(String param1, String param2) {
        TipoCiclo fragment = new TipoCiclo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tipo_ciclo, container, false);

        gMedio = (Button) v.findViewById(R.id.btnMedio);
        gSuperior = (Button) v.findViewById(R.id.btnSup);

        tvListado = (TextView) v.findViewById(R.id.tvListado);

        return v;
    }

    /**
     *
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Detectar qué botón es:
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        StringBuilder sb = new StringBuilder();

            switch (v.getId()) {
                case R.id.btnMedio:
                    // Recorre el ArrayList:
                    for (CicloFlorida c : listaGrados) {
                        // Coge el tipo que toca:
                        if (c.getTipus().compareTo("MITJA") == 0) sb.append(c.toString() + "\n");
                    }
                    break;
                case R.id.btnSup:
                    for (CicloFlorida c : listaGrados) {
                        if (c.getTipus().compareTo("SUPERIOR") == 0) sb.append(c.toString() + "\n");
                    }
                    break;
                default: // En caso de que no sea ninguno de los dos va con todos.
                    for (CicloFlorida c : listaGrados) {
                        sb.append(c.toString() + "\n");
                    }
                    break;
            }

        tvListado.setText(sb.toString());
    }
}
