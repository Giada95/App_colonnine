package com.example.giada.app_colonnine;


/**
 * Created by Giada on 22/03/2018.
 */

 enum TipoSupporto {
    chademo50, type2, type22kW, scame, combo
}


public class Colonnina{
    private String Indirizzogenerico;
    private String gestore;


    private TipoSupporto supporto[];

    public Colonnina(){

    }



    public String getIndirizzogenerico() {
        return Indirizzogenerico;
    }

    public void setIndirizzogenerico(String Indirizzogenerico) {this.Indirizzogenerico = Indirizzogenerico;}

    public String getGestore() {return gestore;}

    public void setGestore(String gestore) {
        this.gestore = gestore;
    }

    public TipoSupporto[] getSupporto() {return supporto;}


    public void setSupporto(TipoSupporto[] supporto) {
        this.supporto = supporto;}



}
