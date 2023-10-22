package factoryTemplate.factories;

import factoryTemplate.entities.Bird;
import factoryTemplate.entities.Eagle;

public class EagleFactory implements BirdFactory {
    @Override
    public Bird createBird() {
        return new Eagle();
    }
}
