package nl.hhs;

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