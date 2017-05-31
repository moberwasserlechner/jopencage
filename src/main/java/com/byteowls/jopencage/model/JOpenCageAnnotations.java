package com.byteowls.jopencage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Annotations supplies additional information about the result location.
 * 
 * see http://geocoder.opencagedata.com/api.html#annotations for details.
 * 
 * @author michael@byteowls.com
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageAnnotations {

  // DMS
  @JsonProperty("DMS")
  private JOpenCageDMS DMS;

  @JsonProperty("MGRS")
  private String MGRS;

  @JsonProperty("Maidenhead")
  private String maidenhead;

  // TODO Mercator see http://geocoder.opencagedata.com/api.html#annotations
  // TODO sun see http://geocoder.opencagedata.com/api.html#annotations

  @JsonProperty("OSGB")
  private JOpenCageOSGB OSGB;

  @JsonProperty("OSM")
  private JOpenCageOSM OSM;

  /**
   * the telephone calling code for the country of the result.
   */
  @JsonProperty("callingcode")
  private int telephoneCallingCode;

  @JsonProperty("geohash")
  private String geoHash;

  @JsonProperty("timezone")
  private JOpenCageTimeZone timeZone; 

  private JOpenCageWhat3Words what3words;

  private String wikidata;

  private Float qibla;

  public JOpenCageDMS getDMS() {
    return DMS;
  }

  public String getMGRS() {
    return MGRS;
  }

  public String getMaidenhead() {
    return maidenhead;
  }

  /**
   * Contains the Ordnance Survey National Grid easting , northing , and gridref of the center point of the result.
   * This annotation is applied only for locations in Great Britain.
   */
  public JOpenCageOSGB getOSGB() {
    return OSGB;
  }

  public JOpenCageOSM getOSM() {
    return OSM;
  }

  public int getTelephoneCallingCode() {
    return telephoneCallingCode;
  }

  public String getGeoHash() {
    return geoHash;
  }

  public JOpenCageTimeZone getTimeZone() {
    return timeZone;
  }

  public JOpenCageWhat3Words getWhat3words() {
    return what3words;
  }

  /**
   * Wikidata item for the location. A Wikidata item is a unique identifier used by the Wikimedia Foundation and others.
   */
  public String getWikidata() {
    return wikidata;
  }

  /**
   * Decimal degrees clockwise from true north to turn to point to the Kaaba (21.4225,39.8262). Calculated using the great circle method.
   */
  public Float getQibla() {
    return qibla;
  }


}
