package nl.hhs;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    private String examenCode;
    private ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    public static ArrayList<Examen> alleExamen = new ArrayList<>();

    public Examen(ArrayList<Vraag> vragen, String examenCode) {
        this.vragen = vragen;
        this.examenCode = examenCode;
        alleExamen.add(this);
    }

    public void maakVraag(Vraag vraag){

    }

    public void verwijderVraag(Vraag vraag){

    }

    public Resultaat neemAf(Student student){
        Scanner scanner = new Scanner(System.in);

        for (Vraag vraag : vragen) {
            System.out.println(vraag.getInhoud());
            Antwoord antwoord = new Antwoord(scanner.next());
            vraag.setAntwoord(antwoord);
        }

        double cijfer = 1;

        System.out.println("Lever examen in? (j/n)");
        String jn = scanner.next();
        if(jn.equals("j")) {
            int correct = 0;
            for (Vraag vraag : vragen) {
                Antwoord antwoord = vraag.controleer();
                correct += antwoord.isGoed() ? 1 : 0;
            }
            cijfer = correct / vragen.size() * 9 + 1;
            System.out.println(vragen.size());
            System.out.println(correct);
            System.out.println(cijfer);
        }

        return new Resultaat(student, this, cijfer);
    }
}

// test