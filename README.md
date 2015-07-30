# Introduction

This api provides a java client to the OpenCage geocoding service. http://geocoder.opencagedata.com/api.html

# Usage

### Download

[ ![Download](https://api.bintray.com/packages/moberwasserlechner/maven/jopencage/images/download.svg) ](https://bintray.com/moberwasserlechner/maven/jopencage/_latestVersion)

### Maven

Repository

    <repositories>
      <!-- ... other dependency elements ... -->
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
        <version>1.0.0</version>
      </dependency>
    </dependencies>


### Gradle

Repository

    //
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
      compile ("com.byteowls:jopencage:1.0.0")
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

# Missing something?

Please create a issue or a pull request. https://github.com/byteowls/jopencage/issues

# Testing

For running the tests you have to use your own OpenCage API Key.

* OPENCAGE\_API\_KEY ... Provide your own opencage api key using env variables. e.g. -DOPENCAGE\_API\_KEY=YourKey