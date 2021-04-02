package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageFIPSTest extends JOpenCageBaseApiTest {

    @Test
    public void testFIPSAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("New York");
        request.setLimit(1);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            JOpenCageFIPS fips = r.getAnnotations().getFIPS();
            assertNotNull(fips);
            break;
        }
    }


}
