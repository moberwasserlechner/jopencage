package com.byteowls.jopencage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageStayInformed {
  
  private String blog;
  private String twitter;
  
  public String getBlog() {
    return this.blog;
  }
  
  public String getTwitter() {
    return this.twitter;
  }
  
}
