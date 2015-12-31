package com.byteowls.jopencage.model;

import java.util.HashMap;
import java.util.Map;


public abstract class JOpenCageRequest {
  
  private String subkey;
  
  public Map<String,String> getParameter() {
    Map<String, String> parameter = new HashMap<>();
    if (subkey != null) {
      parameter.put("subkey", subkey);
    }
    return parameter;
  }
  
  public String getSubkey() {
    return subkey;
  }

  /**
   * A unique id of your choosing (can contain only A-Za-z0-9 and with a maximum length of 20 characters). 
   * The subkey is ignored by the geocoder but can be used for reporting. Not currently in use, but coming soon.
   * @param subkey
   */
  public void setSubkey(String subkey) {
    this.subkey = subkey;
  }

}
