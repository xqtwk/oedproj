package abstractFactoryTemplate;

import abstractFactoryTemplate.entities.Suo;
import abstractFactoryTemplate.entities.Vilkas;
import abstractFactoryTemplate.factories.AbstractFactory;
import abstractFactoryTemplate.factories.LaukiniuGamykla;
import abstractFactoryTemplate.factories.PrijaukintuGamykla;

public class Client {
    AbstractFactory laukiniai = new LaukiniuGamykla();
    AbstractFactory prijaukinti = new PrijaukintuGamykla();
    Vilkas vilkas = laukiniai.createVilkas();
    Suo suo = prijaukinti.createSuo();

}
