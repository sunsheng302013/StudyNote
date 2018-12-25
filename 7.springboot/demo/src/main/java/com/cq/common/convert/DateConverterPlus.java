package com.cq.common.convert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-12-14 17:09
 */
public class DateConverterPlus extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String dateString = null;
        dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        jsonGenerator.writeString(dateString);
    }
}
