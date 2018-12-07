package com.example.marta.ciclosflorida;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

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
    public void creaDades(){
        CicloFlorida c;
        ArrayList<CicloFlorida> llistat_titulacions = new ArrayList<CicloFlorida>();

        c = new CicloFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicloFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicloFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicloFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        c = new CicloFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        c = new CicloFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        c = new CicloFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        c = new CicloFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        c = new CicloFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
    }
}
