package nl.hhs;

import java.util.ArrayList;

public class Examen {
    private String examenCode;
    private ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    private static ArrayList<Examen> alleExamen = new ArrayList<Examen>();

    public Examen(ArrayList<Vraag> vragen, String examenCode) {
        this.vragen = vragen;
        this.examenCode = examenCode;
        alleExamen.add(this);
    }

    // Overload
    public Examen(String examenCode) {
        this.examenCode = examenCode;
        alleExamen.add(this);
    }

    public void maakVraag(Vraag vraag){

    }

    public void verwijderVraag(Vraag vraag){

    }

    public static ArrayList<Examen> getAlleExamen(){
        return alleExamen;
    }

    public Resultaat neemAf(Student student){
        Resultaat resultaat = new Resultaat(student, this, 5.0);
        return resultaat;
    }

    public String getExamenCode() {
        return examenCode;
    }

    public void setExamenCode(String examenCode) {
        this.examenCode = examenCode;
    }
}

// test