package com.byteowls.jopencage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;


public class GeoCoderTests {
  
  private final static String API_KEY = System.getProperty("OPENCAGE_API_KEY");
  
  private JOpenCageGeocoder jOpenCageGeocoder;
  
  @Before
  public void setup() {
    this.jOpenCageGeocoder = new JOpenCageGeocoder(API_KEY);
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

}
