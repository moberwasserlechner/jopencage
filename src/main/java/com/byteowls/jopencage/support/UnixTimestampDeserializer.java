package com.byteowls.jopencage.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;


/**
 * Based on http://stackoverflow.com/questions/20635698/how-do-i-deserialize-timestamps-that-are-in-seconds-with-jackson
 *
 * @author michael@byteowls.com
 */
public class UnixTimestampDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String timestamp = p.getText().trim();
        try {
            return new Date(Long.parseLong(timestamp + "000"));
        } catch (NumberFormatException ignore) {}
        return null;
    }

}
