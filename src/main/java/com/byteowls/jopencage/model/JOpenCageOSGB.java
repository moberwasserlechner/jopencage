package com.byteowls.jopencage.model;

/**
 * See https://en.wikipedia.org/wiki/Ordnance_Survey_National_Grid for more information
 */
public class JOpenCageOSGB {

  private Double easting;
  private String gridref;
  private Double northing;

  public Double getEasting() {
    return easting;
  }

  public String getGridref() {
    return gridref;
  }

  public Double getNorthing() {
    return northing;
  }

  @Override
  public String toString() {
    return "JOpenCageOSGB{" +
      "easting=" + easting +
      ", gridref='" + gridref + '\'' +
      ", northing=" + northing +
      '}';
  }
}
