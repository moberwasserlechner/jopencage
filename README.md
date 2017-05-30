# JOpenCage [![Download](https://img.shields.io/bintray/v/moberwasserlechner/maven/jopencage.svg)](https://bintray.com/moberwasserlechner/maven/jopencage/_latestVersion) [![PayPal](https://img.shields.io/badge/%24-paypal-f39c12.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=N8VS2P9233NJQ) [![License](https://img.shields.io/badge/license-Apache_2.0-orange.svg)](https://github.com/moberwasserlechner/jopencage/blob/develop/LICENSE) [![Travis](https://img.shields.io/travis/moberwasserlechner/jopencage/develop.svg?maxAge=2592000)](https://travis-ci.org/moberwasserlechner/jopencage)

This api provides a java client to the OpenCage geocoding service. http://geocoder.opencagedata.com/api.html

# Usage

### Download

[![Download](https://img.shields.io/bintray/v/moberwasserlechner/maven/jopencage.svg)](https://bintray.com/moberwasserlechner/maven/jopencage/_latestVersion)

### Maven

Repository

    <repositories>
      <!-- ... other repository elements ... -->
      <repository>
        <snapshots>
          <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray</name>
        <url>http://jcenter.bintray.com</url>
      </repository>
    </repositories>
    
Dependency

    <dependencies>
      <!-- ... other dependency elements ... -->
      <dependency>
        <groupId>com.byteowls</groupId>
        <artifactId>jopencage</artifactId>
        <version>replace.with.version</version>
      </dependency>
    </dependencies>


### Gradle

Repository


    repositories {
      jcenter()
    }
    // or 
    repositories {
      maven {
        url  "http://jcenter.bintray.com" 
      }
    }
     
Dependency

    dependencies {
      compile ("com.byteowls:jopencage:replace.with.version")
    }

### Example

Forward


    // In real live application the JOpenCageGeocoder should be a Singleton
    JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(YOUR_API_KEY);

    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
    request.setMinConfidence(1);
    request.setNoAnnotations(false);
    request.setNoDedupe(true);
    JOpenCageResponse response = jOpenCageGeocoder.forward(request);


Reverse

    // In real live application the JOpenCageGeocoder should be a Singleton
    JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(YOUR_API_KEY);

    JOpenCageReverseRequest request = new JOpenCageReverseRequest(-22.6792, 14.5272);
    request.setNoAnnotations(true);
    
    JOpenCageResponse response = jOpenCageGeocoder.reverse(request);

# Libraries

* JDK 7+
* Apache Http Client
* FasterXml Jackson
* slf4j

# Missing something?

## Contribute

### Setup Eclipse

1. Fork repo
2. Open command line
3. Clone your fork `git@github.com:USERNAME/jopencage.git`
4. `cd jopencage`
5. Build eclipse meta data `./gradlew cleanEclipse eclipse`
6. Open Eclipse
7. File -> Import... -> General -> Existing Projects into Workspace
8. Browse to your git repository
9. Check the option "Search for nested projects"
10. Press finish

This should take not more than 1-2 minutes. You does not need to use any gradle eclipse plugins. 

### Fix a bug or create a new feature

Please do not mix more than one issue in a feature branch. Each feature/bugfix should have its own branch and its own Pull Request (PR).

1. Create a issue and describe what you want to do at [Issue Tracker](https://github.com/moberwasserlechner/jopencage/issues)
2. Create your feature branch (`git checkout -b feature/my-feature` or `git checkout -b bugfix/my-bugfix`)
3. Test your changes to the best of your ability.
4. Add a demo view to the demo application 
5. Commit your changes (`git commit -m 'Describe feature or bug'`)
6. Push to the branch (`git push origin feature/my-feature`)
7. Create a Github Pull Request

# Testing

For running the tests you have to use your *own* OpenCage API Key.

* OPENCAGE\_API\_KEY ... Provide your own opencage api key using env variables. e.g. -DOPENCAGE\_API\_KEY=YourKey

## License

Apache 2.0. Please see [LICENSE](https://github.com/moberwasserlechner/jopencage/blob/develop/LICENSE).