package io.github.pitagoras3.springcloudcontextbug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static io.github.pitagoras3.springcloudcontextbug.CustomPropertySourceLocator.INCORRECT_PROPERTY_FROM_CUSTOM_PROPERTY_SOURCE_LOCATOR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest
class SpringCloudContextBugApplicationTests {

    @Value("${incorrect.property}")
    private String incorrectPropertyFromValue;

    @Autowired
    private IncorrectProperties incorrectProperties;

    @Test
    void shouldNotFailToUpdateApplicationPropertiesBean() {
        // This assertion don't fail when using spring-cloud-context in version >= 3.1.5
        // @Value("${incorrect.property}") is providing the newest value of 'incorrect.property'
        assertThat(incorrectPropertyFromValue, equalTo(INCORRECT_PROPERTY_FROM_CUSTOM_PROPERTY_SOURCE_LOCATOR));

        // This assertion fails when using spring-cloud-context in version >= 3.1.5
        assertThat(incorrectProperties.getProperty(), equalTo(INCORRECT_PROPERTY_FROM_CUSTOM_PROPERTY_SOURCE_LOCATOR));
    }
}
