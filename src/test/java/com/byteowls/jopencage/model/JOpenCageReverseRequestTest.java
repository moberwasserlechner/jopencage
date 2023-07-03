package com.byteowls.jopencage.model;

import com.byteowls.jopencage.JOpenCageBaseApiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JOpenCageReverseRequestTest extends JOpenCageBaseApiTest {

    @Test
    public void testBasic() {
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(1.23, 125.234);
        request.setLanguage("en");
        String query = request.getParameter().get("q");
        assertNotNull(query);
        assertEquals("1.23 125.234", query);
    }

    @Test
    public void testDecimalWithLargeScale() {
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(51.512173691848446, -0.0004923223308081751);
        String query = request.getParameter().get("q");
        assertNotNull(query);
        assertEquals("51.5121737 -0.0004923", query);
    }

}
