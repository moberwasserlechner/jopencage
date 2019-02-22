package com.byteowls.jopencage;

import com.byteowls.jopencage.model.JOpenCageResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class ModelTests {
  
  @Test
  @Ignore
  public void testResponseModel() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JOpenCageResponse jOpenCageResponse = mapper.readValue(getClass().getResourceAsStream("toadd"), JOpenCageResponse.class);
    Assert.assertNotNull(jOpenCageResponse);
  }
  
  @Test
  @Ignore
  public void testResponseDateDeserialization() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JOpenCageResponse jOpenCageResponse = mapper.readValue(getClass().getResourceAsStream("toadd"), JOpenCageResponse.class);
    Assert.assertNotNull(jOpenCageResponse);
    
    Date createdAt = jOpenCageResponse.getTimestamp().getCreatedAt();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
    String formattedDate = dateFormat.format(createdAt);
    Assert.assertEquals("2015-05-03 14:29", formattedDate);
  }

}
