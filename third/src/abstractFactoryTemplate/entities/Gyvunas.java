package abstractFactoryTemplate.entities;

import abstractFactoryTemplate.Tipas;

public abstract class Gyvunas {
    Tipas tipas;
    public Gyvunas(Tipas tipas) {
        this.tipas = tipas;
    }
}
