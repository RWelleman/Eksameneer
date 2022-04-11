package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.resultaat.Resultaat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private int studentNummer;
    private String naam;
    private ArrayList<Resultaat> behaaldeExamens;
    private ArrayList<Resultaat> resultaten = new ArrayList<>();

    // ArrayList van alle studenten
    public static ArrayList<Student> alleStudenten = new ArrayList<>();

    public Student(int studentNummer, String naam){
        this.studentNummer = studentNummer;
        this.naam = naam;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Resultaat> getBehaaldeExamens() {

        if (behaaldeExamens == null) {
            System.out.println(getStudentNummer() + " Heeft nog geen examens gehaald.");
        }

        return behaaldeExamens;
    }

    public void setBehaaldeExamens(ArrayList<Resultaat> behaaldeExamens) {
        List<Resultaat> nieuweLijst = behaaldeExamens.stream().filter(r -> r.getCijfer() > 5.5).collect(Collectors.toList());
        if (nieuweLijst == null){
            this.behaaldeExamens = null;
        }
        this.behaaldeExamens.addAll(nieuweLijst);
    }
}