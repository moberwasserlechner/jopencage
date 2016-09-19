package com.byteowls.jopencage;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;

public class GeoCoderRequestUriTests {
  
  private JOpenCageGeocoder jOpenCageGeocoder;
  
  @Before
  public void setup() {
    String apiKey = System.getProperty("OPENCAGE_API_KEY");
    if (apiKey == null) {
      apiKey = System.getenv("OPENCAGE_API_KEY");
    }
    this.jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
  }
  
  @Test
  public void testForwardUriSimple() throws URISyntaxException {
    URI uri = jOpenCageGeocoder.buildUri(new JOpenCageForwardRequest("Graz"));
    
    String uriString = uri.toString();
    Assert.assertNotNull(uriString);
    // parameter order not garanteed
//    Assert.assertEquals("https://api.opencagedata.com/geocode/v1/json?q=Graz&key=YOUR-KEY-HERE", uriString);
  }
  
  
  @Test
  public void testForwardUriAll() throws URISyntaxException {
    JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
    forwardReq.setPretty(true);
    forwardReq.setLanguage("de-AT");
    forwardReq.setRestrictToCountryCode("at");
    forwardReq.setLimit(2);
    forwardReq.setMinConfidence(9);
    forwardReq.setNoAnnotations(true);
    forwardReq.setNoDedupe(true);
    forwardReq.setBounds(-0.563160,51.280430,0.278970,51.683979);
    URI uri = jOpenCageGeocoder.buildUri(forwardReq);
    
    String uriString = uri.toString();
    Assert.assertNotNull(uriString);
    // order not garanteed
    //Assert.assertEquals("https://api.opencagedata.com/geocode/v1/json?no_annotations=1&q=Graz&pretty=1&limit=2&no_dedupe=1&language=de-AT&min_confidence=9&key=YOUR-KEY-HERE", uriString);
  }

}
