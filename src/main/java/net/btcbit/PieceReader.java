package net.btcbit;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PieceReader {

    public static List<Note> parser(Reader reader) throws IOException, ParseException, RuntimeException {
        JSONParser parser = new JSONParser();
        Function<JSONArray, Note> func = val -> new Note((long)val.get(0), (long)val.get(1));
        JSONArray a = (JSONArray) parser.parse(reader);
        return Arrays.stream(a.toArray()).peek(o -> validateNote((JSONArray) o)).map(o -> func.apply((JSONArray) o)).toList();
    }

    private static void validateNote(JSONArray array) {
        Object[] objects = array.toArray();
        if (objects.length != 2) {
            throw new RuntimeException("wrong file format");
        }
    }

}
