package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.resultaat.Resultaat;

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

        if (behaaldeExamens == null) {
            System.out.println(getStudentNummer() + " Heeft nog geen examens gehaald.");
        }

        return behaaldeExamens;
    }

    public void setBehaaldeExamens(ArrayList<Resultaat> behaaldeExamens) {
        this.behaaldeExamens = behaaldeExamens;

    }
}