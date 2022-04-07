package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.resultaat.Resultaat;

import java.util.ArrayList;

public class Student {
    private int studentNummer;
    private String naam;
    private ArrayList<Resultaat> resultaten;

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

    public ArrayList<Resultaat> getResultaten() {
        return resultaten;
    }
}