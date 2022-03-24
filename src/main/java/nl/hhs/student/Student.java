package nl.hhs.student;

import nl.hhs.resultaat.Resultaat;

import java.util.ArrayList;

public class Student {
    private int studentNummer;
    private String naam;
    private ArrayList<Resultaat> resultaten;

    public Student(int studentNummer, String naam){
        this.studentNummer = studentNummer;
        this.naam = naam;
    }
}