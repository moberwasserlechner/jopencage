# JOpenCage 
[![Download](https://img.shields.io/bintray/v/moberwasserlechner/maven/jopencage.svg)](https://bintray.com/moberwasserlechner/maven/jopencage/_latestVersion) [![Travis](https://img.shields.io/travis/moberwasserlechner/jopencage/master.svg?maxAge=2592000)](https://travis-ci.org/moberwasserlechner/jopencage) [![Twitter Follow](https://img.shields.io/twitter/follow/michaelowl_web.svg?style=social&label=Follow&style=flat-square)](https://twitter.com/michaelowl_web) [![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg?style=flat-square)](https://www.paypal.me/moberwasserlechner)

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
  compile ("com.byteowls:jopencage:replace.with.version")
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

## Contribute

### Fix a bug or create a new feature

Please do not mix more than one issue in a feature branch. Each feature/bugfix should have its own branch and its own Pull Request (PR).

1. Create a issue and describe what you want to do at [Issue Tracker](https://github.com/moberwasserlechner/jopencage/issues)
2. Create your feature branch (`git checkout -b feature/my-feature` or `git checkout -b bugfix/my-bugfix`)
3. Test your changes to the best of your ability.
4. Add a demo view to the demo application 
5. Commit your changes (`git commit -m 'Describe feature or bug'`)
6. Push to the branch (`git push origin feature/my-feature`)
7. Create a Github Pull Request

### Code Style

This repo includes a .editorconfig file, which your IDE should pickup automatically.

If not: Please use the sun coding convention. Please do not use tabs at all!

Try to change only parts your feature or bugfix requires.

## Testing

For running the tests you have to use your *own* OpenCage API Key.

* OPENCAGE\_API\_KEY ... Provide your own opencage api key using env variables. e.g. -DOPENCAGE\_API\_KEY=YourKey

## Changelog
See [CHANGELOG](https://github.com/moberwasserlechner/jopencage/blob/master/CHANGELOG.md).

## License

Apache 2.0. Please see [LICENSE](https://github.com/moberwasserlechner/jopencage/blob/master/LICENSE).
