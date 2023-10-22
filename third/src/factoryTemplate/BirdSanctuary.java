package factoryTemplate;

import factoryTemplate.entities.Bird;
import factoryTemplate.factories.BirdFactory;
import factoryTemplate.factories.EagleFactory;
import factoryTemplate.factories.OwlFactory;
import factoryTemplate.factories.SparrowFactory;

public class BirdSanctuary {
    public static void main(String[] args) {
        BirdFactory owlFactory = new OwlFactory();
        BirdFactory eagleFactory = new EagleFactory();
        BirdFactory sparrowFactory = new SparrowFactory();

        Bird owl = owlFactory.createBird();
        Bird eagle = eagleFactory.createBird();
        Bird sparrow = sparrowFactory.createBird();

        owl.fly();
        eagle.fly();
        sparrow.fly();
    }
}
