package com.byteowls.jopencage.model;

import java.util.Map;


public class JOpenCageReverseRequest extends JOpenCageRequest {

  private Double latitude;
  private Double longitude;

  private String language; // defaults to en
  private boolean noAnnotations;
  private boolean pretty;

  public JOpenCageReverseRequest(Double latitude, Double longitude) {
    if (latitude == null || longitude == null) {
      throw new IllegalArgumentException("Both latitude and longitude must not be null!");
    }
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Map<String,String> getParameter() {
    Map<String, String> parameter = super.getParameter();
    parameter.put("query", latitude.toString()+" "+longitude.toString());
    parameter.put("language", language);
    if (pretty) {
      parameter.put("pretty", "1");  
    }
    if (noAnnotations) {
      parameter.put("no_annotations", "1");
    }
    return parameter; 
  }

  
  public String getLanguage() {
    return language;
  }

  
  /**
   * An IETF format language code (such as es for Spanish or pt-BR for Brazilian Portuguese); if this is omitted a code of en (English) will be assumed
   * @param language a language code.
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  
  public boolean isPretty() {
    return pretty;
  }

  /**
   * If set to true pretty printing of the response payload is enabled.
   * @param pretty
   */
  public void setPretty(boolean pretty) {
    this.pretty = pretty;
  }

  
  public boolean isNoAnnotations() {
    return noAnnotations;
  }

  
  public void setNoAnnotations(boolean noAnnotations) {
    this.noAnnotations = noAnnotations;
  }

  
  

}
