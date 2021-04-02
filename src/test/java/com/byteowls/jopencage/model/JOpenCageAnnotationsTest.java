package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageAnnotationsTest extends JOpenCageBaseApiTest {

    @Test
    public void testAnnotationIncluded() {
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(-22.6792, 14.5272);
        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            assertNotNull(r.getAnnotations());
        }
    }

    @Test
    public void testQiblaAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
        request.setRestrictToCountryCode("at");
        request.setLimit(1);
        request.setNoAnnotations(false);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            Double qibla = r.getAnnotations().getQibla();
            assertNotNull(qibla);
            assertTrue(qibla >= 0 && qibla <= 360);
        }
    }

    @Test
    public void testWikiDataAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
        request.setRestrictToCountryCode("at");
        request.setLimit(1);
        request.setNoAnnotations(false);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            assertNotNull(r.getAnnotations().getWikidata());
        }
    }

}
