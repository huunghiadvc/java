package jsonLab;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDeserialize extends JsonDeserializer<Date> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        final String dateString = jsonParser.getText();

        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.err.println("Error!");
        }
        return null;
    }
}
