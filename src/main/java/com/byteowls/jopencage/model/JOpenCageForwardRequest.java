package com.byteowls.jopencage.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JOpenCageForwardRequest extends JOpenCageRequest {

  /**
   * If set the api will provide much better results. Forward only!
   */
  private JOpenCageBounds bounds;
  /**
   * If set the api will provide much better results. Forward only!
   */
  private String restrictToCountryCode;

  private List<String> queryParts = new ArrayList<>();
  private String queryPartSeparator = ",";
  
  public JOpenCageForwardRequest(String query) {
    if (query == null) {
      throw new IllegalArgumentException("Query must not null!");
    }
    this.queryParts.add(query);
  }
  
  public JOpenCageForwardRequest(String... queryParts) {
    if (queryParts == null || queryParts.length <= 0) {
      throw new IllegalArgumentException("queryParts must not null!");
    }
    
    for (String p : queryParts) {
      this.queryParts.add(p);
    }
  }
  
  public Map<String,String> getParameter() {
    Map<String, String> parameter = super.getParameter();
    StringBuilder sb = new StringBuilder();
    for (String p : this.queryParts) {
      if (p != null) {
        if (sb.length() > 0) {
          sb.append(this.queryPartSeparator);
        }
        sb.append(p);
      }
    }
    parameter.put("q", sb.toString());
    
    if (bounds != null) {
      String boundsSTr = bounds.getSouthwest().getLng()
          + "," + bounds.getSouthwest().getLat() 
          + "," + bounds.getNortheast().getLng() 
          + "," + bounds.getNortheast().getLat();
      parameter.put("bounds", boundsSTr);
    }
    
    parameter.put("countrycode", restrictToCountryCode);
    
    
    return parameter;
  }

  
  public JOpenCageBounds getBounds() {
    return bounds;
  }

  
  public void setBounds(JOpenCageBounds bounds) {
    this.bounds = bounds;
  }

  /**
   * Provides the geocoder with a hint to the region that the query resides in. 
   * This value will restrict the possible results to the supplied region. 
   * The bounds parameter should be specified as 4 coordinate points forming the south-west and north-east corners of a bounding box.
   * @param southWestLng south west longitude
   * @param southWestLat south west latitude
   * @param northEastLng north east longitude
   * @param northEastLat north east latitude
   */

  public void setBounds(Double southWestLng, Double southWestLat, Double northEastLng, Double northEastLat) {

    bounds = new JOpenCageBounds();
    
    JOpenCageLatLng ne = new JOpenCageLatLng();
    ne.setLat(northEastLat);
    ne.setLng(northEastLng);
    bounds.setNortheast(ne);
    
    JOpenCageLatLng sw = new JOpenCageLatLng();
    sw.setLat(southWestLat);
    sw.setLng(southWestLng);
    bounds.setSouthwest(sw);
  }

  public String getRestrictToCountryCode() {
    return restrictToCountryCode;
  }

  /**
   * Restricts the results to the given country.
   * @param restrictToCountryCode 2 character code as defined by the ISO 3166-1 Alpha 2 standard. E.g. 'gb' for the United Kingdom, fr for France
   */
  public void setRestrictToCountryCode(String restrictToCountryCode) {
    this.restrictToCountryCode = restrictToCountryCode;
  }
  
  /**
   * If you use the query part constructor this String separates the query parts from each other. Defaults to a colon.
   * @param queryPartSeparator the query part separator. Defaults to a colon.
   */
  public void setQueryPartSeparator(String queryPartSeparator) {
    this.queryPartSeparator = queryPartSeparator;
  }
  
  
  
}
