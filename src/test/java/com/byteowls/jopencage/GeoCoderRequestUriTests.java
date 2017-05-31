package com.byteowls.jopencage;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;

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
  }

  @Test
  public void testReverseUriSimple() throws URISyntaxException {
    URI uri = jOpenCageGeocoder.buildUri(new JOpenCageReverseRequest(41.40139, 2.12870));

    String uriString = uri.toString();
    Assert.assertNotNull(uriString);
  }


  @Test
  public void testReverseUriAll() throws URISyntaxException {
    JOpenCageReverseRequest req = new JOpenCageReverseRequest(41.40139, 2.12870);
    req.setPretty(true);
    req.setLanguage("de-AT");
    req.setLimit(2);
    req.setMinConfidence(9);
    req.setNoAnnotations(true);
    req.setNoDedupe(true);
    URI uri = jOpenCageGeocoder.buildUri(req);

    String uriString = uri.toString();
    Assert.assertNotNull(uriString);
  }

  @Test
  public void testContainsAbbrv() throws URISyntaxException {
    JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
    forwardReq.setAbbrv(true);
    URI uri = jOpenCageGeocoder.buildUri(forwardReq);

    String uriString = uri.toString();
    Assert.assertTrue(uriString.contains("abbrv=1"));
  }
  
  @Test
  public void testContainsNoRecord() throws URISyntaxException {
    JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
    forwardReq.setNoRecord(true);
    URI uri = jOpenCageGeocoder.buildUri(forwardReq);

    String uriString = uri.toString();
    Assert.assertTrue(uriString.contains("no_record=1"));
  }
  
  @Test
  public void testContainsOnlyNominatim() throws URISyntaxException {
    JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
    forwardReq.setOnlyNominatim(true);
    URI uri = jOpenCageGeocoder.buildUri(forwardReq);

    String uriString = uri.toString();
    Assert.assertTrue(uriString.contains("only_nominatim=1"));
  }

}
