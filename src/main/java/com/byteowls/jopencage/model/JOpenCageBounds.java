package com.byteowls.jopencage.model;


public class JOpenCageBounds {
  
  private JOpenCageLatLng northeast;
  private JOpenCageLatLng southwest;
  
  public JOpenCageLatLng getNortheast() {
    return northeast;
  }
  
  public void setNortheast(JOpenCageLatLng northeast) {
    this.northeast = northeast;
  }
  
  public JOpenCageLatLng getSouthwest() {
    return southwest;
  }
  
  public void setSouthwest(JOpenCageLatLng southwest) {
    this.southwest = southwest;
  }
  
}
