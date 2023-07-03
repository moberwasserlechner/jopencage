package com.byteowls.jopencage.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;

public class JOpenCageReverseRequest extends JOpenCageRequest {

    // A latitude/longitude number with seventh decimal place is worth up to 1.11cm
    private static final ThreadLocal<DecimalFormat> FORMATTER =
        ThreadLocal.withInitial(() -> {
            DecimalFormat decimalFormat = new DecimalFormat("##.#######");
            // make sure the formatter does not use the system language
            decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            return decimalFormat;
        });

    private final Double latitude;
    private final Double longitude;

    public JOpenCageReverseRequest(Double latitude, Double longitude) {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException("Both latitude and longitude must not be null!");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Map<String, String> getParameter() {
        Map<String, String> parameter = super.getParameter();
        final DecimalFormat decimalFormat = FORMATTER.get();
        parameter.put("q", decimalFormat.format(latitude) + " " + decimalFormat.format(longitude));
        return parameter;
    }

}
