package nl.hhs.eksameneer.jsonHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import nl.hhs.eksameneer.JsonStorable;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;

import java.io.*;
import java.util.ArrayList;

public class JsonHandler {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Voordat er opgeslagen wordt haal ook alle studenten op. Vb:
    // ArrayList<Student> opgehaaldeStudenten = jsonHandler.haalStudentenOp();
    // Voeg dan toe met opgehaaldeStudenten.add(...) enz.
    // Dit zodat oude data niet overgeschreven wordt
    public static void slaOp(ArrayList<Object> object, String fileName) throws IOException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        // Schrijf naar de file met een FileWriter object en gson
        FileWriter writer = new FileWriter(file);
        gson.toJson(object, writer);

        // Sluit de FileWriter
        writer.flush();
        writer.close();
    }

    public static JsonArray haalJsonArrayOp(String fileName) throws FileNotFoundException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        // Lees de file met een FileReader object en gson
        Reader reader = new FileReader(file);

        return gson.fromJson(reader, JsonArray.class);
    }

    public static ArrayList<Student> haalStudentenOp() throws FileNotFoundException {
        JsonArray jsonArray = haalJsonArrayOp( "student.json");
        ArrayList<Student> studenten = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            int nummer = jsonObject.get("studentNummer").getAsInt();
            String naam = jsonObject.get("naam").getAsString();

            Student student = new Student(nummer, naam);
            studenten.add(student);
        }

        return studenten;
    }

    public static Student haalStudentOp(int studentNummer) throws FileNotFoundException {
        ArrayList<Student> opgehaaldeStudenten = haalStudentenOp();
        for (Student student : opgehaaldeStudenten) {
            if (student.getStudentNummer() == studentNummer) {
                return student;
            }
        }
        return null;
    }

    public static ArrayList<Resultaat> haalResultatenOp() throws FileNotFoundException {
        JsonArray jsonArray = haalJsonArrayOp("resultaat.json");
        ArrayList<Resultaat> resultaten = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            double cijfer = jsonObject.get("cijfer").getAsDouble();

            JsonObject studentJsonObj = (JsonObject) jsonObject.get("Student");
            Student student = haalStudentOp(studentJsonObj.get("studentNummer").getAsInt());

            JsonObject examenJsonObj = (JsonObject) jsonObject.get("Examen");
            Examen examen = Examen.getExamenFromCode(examenJsonObj.get("examenCode").getAsString());
        }

        return resultaten;
    }
}
