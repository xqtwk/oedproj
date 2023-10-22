package abstractFactoryTemplate.factories;

import abstractFactoryTemplate.entities.Suo;
import abstractFactoryTemplate.entities.Vilkas;

public interface AbstractFactory {
    Suo createSuo();
    Vilkas createVilkas();
}
