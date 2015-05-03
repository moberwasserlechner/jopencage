package com.byteowls.jopencage.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JOpenCageForwardRequest extends JOpenCageRequest {

  /**
   * If set the api will provide much better results
   */
  private JOpenCageBounds bounds;
  /**
   * If set the api will provide much better results
   */
  private String restrictToCountryCode;
  private String language; // defaults to en
  private Integer limit;
  private Integer minConfidence;
  private boolean noAnnotations;
  private boolean noDedupe;
  private boolean pretty;
//  private String query;
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
    parameter.put("query", sb.toString());
    
    if (bounds != null) {
      String boundsSTr = bounds.getSouthwest().getLat()
          + "," + bounds.getSouthwest().getLng() 
          + "," + bounds.getNortheast().getLat() 
          + "," + bounds.getNortheast().getLng();
      parameter.put("bounds", boundsSTr);
    }
    
    parameter.put("countrycode", restrictToCountryCode);
    parameter.put("language", language);
    if (limit != null) {
      parameter.put("limit", String.valueOf(limit));
    }
    if (minConfidence != null) {
      parameter.put("min_confidence", String.valueOf(minConfidence));
    }
    
    if (noAnnotations) {
      parameter.put("no_annotations", "1");
    }
    if (noDedupe) {
      parameter.put("no_dedupe", "1");
    }
    if (pretty) {
      parameter.put("pretty", "1");
    }
    return parameter;
  }

  
  public JOpenCageBounds getBounds() {
    return bounds;
  }

  
  public void setBounds(JOpenCageBounds bounds) {
    this.bounds = bounds;
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

  
  public String getLanguage() {
    return language;
  }

  
  /**
   * An IETF format language code (such as es for Spanish or pt-BR for Brazilian Portuguese); if this is omitted a code of en (English) will be assumed
   * @param language
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  
  public Integer getLimit() {
    return limit;
  }

  
  /**
   * How many results should be returned. Default is 10.
   * @param limit
   */
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  
  public Integer getMinConfidence() {
    return minConfidence;
  }

  
  /**
   * An integer from 1-10 only results with at least this confidence will be returned.
   * @param minConfidence
   */
  public void setMinConfidence(Integer minConfidence) {
    this.minConfidence = minConfidence;
  }

  
  public boolean isNoAnnotations() {
    return noAnnotations;
  }

  
  /**
   * If set to true the results will not contain annotations.
   * @param noAnnotations
   */
  public void setNoAnnotations(boolean noAnnotations) {
    this.noAnnotations = noAnnotations;
  }

  
  public boolean isNoDedupe() {
    return noDedupe;
  }

  /**
   * If set to true the results will not be deduplicated.
   * @param noDedupe
   */
  public void setNoDedupe(boolean noDedupe) {
    this.noDedupe = noDedupe;
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
  
  /**
   * Provides the geocoder with a hint to the region that the query resides in. This value will help the geocoder but will not restrict the possible results to the supplied region.
   * @param northEastLat
   * @param northEastLng
   * @param southWestLat
   * @param southWestLng
   */
  public void setBounds(Double northEastLat, Double northEastLng, Double southWestLat, Double southWestLng) {
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

  
  /**
   * If you use the query part constructor this String separates the query parts from each other. Defaults to a colon.
   * @param queryPartSeparator
   */
  public void setQueryPartSeparator(String queryPartSeparator) {
    this.queryPartSeparator = queryPartSeparator;
  }
  
}
