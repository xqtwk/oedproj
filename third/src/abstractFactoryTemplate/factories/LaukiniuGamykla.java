package abstractFactoryTemplate.factories;

import abstractFactoryTemplate.Tipas;
import abstractFactoryTemplate.entities.Suo;
import abstractFactoryTemplate.entities.Vilkas;

public class LaukiniuGamykla implements AbstractFactory {
    Tipas tipas = Tipas.Laukinis;
    @Override
    public Suo createSuo() {
        return new Suo(tipas);
    }

    @Override
    public Vilkas createVilkas() {
        return new Vilkas(tipas);
    }
}
