package com.byteowls.jopencage.model;

public enum JOpenCageFormat {
  JSON("json"),
  GEOJSON("geojson"),
  XML("xml");

  private String format;

  JOpenCageFormat(String format){
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}
