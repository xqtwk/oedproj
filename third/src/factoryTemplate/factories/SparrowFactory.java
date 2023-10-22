package factoryTemplate.factories;

import factoryTemplate.entities.Bird;
import factoryTemplate.entities.Sparrow;

public class SparrowFactory implements BirdFactory {
    @Override
    public Bird createBird() {
        return new Sparrow();
    }
}
