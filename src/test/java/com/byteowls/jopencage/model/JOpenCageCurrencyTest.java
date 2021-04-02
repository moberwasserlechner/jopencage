package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JOpenCageCurrencyTest extends JOpenCageBaseApiTest {

    @Test
    public void testCurrencyAnnotation() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Bern");
        request.setLimit(1);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        for (JOpenCageResult r : response.getResults()) {
            JOpenCageCurrency currency = r.getAnnotations().getCurrency();
            assertTrue(currency.getName().equalsIgnoreCase("Swiss Franc"));
            assertEquals(currency.getIsoNumeric(), 756);
            assertEquals(currency.getSmallestDenomination(), 5);
            assertTrue(currency.isSymbolFirst());
            break;
        }
    }

}
