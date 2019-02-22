package com.byteowls.jopencage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BatchGeoCoderTests {

  private static final Logger LOGGER = LoggerFactory.getLogger(BatchGeoCoderTests.class);

  private static final String REVERSE_SAMPLES = "batchGeoCoderInput/reverseBatchSample.txt";
  private static final String FORWARD_SAMPLES = "batchGeoCoderInput/forwardBatchSample.txt";

  private JOpenCageGeocoder jOpenCageGeocoder;

  @Before
  public void setup() {
    String apiKey = System.getProperty("OPENCAGE_API_KEY");
    if (apiKey == null) {
      apiKey = System.getenv("OPENCAGE_API_KEY");
    }
    this.jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
  }

  private List<String> getSamplesFromFile(String path) {
    List<String> list = new ArrayList<>();

    InputStream inputFile = getClass().getClassLoader().getResourceAsStream(path);
    Assert.assertNotNull(inputFile);

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputFile, StandardCharsets.UTF_8))) {
      list = br.lines().collect(Collectors.toList());
    } catch (IOException e) {
      LOGGER.error("Unable to read file '" + path + "'", e);
    }
    return list;
  }

  @Test
  public void forwardBatchTest() {
    List<String> addresses = getSamplesFromFile(FORWARD_SAMPLES);
    for (String address : addresses) {
      JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
      request.setLimit(1);
      request.setNoAnnotations(true);

      JOpenCageResponse response = this.jOpenCageGeocoder.forward(request);
      Assert.assertTrue(response != null && response.getResults() != null && !response.getResults().isEmpty());

      JOpenCageLatLng coordinates = response.getResults().get(0).getGeometry();

      LOGGER.info("Coordinate: {},{}", coordinates.getLat(), coordinates.getLng());
      Assert.assertNotNull(coordinates);

      try {
        Thread.sleep(1000); // free trial accounts are limited to 1 request/second
      } catch (InterruptedException e) {
        LOGGER.error("", e);
      }
    }
  }

  @Test
  public void reverseBatchTest() {
    for (String coordinatePair : getSamplesFromFile(REVERSE_SAMPLES)) {
      Double lat = Double.valueOf(coordinatePair.split(",")[0]);
      Double lng = Double.valueOf(coordinatePair.split(",")[1]);
      JOpenCageReverseRequest request = new JOpenCageReverseRequest(lat, lng);
      request.setLimit(1);
      request.setNoAnnotations(true);
      JOpenCageResponse response = jOpenCageGeocoder.reverse(request);

      Assert.assertTrue("Unable to find address for coordinates: " + coordinatePair, response != null && response.getResults() != null && !response.getResults().isEmpty());

      String formattedAddress = response.getResults().get(0).getFormatted();

      LOGGER.info("Adress: {}", formattedAddress);
      Assert.assertNotNull(formattedAddress);

      try {
        Thread.sleep(1000); // free trial accounts are limited to 1 request/second
      } catch (InterruptedException e) {
        LOGGER.error("", e);
      }
    }
  }

}
