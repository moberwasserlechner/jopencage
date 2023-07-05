# JOpenCage 
[![Maven Central](https://img.shields.io/maven-central/v/com.byteowls/jopencage.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.byteowls%22%20AND%20a:%22jopencage%22)
![Tests](https://github.com/moberwasserlechner/jopencage/workflows/UnitTests/badge.svg)

This api provides a java client to the OpenCage geocoding service. https://opencagedata.com/api

## Usage

Maven

```xml
  <dependency>
    <groupId>com.byteowls</groupId>
    <artifactId>jopencage</artifactId>
    <version>replace.with.version</version>
  </dependency>
```

Gradle

```gradle
    implementation "com.byteowls:jopencage:REPLACE.WITH.VERSION"
```

### Example

Forward

```java
// In real live application the JOpenCageGeocoder should be a Singleton
JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(YOUR_API_KEY);

JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
request.setMinConfidence(1);
request.setNoAnnotations(false);
request.setNoDedupe(true);
JOpenCageResponse response = jOpenCageGeocoder.forward(request);
```

Reverse

```java
// In real live application the JOpenCageGeocoder should be a Singleton
JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(YOUR_API_KEY);

JOpenCageReverseRequest request = new JOpenCageReverseRequest(-22.6792, 14.5272);
request.setNoAnnotations(true);

JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
```

## Libraries

* JDK 8+
* Apache Http Client
* FasterXml Jackson
* Slf4j

## Testing

For running the tests you have to use your *OWN* OpenCage Geocoding API Key. Get a free trial key at https://opencagedata.com

```
./gradlew -DOPENCAGE_API_KEY=<your apikey> test
```

## Gradle

```
./gradlew wrapper --gradle-version 6.8.3
```

## Contribute

See [Contribution Guidelines](jopencage/blob/master/.github/CONTRIBUTING.md).

## Changelog
See [CHANGELOG](jopencage/blob/master/CHANGELOG.md).

## License

Apache 2.0. Please see [LICENSE](jopencage/blob/master/LICENSE).

## History
Until July 2023 this library was maintained by [Michael Oberwasserlechner](https://github.com/moberwasserlechner). At his request due to lack of time to work on it the libary was then taken over by OpenCage GmbH. Thanks, Michael!
