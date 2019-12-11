package com.byteowls.jopencage;

import com.byteowls.jopencage.model.JOpenCageCurrency;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageITM;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageMercator;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageResult;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import com.byteowls.jopencage.model.JOpenCageSun;
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
  public void testComponentVillage() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Kovalivka");
    request.setLimit(1);
    request.setNoAnnotations(true);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      Assert.assertNotNull(r.getComponents().getVillage());
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
      Double qibla = r.getAnnotations().getQibla();
      Assert.assertNotNull(qibla);
      Assert.assertTrue(qibla >= 0 && qibla <= 360);
    }
  }

  @Test
  public void testMercatorAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("London");
    request.setLimit(1);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      JOpenCageMercator mercator = r.getAnnotations().getMercator();
      Assert.assertNotNull(mercator);
    }
  }


  @Test
  public void testCurrencyAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Bern");
    request.setLimit(1);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      JOpenCageCurrency currency = r.getAnnotations().getCurrency();
      Assert.assertTrue(currency.getName().equalsIgnoreCase("Swiss Franc"));
      Assert.assertTrue(currency.getIsoNumeric() == 756);
      Assert.assertTrue(currency.getSmallestDenomination() == 5);
      Assert.assertTrue(currency.isSymbolFirst());
      break;
    }
  }

  @Test
  public void testSunAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Berlin");
    request.setLimit(1);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      JOpenCageSun sun = r.getAnnotations().getSun();
      Assert.assertNotNull(sun);
      Assert.assertNotNull(sun.getRise().getApparent());
      Assert.assertNotNull(sun.getSet().getApparent());
      break;
    }
  }

  @Test
  public void testITMAnnotation() {
    JOpenCageForwardRequest request = new JOpenCageForwardRequest("Dublin");
    request.setLimit(1);

    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    Assert.assertNotNull(response);

    for (JOpenCageResult r : response.getResults()) {
      JOpenCageITM itm = r.getAnnotations().getITM();
      Assert.assertNotNull(itm);
      break;
    }
  }

}
