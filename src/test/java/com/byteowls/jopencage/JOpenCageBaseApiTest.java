package com.byteowls.jopencage;

import org.junit.jupiter.api.BeforeEach;

public abstract class JOpenCageBaseApiTest {

    protected JOpenCageGeocoder jOpenCageGeocoder;

    @BeforeEach
    public void setup() {
        String apiKey = System.getProperty(JOpenCageTestUtils.OPENCAGE_API_KEY);
        if (apiKey == null) {
            apiKey = System.getenv(JOpenCageTestUtils.OPENCAGE_API_KEY);
        }
        this.jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
        JOpenCageTestUtils.freeTrailSleep();
    }



}
