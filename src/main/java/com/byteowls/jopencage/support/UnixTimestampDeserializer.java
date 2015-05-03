package com.byteowls.jopencage.support;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


/**
 * Based on http://stackoverflow.com/questions/20635698/how-do-i-deserialize-timestamps-that-are-in-seconds-with-jackson
 * @author michael@byteowls.com
 *
 */
public class UnixTimestampDeserializer extends JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    String timestamp = p.getText().trim();
    try {
      return new Date(Long.valueOf(timestamp + "000"));
    } catch (NumberFormatException e) {}
    
    return null;
  }

}
