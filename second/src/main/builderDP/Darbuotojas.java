package main;

import java.util.ArrayList;
import java.util.List;

public class Darbuotojas {
    private String vardas;
    private String pavarde;
    private String pareigos;
    private String projektas;
    private String padalinys;
    private int valandinisPriedas;

    public Darbuotojas(String vardas, String pavarde, String pareigos, String projektas, String padalinys, int valandinisPriedas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pareigos = pareigos;
        this.projektas = projektas;
        this.padalinys = padalinys;
        this.valandinisPriedas = valandinisPriedas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getPareigos() {
        return pareigos;
    }

    public void setPareigos(String pareigos) {
        this.pareigos = pareigos;
    }

    public String getProjektas() {
        return projektas;
    }

    public void setProjektas(String projektas) {
        this.projektas = projektas;
    }

    public String getPadalinys() {
        return padalinys;
    }

    public void setPadalinys(String padalinys) {
        this.padalinys = padalinys;
    }

    public int getValandinisPriedas() {
        return valandinisPriedas;
    }

    public void setValandinisPriedas(int valandinisPriedas) {
        this.valandinisPriedas = valandinisPriedas;
    }

    @Override
    public String toString() {
        return "Darbuotojas{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", pareigos='" + pareigos + '\'' +
                ", projektas='" + projektas + '\'' +
                ", padalinys='" + padalinys + '\'' +
                ", valandinisPriedas=" + valandinisPriedas +
                '}';
    }

}
