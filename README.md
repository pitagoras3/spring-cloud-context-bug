# spring-cloud-context-bug

In this repository I've reproduced a bug introduced in spring-cloud-context 3.1.5

### Bug description

When a bean using ConfigurationProperties is created during bootstrap phase, values of the fields in this bean are not
updated after fetching additional properties using spring-cloud.

### How to reproduce this bug?

In this repository I've created `IncorrectProperties` bean, which at bootstrap phase takes property values
from `bootstrap.yaml` file. Those properties should be overridden with a new values returned
from `CustomPropertySourceLocator`.

I've created a test `SpringCloudContextBugApplicationTests.shouldNotFailToUpdateApplicationPropertiesBean` which
verifies correctness of this behaviour. This test fails when project is using spring-cloud-context in version >= 3.1.5.
You can change version of spring-cloud-context in `build.gradle` file.
