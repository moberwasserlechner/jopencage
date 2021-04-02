package com.byteowls.jopencage;

import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JOpenCageGeocoderTest extends JOpenCageBaseApiTest {

    @Test
    public void forwardSingle() {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("Graz");
        request.setMinConfidence(1);
        //    request.setLanguage("de");
        //    request.setRestrictToCountryCode("at");
        request.setNoAnnotations(false);
        request.setNoDedupe(true);
        request.setSubkey("test");

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        assertNotNull(response);

        JOpenCageLatLng firstPosition = response.getFirstPosition();
        assertNotNull(firstPosition);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "25 Queen Victoria St, Gardens, Cape Town, 8001, South Africa",
        "Via Giuseppe Garibaldi, 183, 16032 Camogli GE, Italy",
        "1 Hacker Way, Menlo Park, CA 94025, USA",
        "Iguazu National Park, Brazil",
        "Stanford, 7210, South Africa"
    })
    public void forwardGeoCoding(String address) {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
        request.setLimit(1);
        request.setNoAnnotations(true);

        JOpenCageResponse response = this.jOpenCageGeocoder.forward(request);
        assertTrue(response != null && response.getResults() != null && !response.getResults().isEmpty());

        JOpenCageLatLng coordinates = response.getResults().get(0).getGeometry();

        // TODO logging
//        LOGGER.info("Coordinate: {},{}", coordinates.getLat(), coordinates.getLng());
        assertNotNull(coordinates);
    }

    @Test
    public void reverseSingle() {
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(-22.6792, 14.5272);
        //    request.setLanguage("de");
        request.setNoAnnotations(true);

        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
        assertNotNull(response);
    }

    @ParameterizedTest
    @MethodSource("getCoordinates")
    public void reverseGeoCoding(Double lat, Double lng) {
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(lat, lng);
        request.setLimit(1);
        request.setNoAnnotations(true);
        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);

        assertTrue(response != null && response.getResults() != null && !response.getResults().isEmpty());

        String formattedAddress = response.getResults().get(0).getFormatted();

//        LOGGER.info("Address: {}", formattedAddress);
        assertNotNull(formattedAddress);
    }

    private static Stream<Arguments> getCoordinates() {
        return Stream.of(
            Arguments.of(43.703331d, 7.311888d),
            Arguments.of(-33.957670d, 18.460314d),
            Arguments.of(19.355160d, -99.162454d),
            Arguments.of(37.4831486d, -122.1500282d),
            Arguments.of(32.055881d, 34.779636d)
        );
    }


    @Test
    public void forwardUriSimple() throws URISyntaxException {
        URI uri = jOpenCageGeocoder.buildUri(new JOpenCageForwardRequest("Graz"));

        String uriString = uri.toString();
        assertNotNull(uriString);
    }


    @Test
    public void forwardUriAll() throws URISyntaxException {
        JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
        forwardReq.setPretty(true);
        forwardReq.setLanguage("de-AT");
        forwardReq.setRestrictToCountryCode("at");
        forwardReq.setLimit(2);
        forwardReq.setMinConfidence(9);
        forwardReq.setNoAnnotations(true);
        forwardReq.setNoDedupe(true);
        forwardReq.setBounds(-0.563160, 51.280430, 0.278970, 51.683979);
        URI uri = jOpenCageGeocoder.buildUri(forwardReq);

        String uriString = uri.toString();
        assertNotNull(uriString);
    }

    @Test
    public void reverseUriSimple() throws URISyntaxException {
        URI uri = jOpenCageGeocoder.buildUri(new JOpenCageReverseRequest(41.40139, 2.12870));

        String uriString = uri.toString();
        assertNotNull(uriString);
    }


    @Test
    public void reverseUriAll() throws URISyntaxException {
        JOpenCageReverseRequest req = new JOpenCageReverseRequest(41.40139, 2.12870);
        req.setPretty(true);
        req.setLanguage("de-AT");
        req.setLimit(2);
        req.setMinConfidence(9);
        req.setNoAnnotations(true);
        req.setNoDedupe(true);
        URI uri = jOpenCageGeocoder.buildUri(req);

        String uriString = uri.toString();
        assertNotNull(uriString);
    }

    @Test
    public void containsAbbrv() throws URISyntaxException {
        JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
        forwardReq.setAbbrv(true);
        URI uri = jOpenCageGeocoder.buildUri(forwardReq);

        String uriString = uri.toString();
        assertTrue(uriString.contains("abbrv=1"));
    }

    @Test
    public void containsNoRecord() throws URISyntaxException {
        JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
        forwardReq.setNoRecord(true);
        URI uri = jOpenCageGeocoder.buildUri(forwardReq);

        String uriString = uri.toString();
        assertTrue(uriString.contains("no_record=1"));
    }

    @Test
    public void containsOnlyNominatim() throws URISyntaxException {
        JOpenCageForwardRequest forwardReq = new JOpenCageForwardRequest("Graz");
        forwardReq.setOnlyNominatim(true);
        URI uri = jOpenCageGeocoder.buildUri(forwardReq);

        String uriString = uri.toString();
        assertTrue(uriString.contains("only_nominatim=1"));
    }

}
