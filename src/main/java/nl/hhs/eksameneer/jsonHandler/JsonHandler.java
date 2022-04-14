package nl.hhs.eksameneer.jsonHandler;

import com.google.gson.*;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonHandler {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void initialiseer() {
        Student.alleStudenten = haalStudentenOp();
        Resultaat.alleResultaten = haalResultatenOp();
    }

    /**
     * @param objects  ArrayList of all objects to be stored into the json file
     * @param fileName name of the JSON file to store data objects in
     */
    public static boolean slaOp(ArrayList<Object> objects, String fileName) {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        if (!new File(file).exists()) {
            return false;
        }

        // Schrijf naar de file met een FileWriter object en gson
        try {
            FileWriter writer = new FileWriter(file);
            gson.toJson(objects, writer);

            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean slaStudentenOp() {
        List<Object> studentList = Student.alleStudenten.stream().map(student -> (Object) student).toList();
        ArrayList<Object> students = new ArrayList<>(studentList);
        return slaOp(students, "student.json");
    }

    public static boolean slaResultatenOp() {
        List<Object> resultaatList = Resultaat.alleResultaten.stream().map(resultaat -> (Object) resultaat).toList();
        ArrayList<Object> resultaten = new ArrayList<>(resultaatList);
        return slaOp(resultaten, "resultaat.json");
    }

    /**
     * @param fileName the file to be fetched data from
     * @return a JsonArray filled with the json data from given file
     */
    private static JsonArray haalJsonArrayOp(String fileName) {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main/resources/storage/" + fileName);

        if (!new File(file).exists()) {
            return null;
        }

        // Lees de file met een FileReader object en gson
        try {
            Reader reader = new FileReader(file);
            return gson.fromJson(reader, JsonArray.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Student> haalStudentenOp() {
        JsonArray jsonArray = haalJsonArrayOp("student.json");
        ArrayList<Student> studenten = new ArrayList<>();

        if (jsonArray == null) {
            return studenten;
        }

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            JsonElement nummerJsonElement = jsonObject.get("studentNummer");
            JsonElement naamJsonElement = jsonObject.get("naam");


            int nummer = -1; // -1 betekent niet gevonden
            String naam = null;
            if (nummerJsonElement != null) {
                nummer = nummerJsonElement.getAsInt();
            }
            if (naamJsonElement != null) {
                naam = jsonObject.get("naam").getAsString();
            }

            if (nummer != -1) {
                Student student = new Student(nummer, naam);
                student.setBehaaldeExamens(haalResultatenOp(nummer));
                studenten.add(student);
            }
        }

        return studenten;
    }

    public static Student haalStudentOp(int studentNummer) {
        ArrayList<Student> opgehaaldeStudenten = haalStudentenOp();

        for (Student student : opgehaaldeStudenten) {
            if (student.getStudentNummer() == studentNummer) {
                return student;
            }
        }

        return null;
    }

    public static Resultaat haalResultaatOp(int studentNummer, String examenCode) {

        ArrayList<Resultaat> opgehaaldeResultaten = haalResultatenOp();
        for (Resultaat resultaat : opgehaaldeResultaten) {
            if(resultaat.getExamen() == null){
                continue;
            }
            if (resultaat.getStudent().getStudentNummer() == studentNummer && Objects.equals(resultaat.getExamen().getExamenCode(), examenCode)) {
                return resultaat;
            }
        }

        return null;
    }

    public static ArrayList<Resultaat> haalResultatenOp() {
        JsonArray jsonArray = haalJsonArrayOp("resultaat.json");
        ArrayList<Resultaat> resultaten = new ArrayList<>();

        if (jsonArray == null) {
            return resultaten;
        }

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            JsonElement cijferJsonEelement = jsonObject.get("cijfer");

            double cijfer = -1; // -1 betekent bestaat niet
            if (cijferJsonEelement != null) {
                cijfer = cijferJsonEelement.getAsDouble();
            }

            JsonObject studentJsonObj = (JsonObject) jsonObject.get("student");
            Student student = haalStudentOp(studentJsonObj.get("studentNummer").getAsInt());

            JsonObject examenJsonObj = (JsonObject) jsonObject.get("examen");
            if(examenJsonObj == null){ continue; }
            Examen examen = Examen.getExamenFromCode(examenJsonObj.get("examenCode").getAsString());

            Resultaat resultaat = new Resultaat(student, examen, cijfer);
            resultaten.add(resultaat);
        }

        return resultaten;
    }

    public static ArrayList<Resultaat> haalResultatenOp(int studentNummer) {
        JsonArray jsonArray = haalJsonArrayOp("resultaat.json");
        ArrayList<Resultaat> resultaten = new ArrayList<>();

        if (jsonArray == null) {
            return resultaten;
        }

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            JsonElement cijferJsonEelement = jsonObject.get("cijfer");

            double cijfer = -1; // -1 betekent bestaat niet
            if (cijferJsonEelement != null) {
                cijfer = cijferJsonEelement.getAsDouble();
            }

            JsonObject studentJsonObj = (JsonObject) jsonObject.get("student");
            if(studentJsonObj.get("studentNummer").getAsInt() != studentNummer) continue;
            Student student = new Student(-1, null);

            JsonObject examenJsonObj = (JsonObject) jsonObject.get("examen");
            if(examenJsonObj == null){ continue; }
            Examen examen = Examen.getExamenFromCode(examenJsonObj.get("examenCode").getAsString());

            Resultaat resultaat = new Resultaat(student, examen, cijfer);
            resultaten.add(resultaat);
        }

        return resultaten;
    }
}
