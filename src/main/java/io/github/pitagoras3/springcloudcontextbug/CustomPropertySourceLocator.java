package io.github.pitagoras3.springcloudcontextbug;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Map;

public class CustomPropertySourceLocator implements PropertySourceLocator {

    public static final String INCORRECT_PROPERTY_FROM_CUSTOM_PROPERTY_SOURCE_LOCATOR = "incorrect-property-from-custom-property-source-locator";
    public static final Map<String, Object> propertiesFromCloud = Map.of(
            // This value should be applied to IncorrectProperties bean that was created in bootstrap context.
            "incorrect.property", INCORRECT_PROPERTY_FROM_CUSTOM_PROPERTY_SOURCE_LOCATOR);
    private final IncorrectProperties incorrectProperties;

    public CustomPropertySourceLocator(IncorrectProperties incorrectProperties) {
        this.incorrectProperties = incorrectProperties;
    }

    @Override
    public PropertySource<?> locate(Environment environment) {
        System.out.println("Usage of applicationProperties.getName(): " + incorrectProperties.getProperty());
        return new MapPropertySource("customProperty", propertiesFromCloud);
    }

}
