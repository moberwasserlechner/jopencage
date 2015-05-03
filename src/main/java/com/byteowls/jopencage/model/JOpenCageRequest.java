package com.byteowls.jopencage.model;

import java.util.HashMap;
import java.util.Map;


public abstract class JOpenCageRequest {
  
  public Map<String,String> getParameter() {
    Map<String, String> parameter = new HashMap<>();
    return parameter;
  }

}
