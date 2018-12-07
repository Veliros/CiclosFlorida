package com.example.marta.ciclosflorida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class subActivity extends AppCompatActivity {
    private ArrayList<CicloFlorida> listaGrados;
    private View view = null;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        listaGrados = new ArrayList<CicloFlorida>();
        StringBuilder sb = new StringBuilder();

        CicloFlorida oCicloF = new CicloFlorida("", "","","");
        oCicloF.creaDades();

        String sTitulo = oCicloF.getTitol();
        String sTipo = oCicloF.getTipus();
        String sDescripcion = oCicloF.getDescripcio();
        String sFamiliaProf = oCicloF.getFamiliaProfessional();

        Intent intento = new Intent(view.getContext(), MainActivity.class);
        Bundle b = getIntent().getExtras();
        sb.append(b.get("titulo"));
        sb.append(b.get("tipo"));
        sb.append(b.get("descripcion"));
        sb.append(b.get("familia_profesional"));

        setResult(RESULT_OK, intento);
        finish();
    }


}
