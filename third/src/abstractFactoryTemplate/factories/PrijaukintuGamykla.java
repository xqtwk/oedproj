package abstractFactoryTemplate.factories;

import abstractFactoryTemplate.Tipas;
import abstractFactoryTemplate.entities.Suo;
import abstractFactoryTemplate.entities.Vilkas;

public class PrijaukintuGamykla implements AbstractFactory {
    Tipas tipas = Tipas.Prijaukintas;
    @Override
    public Suo createSuo() {
        return new Suo(tipas);
    }

    @Override
    public Vilkas createVilkas() {
        return new Vilkas(tipas);
    }
}
