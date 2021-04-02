package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageSunTest extends JOpenCageBaseApiTest {

    @Test
    public void testSunAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Berlin");
        request.setLimit(1);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            JOpenCageSun sun = r.getAnnotations().getSun();
            assertNotNull(sun);
            assertNotNull(sun.getRise().getApparent());
            assertNotNull(sun.getSet().getApparent());
            break;
        }
    }

}
