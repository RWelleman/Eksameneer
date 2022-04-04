package nl.hhs.eksameneer.jsonHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nl.hhs.eksameneer.JsonStorable;

import java.io.*;
import java.lang.reflect.Type;

public class JsonHandler {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void slaOp(JsonStorable object, String fileName) throws IOException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        // Schrijf naar de file met een FileWriter object en gson
        FileWriter writer = new FileWriter(file);
        gson.toJson(object, writer);

        // Sluit de FileWriter
        writer.flush();
        writer.close();
    }

    public static Object haalOp(Class className, String fileName) throws FileNotFoundException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        // Lees de file met een FileReader object en gson
        Reader reader = new FileReader(file);

        return gson.fromJson(reader, className);
    }
}
