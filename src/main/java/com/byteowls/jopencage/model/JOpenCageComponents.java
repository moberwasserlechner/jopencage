package com.byteowls.jopencage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageComponents {
  
  private String city;
  @JsonProperty("city_district")
  private String cityDistrict;
  private String country;
  @JsonProperty("country_code")
  private String countryCode;
  private String county;
  private String postcode;
  private String road;
  @JsonProperty("house_number")
  private String houseNumber;
  private String state;
  
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
  
  public String getPostcode() {
    return postcode;
  }
  
  public String getRoad() {
    return road;
  }
  
  public String getHouseNumber() {
    return houseNumber;
  }
  
  public String getState() {
    return state;
  }
  
  
}
