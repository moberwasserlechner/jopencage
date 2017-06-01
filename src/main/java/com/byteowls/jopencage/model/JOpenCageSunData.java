package com.byteowls.jopencage.model;

import com.byteowls.jopencage.support.UnixTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;


public class JOpenCageSunData {

  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date apparent;
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date astronomical;
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date civil;
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date nautical;

  /**
   * Value represents what is typically reported as sunrise/set
   */
  public Date getApparent() {
    return apparent;
  }

  /**
   * Value represents when sky is completely dark/light
   */
  public Date getAstronomical() {
    return astronomical;
  }

  /**
   * Value represents when a person can read / no longer read
   */
  public Date getCivil() {
    return civil;
  }

  /**
   * Value represents when navigation using a sea horizon possible/no longer possible
   */
  public Date getNautical() {
    return nautical;
  }
}
