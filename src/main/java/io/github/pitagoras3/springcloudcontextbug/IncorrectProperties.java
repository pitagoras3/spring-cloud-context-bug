package io.github.pitagoras3.springcloudcontextbug;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "incorrect")
public class IncorrectProperties {

    // Starting value of this property is defined in src/test/resources/bootstrap.yaml
    // and is bind to a IncorrectProperties bean during bootstrap application context phase.
    // It should be overridden with the value returned from CustomPropertySourceLocator.locate()
    // But it stopped working after a change in spring-cloud-context 3.1.5
    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
