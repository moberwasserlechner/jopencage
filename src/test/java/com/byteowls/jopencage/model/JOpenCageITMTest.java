package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageITMTest extends JOpenCageBaseApiTest {

    @Test
    public void testITMAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Dublin");
        request.setLimit(1);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            JOpenCageITM itm = r.getAnnotations().getITM();
            assertNotNull(itm);
            break;
        }
    }

}
