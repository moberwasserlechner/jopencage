package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageMercatorTest extends JOpenCageBaseApiTest {

    @Test
    public void testMercatorAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("London");
        request.setLimit(1);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            JOpenCageMercator mercator = r.getAnnotations().getMercator();
            assertNotNull(mercator);
        }
    }

}
