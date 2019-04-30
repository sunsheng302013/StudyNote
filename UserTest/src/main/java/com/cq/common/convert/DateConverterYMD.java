package com.cq.common.convert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 *
 * <p>
 * 类描述: fastJson中将时间转成ymd格式
 * </p>
 * 
 * @since 2019年4月17日
 * @author chengq
 */
public class DateConverterYMD extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String dateString = null;
        dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        jsonGenerator.writeString(dateString);
    }
}
