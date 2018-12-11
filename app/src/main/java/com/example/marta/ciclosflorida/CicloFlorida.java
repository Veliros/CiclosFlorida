package com.example.marta.ciclosflorida;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Parcelable.
 *
 * @author marta, alex
 */
public class CicloFlorida implements Parcelable {
    private String familiaProfessional;
    private String tipus;
    private String titol;
    private String Descripcio;

    public CicloFlorida(String familiaProfessional, String tipus, String titol, String descripcio) {

        this.familiaProfessional = familiaProfessional;
        this.tipus = tipus;
        this.titol = titol;
        Descripcio = descripcio;
    }

    public String getFamiliaProfessional() {
        return familiaProfessional;
    }

    public void setFamiliaProfessional(String familiaProfessional) {
        this.familiaProfessional = familiaProfessional;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }


    protected CicloFlorida(Parcel in) {
        familiaProfessional = in.readString();
        tipus = in.readString();
        titol = in.readString();
        Descripcio = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(familiaProfessional);
        dest.writeString(tipus);
        dest.writeString(titol);
        dest.writeString(Descripcio);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CicloFlorida> CREATOR = new Parcelable.Creator<CicloFlorida>() {
        @Override
        public CicloFlorida createFromParcel(Parcel in) {
            return new CicloFlorida(in);
        }

        @Override
        public CicloFlorida[] newArray(int size) {
            return new CicloFlorida[size];
        }
    };

}
