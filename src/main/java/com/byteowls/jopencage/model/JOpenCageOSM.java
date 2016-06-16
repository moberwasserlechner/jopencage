package com.byteowls.jopencage.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class JOpenCageOSM {
  
  private String url;
  @JsonProperty("edit_url")
  private String editUrl;
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }

  public String getEditUrl() {
    return editUrl;
  }

  public void setEditUrl(String editUrl) {
    this.editUrl = editUrl;
  }
}
