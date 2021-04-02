# JOpenCage 
[![Download](https://img.shields.io/bintray/v/moberwasserlechner/maven/jopencage.svg)](https://bintray.com/moberwasserlechner/maven/jopencage/_latestVersion) ![Tests](https://github.com/moberwasserlechner/jopencage/workflows/UnitTests/badge.svg) [![Twitter Follow](https://img.shields.io/twitter/follow/michaelowl_web.svg?style=social&label=Follow&style=flat-square)](https://twitter.com/michaelowl_web) [![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg?style=flat-square)](https://www.paypal.me/moberwasserlechner)

This api provides a java client to the OpenCage geocoding service. https://opencagedata.com/api

## Usage

[![Download](https://img.shields.io/bintray/v/moberwasserlechner/maven/jopencage.svg)](https://bintray.com/moberwasserlechner/maven/jopencage/_latestVersion)

### Maven

Repository

```xml
<repositories>
  <!-- ... other repository elements ... -->
  <repository>
    <snapshots>
      <enabled>false</enabled>
    </snapshots>
    <id>central</id>
    <name>bintray</name>
    <url>https://jcenter.bintray.com</url>
  </repository>
</repositories>
<dependencies>
  <!-- ... other dependency elements ... -->
  <dependency>
    <groupId>com.byteowls</groupId>
    <artifactId>jopencage</artifactId>
    <version>replace.with.version</version>
  </dependency>
</dependencies>
```

### Gradle

```gradle
repositories {
  jcenter()
}

dependencies {
  implementation "com.byteowls:jopencage:REPLACE.WITH.VERSION"
}
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
* slf4j

## Testing

For running the tests you have to use your *OWN* OpenCage API Key. Get a free trail key at https://opencagedata.com/dashboard#api-keys

```
./gradlew -DOPENCAGE_API_KEY=ABCDEFG_YOUR_KEY test
```

## Gradle

```
./gradlew wrapper --gradle-version 6.8.3
```

## Contribute

See [Contribution Guidelines](https://github.com/moberwasserlechner/jopencage/blob/master/.github/CONTRIBUTING.md).

## Changelog
See [CHANGELOG](https://github.com/moberwasserlechner/jopencage/blob/master/CHANGELOG.md).

## License

Apache 2.0. Please see [LICENSE](https://github.com/moberwasserlechner/jopencage/blob/master/LICENSE).

## BYTEOWLS Software & Consulting

This plugin is powered by [BYTEOWLS Software & Consulting](https://byteowls.com)
