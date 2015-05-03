package com.byteowls.jopencage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author michael@byteowls.com
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageTimeZone {
  
  private String name;
  @JsonProperty("now_in_dst")
  private int nowInDst;
  @JsonProperty("offset_sec")
  private int offsetSec;
  @JsonProperty("offset_string")
  private int offsetString;
  @JsonProperty("short_name")
  private String shortName;
  
  public String getName() {
    return name;
  }
  
  public int getNowInDst() {
    return nowInDst;
  }
  
  public int getOffsetSec() {
    return offsetSec;
  }
  
  public int getOffsetString() {
    return offsetString;
  }
  
  public String getShortName() {
    return shortName;
  }
  
  
}
