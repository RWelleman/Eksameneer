package nl.hhs.eksameneer.jsonHandler;

import com.google.gson.*;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;

import java.io.*;
import java.util.ArrayList;

public class JsonHandler {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void slaStudentenOp() throws IOException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/student.json");

        boolean bestaat = new File(file).exists();
        if(!bestaat){
            return;
        }

        // Schrijf naar de file met een FileWriter object en gson
        FileWriter writer = new FileWriter(file);
        gson.toJson(Student.alleStudenten, writer);

        // Sluit de FileWriter
        writer.flush();
        writer.close();
    }

    public static void slaResultatenOp() throws IOException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/resultaat.json");

        boolean bestaat = new File(file).exists();
        if(!bestaat){
            return;
        }

        // Schrijf naar de file met een FileWriter object en gson
        FileWriter writer = new FileWriter(file);
        gson.toJson(Resultaat.alleResultaten, writer);

        // Sluit de FileWriter
        writer.flush();
        writer.close();
    }

    public static void slaOp(ArrayList<Object> object, String fileName) throws IOException {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        boolean bestaat = new File(file).exists();
        if(!bestaat){
            return;
        }

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
        
        boolean bestaat = new File(file).exists();
        if(!bestaat){
            return null;
        }

        // Lees de file met een FileReader object en gson
        Reader reader = new FileReader(file);

        return gson.fromJson(reader, JsonArray.class);
    }

    public static ArrayList<Student> haalStudentenOp() throws FileNotFoundException {
        JsonArray jsonArray = haalJsonArrayOp( "student.json");
        ArrayList<Student> studenten = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            JsonElement nummerJsonElement = jsonObject.get("studentNummer");
            JsonElement naamJsonElement = jsonObject.get("naam");

            int nummer = -1; // -1 betekent niet gevonden
            String naam = null;
            if(nummerJsonElement!=null) {
                nummer = nummerJsonElement.getAsInt();
            }
            if(naamJsonElement!=null) {
                naam = jsonObject.get("naam").getAsString();
            }

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
            JsonElement cijferJsonEelement = jsonObject.get("cijfer");

            double cijfer = -1; // -1 betekent bestaat niet
            if(cijferJsonEelement!=null){
                cijfer = cijferJsonEelement.getAsDouble();
            }

            JsonObject studentJsonObj = (JsonObject) jsonObject.get("student");
            Student student = haalStudentOp(studentJsonObj.get("studentNummer").getAsInt());

            JsonObject examenJsonObj = (JsonObject) jsonObject.get("examen");
            Examen examen = Examen.getExamenFromCode(examenJsonObj.get("examenCode").getAsString());

            Resultaat resultaat = new Resultaat(student, examen, cijfer);
            resultaten.add(resultaat);
        }

        return resultaten;
    }
}
