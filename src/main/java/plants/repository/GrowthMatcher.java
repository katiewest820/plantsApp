package plants.repository;

import org.springframework.data.domain.ExampleMatcher;

import java.util.Set;

public class GrowthMatcher implements ExampleMatcher {

    @Override
    public ExampleMatcher withIgnorePaths(String... ignoredPaths) {
        return null;
    }

    @Override
    public ExampleMatcher withStringMatcher(StringMatcher defaultStringMatcher) {
        return null;
    }

    @Override
    public ExampleMatcher withIgnoreCase(boolean defaultIgnoreCase) {
        return null;
    }

    @Override
    public ExampleMatcher withMatcher(String propertyPath, GenericPropertyMatcher genericPropertyMatcher) {
        return null;
    }

    @Override
    public ExampleMatcher withTransformer(String propertyPath, PropertyValueTransformer propertyValueTransformer) {
        return null;
    }

    @Override
    public ExampleMatcher withIgnoreCase(String... propertyPaths) {
        return null;
    }

    @Override
    public ExampleMatcher withNullHandler(NullHandler nullHandler) {
        return null;
    }

    @Override
    public NullHandler getNullHandler() {
        return null;
    }

    @Override
    public StringMatcher getDefaultStringMatcher() {
        return null;
    }

    @Override
    public boolean isIgnoreCaseEnabled() {
        return false;
    }

    @Override
    public Set<String> getIgnoredPaths() {
        return null;
    }

    @Override
    public PropertySpecifiers getPropertySpecifiers() {
        return null;
    }

    @Override
    public MatchMode getMatchMode() {
        return null;
    }
}
