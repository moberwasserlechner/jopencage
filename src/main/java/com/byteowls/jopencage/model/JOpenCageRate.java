package com.byteowls.jopencage.model;

import java.util.Date;

import com.byteowls.jopencage.support.UnixTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class JOpenCageRate {
  
  private int limit;
  private int remaining;
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date reset;
  
  public int getLimit() {
    return limit;
  }
  
  public void setLimit(int limit) {
    this.limit = limit;
  }
  
  public int getRemaining() {
    return remaining;
  }
  
  public void setRemaining(int remaining) {
    this.remaining = remaining;
  }
  
  public Date getReset() {
    return reset;
  }
  
  public void setReset(Date reset) {
    this.reset = reset;
  }
  
}
