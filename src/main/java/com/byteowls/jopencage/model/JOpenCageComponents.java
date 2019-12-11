package com.byteowls.jopencage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageComponents {
  @JsonProperty("ISO_3166-1_alpha-2")
  private String iso31661Alpha2;
  @JsonProperty("ISO_3166-1_alpha-3")
  private String iso31661Alpha3;

  @JsonProperty("_type")
  private String type;
  private String continent;
  private String city;
  @JsonProperty("city_district")
  private String cityDistrict;
  private String country;
  @JsonProperty("country_code")
  private String countryCode;
  private String county;
  private String pedestrian;
  private String postcode;
  private String road;
  @JsonProperty("road_type")
  private String roadType;
  @JsonProperty("house_number")
  private String houseNumber;
  private String neighbourhood;
  private String state;
  @JsonProperty("state_code")
  private String stateCode;
  @JsonProperty("state_district")
  private String stateDistrict;
  private String region;
  @JsonProperty("political_union")
  private String politicalUnion;
  private String suburb;
  private String town;
  private String village;

  /**
   * @deprecated use {@link #getIso31661Alpha2()} instead
   */
  public String getISO31661() {
    return iso31661Alpha2;
  }

  public String getIso31661Alpha2() {
    return iso31661Alpha2;
  }

  public String getIso31661Alpha3() {
    return iso31661Alpha3;
  }

  public String getType() {
    return type;
  }

  public String getContinent() {
    return continent;
  }

  public String getCity() {
    return city;
  }

  public String getCityDistrict() {
    return cityDistrict;
  }

  public String getCountry() {
    return country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public String getCounty() {
    return county;
  }

  public String getPedestrian() {
    return pedestrian;
  }

  public String getPostcode() {
    return postcode;
  }

  public String getRoad() {
    return road;
  }

  public String getRoadType() {
    return roadType;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public String getNeighbourhood() {
    return neighbourhood;
  }

  public String getState() {
    return state;
  }

  public String getStateCode() {
    return stateCode;
  }

  public String getStateDistrict() {
    return stateDistrict;
  }

  public String getRegion() {
    return region;
  }

  public String getPoliticalUnion() {
    return politicalUnion;
  }

  public String getSuburb() {
    return suburb;
  }

  public String getTown() {
    return town;
  }

  public String getVillage() {
    return village;
  }

}
