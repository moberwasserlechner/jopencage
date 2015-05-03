package com.byteowls.jopencage.model;

import java.util.Date;

import com.byteowls.jopencage.support.UnixTimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageTimestamp {
  
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  @JsonProperty("created_unix")
  private Date createdAt;
  
  public Date getCreatedAt() {
    return createdAt;
  }

}
