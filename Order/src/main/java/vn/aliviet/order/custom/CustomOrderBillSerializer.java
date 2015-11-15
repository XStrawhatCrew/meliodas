package vn.aliviet.order.custom;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by windluffy on 14/11/2015.
 */
public class CustomOrderBillSerializer extends SerializerBase<Date> {
    protected CustomOrderBillSerializer() {
        super(Date.class, true);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyy HH:mm:ss");
        String formatted = formatter.format(date);
        jsonGenerator.writeString(formatted);
    }
}
