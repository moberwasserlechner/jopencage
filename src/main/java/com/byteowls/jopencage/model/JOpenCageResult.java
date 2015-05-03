package com.byteowls.jopencage.model;


public class JOpenCageResult implements Comparable<JOpenCageResult>{
  
  private JOpenCageAnnotations annotations;
  private JOpenCageBounds bounds;
  private JOpenCageComponents components;
  private int confidence;
  private String formatted;
  private JOpenCageLatLng geometry;
  
  public JOpenCageAnnotations getAnnotations() {
    return annotations;
  }
  
  public JOpenCageBounds getBounds() {
    return bounds;
  }
  
  public JOpenCageComponents getComponents() {
    return components;
  }
  
  public int getConfidence() {
    return confidence;
  }
  
  public String getFormatted() {
    return formatted;
  }
  
  public JOpenCageLatLng getGeometry() {
    return geometry;
  }

  @Override
  public int compareTo(JOpenCageResult o) {
    return Integer.valueOf(this.confidence).compareTo(o.getConfidence());
  }
  
}
