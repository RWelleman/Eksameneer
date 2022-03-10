package nl.hhs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Examen {
    public ArrayList<Vraag> vragen;
    public ArrayList<Student> studenten;
    public Vak vak;

    public Resultaat neemAf(Student student){
        Resultaat resultaat = new Resultaat();
        return resultaat;
    }
}