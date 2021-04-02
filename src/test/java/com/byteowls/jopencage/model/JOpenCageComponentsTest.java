package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageComponentsTest extends JOpenCageBaseApiTest {

    @Test
    public void testTypeComponent() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
        request.setRestrictToCountryCode("at");
        request.setLimit(1);
        request.setNoAnnotations(true);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            assertNotNull(r.getComponents().getType());
        }
    }

    @Test
    public void testComponentVillage() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Kovalivka");
        request.setLimit(1);
        request.setNoAnnotations(true);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            assertNotNull(r.getComponents().getVillage());
        }
    }

    @Test
    void unmappedFields() throws IOException {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
        request.setLimit(1);
        request.setNoAnnotations(true);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        assertNotNull(response.getFirstComponents().getUnmappedFields());
        assertFalse(response.getFirstComponents().getUnmappedFields().isEmpty());
    }

}
