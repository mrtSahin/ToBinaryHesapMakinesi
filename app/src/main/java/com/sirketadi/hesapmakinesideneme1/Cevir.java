package com.sirketadi.hesapmakinesideneme1;

import android.widget.EditText;



public class Cevir {
    private int gelenSayi;
    private String sonuc;
    public Cevir() {
    }

    public Cevir(int gelenSayi, String sonuc) {
        this.gelenSayi = gelenSayi;
        this.sonuc = sonuc;
    }

    public int getGelenSayi() {
        return gelenSayi;
    }

    public void setGelenSayi(int gelenSayi) {
        this.gelenSayi = gelenSayi;
    }

    public String getSonuc() {
        return sonuc;
    }

    public String hesapla(int gelenSayi){
        this.gelenSayi=gelenSayi;
        this.sonuc=Integer.toBinaryString(gelenSayi);
        return this.sonuc;
    }
}
