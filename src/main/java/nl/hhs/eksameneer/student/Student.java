package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.JsonStorable;
import nl.hhs.eksameneer.resultaat.Resultaat;

import java.util.ArrayList;

public class Student implements JsonStorable {
    private int studentNummer;
    private String naam;
    private ArrayList<Resultaat> resultaten;

    public Student(int studentNummer, String naam){
        this.studentNummer = studentNummer;
        this.naam = naam;
    }
}