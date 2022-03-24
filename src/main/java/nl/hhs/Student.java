package nl.hhs;

import java.util.ArrayList;

public class Student {
    private int studentNummer;
    private String naam;
    private ArrayList<Resultaat> behaaldeExamens;

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
        return behaaldeExamens;
    }
}