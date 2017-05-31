package com.byteowls.jopencage;

import com.byteowls.jopencage.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GeoCoderTests {

  private JOpenCageGeocoder jOpenCageGeocoder;

  @Before
  public void setup() {
    String apiKey = System.getProperty("OPENCAGE_API_KEY");
    if (apiKey == null) {
      apiKey = System.getenv("OPENCAGE_API_KEY");
    }

    this.jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
    //    this.jOpenCageGeocoder.setHttpsEnabled(true);
  }

  @Test
  public void testWildConfigured() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
    request.setMinConfidence(1);
    //    request.setLanguage("de");
    //    request.setRestrictToCountryCode("at");
    request.setNoAnnotations(false);
    request.setNoDedupe(true);
    request.setSubkey("test");

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);


    JOpenCageLatLng firstPosition = response.getFirstPosition();
    Assert.assertNotNull(firstPosition);
  }

  @Test
  public void testReverseWildConfigured() {
    JOpenCageReverseRequest request = new JOpenCageReverseRequest(-22.6792, 14.5272);
    //    request.setLanguage("de");
    request.setNoAnnotations(true);

    JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
    Assert.assertNotNull(response);
  }

  @Test
  public void testAnnotationIncluded() {
    JOpenCageReverseRequest request = new JOpenCageReverseRequest(-22.6792, 14.5272);
    //    request.setLanguage("de");
    //    request.setNoAnnotations(true);

    JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      Assert.assertNotNull(r.getAnnotations());
    }
  }

  @Test
  public void testWikiDataAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
    request.setRestrictToCountryCode("at");
    request.setLimit(1);
    request.setNoAnnotations(false);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      Assert.assertNotNull(r.getAnnotations().getWikidata());
    }
  }

  @Test
  public void testTypeComponent() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
    request.setRestrictToCountryCode("at");
    request.setLimit(1);
    request.setNoAnnotations(true);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      Assert.assertNotNull(r.getComponents().getType());
    }
  }

  @Test
  public void testQiblaAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
    request.setRestrictToCountryCode("at");
    request.setLimit(1);
    request.setNoAnnotations(false);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      Float qibla = r.getAnnotations().getQibla();
      Assert.assertNotNull(qibla);
      Assert.assertTrue(qibla >= 0 && qibla <= 360);
    }
  }

  @Test
  public void testOSGBAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("London");
    request.setRestrictToCountryCode("uk");
    request.setLimit(1);
    request.setNoAnnotations(false);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      JOpenCageOSGB osgb = r.getAnnotations().getOSGB();
      Assert.assertNotNull(osgb);
    }
  }

}
