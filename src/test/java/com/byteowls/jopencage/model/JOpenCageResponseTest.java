package com.byteowls.jopencage.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageResponseTest {

    private JOpenCageResponse loadTestResponse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(getClass().getResourceAsStream("toadd"), JOpenCageResponse.class);
    }

    @Test
    public void mapping() throws IOException {
        JOpenCageResponse jOpenCageResponse = loadTestResponse();
        assertNotNull(jOpenCageResponse);
    }


    @Test
    public void dateDeserialization() throws IOException {
        JOpenCageResponse jOpenCageResponse = loadTestResponse();
        assertNotNull(jOpenCageResponse);

        Date createdAt = jOpenCageResponse.getTimestamp().getCreatedAt();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        String formattedDate = dateFormat.format(createdAt);
        assertEquals("2015-05-03 14:29", formattedDate);
    }

}
