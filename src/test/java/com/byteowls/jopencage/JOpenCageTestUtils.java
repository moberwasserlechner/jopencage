package com.byteowls.jopencage;

public abstract class JOpenCageTestUtils {

    public static final String OPENCAGE_API_KEY = "OPENCAGE_API_KEY";

    public static void freeTrailSleep() {
        try {
            Thread.sleep(1000); // free trial accounts are limited to 1 request/second
        } catch (InterruptedException ignore) {}
    }

}
