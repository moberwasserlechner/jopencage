package com.byteowls.jopencage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;


public class BatchGeoCoderTests {

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
  @Ignore
  public void forwardBatchTest() {
    List<String> listOfAddresses = new ArrayList<>();
        
    InputStream inputFile = getClass().getClassLoader().getResourceAsStream("batchGeoCoderInput/forwardBatchSample.txt"); 
    
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputFile, StandardCharsets.UTF_8))) {
      listOfAddresses = br.lines().collect(Collectors.toList());
    } catch (IOException e) {
      System.out.println("Unable to read file");
      e.printStackTrace();
    }
  
    System.out.println("Latitude, Longitude:");
    listOfAddresses.forEach(address -> {
      try {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
        request.setLimit(1);
        request.setNoAnnotations(true);
        JOpenCageResponse response = this.jOpenCageGeocoder.forward(request);
        Thread.sleep(1000); // free trial accounts are limited to 1 request/second
        if (response != null) {
          JOpenCageLatLng coordinates = response.getResults().get(0).getGeometry();
          System.out.println(coordinates.getLat().toString() + "," + coordinates.getLng().toString());
        } else {
          System.out.println("Unable to geocode input address: " + address);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }    
    });

  }
  
  @Test
//  @Ignore
  public void reverseBatchTest() {
    List<String> listOfCoordinatePairs = new ArrayList<>();
    
    InputStream inputFile = getClass().getClassLoader().getResourceAsStream("batchGeoCoderInput/reverseBatchSample.txt"); 
    
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputFile, StandardCharsets.UTF_8))) {
      listOfCoordinatePairs = br.lines().collect(Collectors.toList());
    } catch (IOException e) {
      System.out.println("Unable to read file");
      e.printStackTrace();
    }
   
    System.out.println("Formatted addresses:");
    listOfCoordinatePairs.forEach(coordinatePair -> {
      try {
        Double lat = Double.valueOf(coordinatePair.split(",")[0]);
        Double lng = Double.valueOf(coordinatePair.split(",")[1]);
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(lat, lng);
        request.setLimit(1);
        request.setNoAnnotations(true);
        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
        Thread.sleep(1000); // free trial accounts are limited to 1 request/second
        if (response != null) {
          String formattedAddress = response.getResults().get(0).getFormatted().toString();
          System.out.println(formattedAddress);
        } else {
          System.out.println("Unable to find address for input coordinates: " + coordinatePair);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

  }

}
