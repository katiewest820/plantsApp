package plants.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import plants.Growth;

public class GrowthExample implements Example<Growth> {

    @Override
    public Growth getProbe() {
        return null;
    }

    @Override
    public ExampleMatcher getMatcher() {
        return null;
    }
}
