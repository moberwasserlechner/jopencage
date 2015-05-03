package com.byteowls.jopencage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.byteowls.jopencage.model.JOpenCageResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ModelTests {
  
  @Test
  public void testResponseModel() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JOpenCageResponse jOpenCageResponse = mapper.readValue(getClass().getResourceAsStream("toadd"), JOpenCageResponse.class);
    Assert.assertNotNull(jOpenCageResponse);
  }
  
  @Test
  public void testResponseDateDeserialization() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JOpenCageResponse jOpenCageResponse = mapper.readValue(getClass().getResourceAsStream("toadd"), JOpenCageResponse.class);
    Assert.assertNotNull(jOpenCageResponse);
    
    Date createdAt = jOpenCageResponse.getTimestamp().getCreatedAt();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Assert.assertEquals("2015-05-03 14:29:49", dateFormat.format(createdAt));
  }

}
