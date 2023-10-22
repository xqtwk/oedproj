package factoryTemplate.factories;

import factoryTemplate.entities.Bird;
import factoryTemplate.entities.Owl;

public class OwlFactory implements BirdFactory {
    @Override
    public Bird createBird() {
        return new Owl();
    }
}
