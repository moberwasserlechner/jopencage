package com.byteowls.jopencage.model;

import java.util.Map;

public class JOpenCageReverseRequest extends JOpenCageRequest {

  private Double latitude;
  private Double longitude;

  public JOpenCageReverseRequest(Double latitude, Double longitude) {
    if (latitude == null || longitude == null) {
      throw new IllegalArgumentException("Both latitude and longitude must not be null!");
    }
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Map<String,String> getParameter() {
    Map<String, String> parameter = super.getParameter();
    parameter.put("q", latitude.toString()+" "+longitude.toString());
    return parameter; 
  }

}
