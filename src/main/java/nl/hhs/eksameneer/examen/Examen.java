package nl.hhs.eksameneer.examen;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.jsonHandler.JsonHandler;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.MeerkeuzeVraag;
import nl.hhs.eksameneer.vraag.OpenVraag;
import nl.hhs.eksameneer.vraag.Vraag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Examen {
    private final String examenCode;
    private final ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    public static ArrayList<Examen> alleExamen = new ArrayList<>();
    public static int vraagnummer = 0;

    public static Scanner scanner = new Scanner(System.in);

    public Examen(ArrayList<Vraag> vragen, String examenCode) {
        this.vragen = vragen;
        this.examenCode = examenCode;
        if (vragen != null && examenCode != null) alleExamen.add(this);
    }

    public static ArrayList<Examen> getAlleExamen() {
        return alleExamen;
    }

    public static void setAlleExamen(ArrayList<Examen> alleExamen) {
        Examen.alleExamen = alleExamen;
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }


    // Rick - toegevoegt 2.	Toon tijdens het maken van een examen het juiste antwoord-
    // wanneer een student een fout antwoord geeft.
    // De vragen worden steeds op andere volgorde gevraagd
    public Resultaat neemAf(Student student) {
        if (student == null) return null;

        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(vragen);

        for (Vraag vraag : vragen) {
            System.out.println(vraag.getInhoud());
            Antwoord antwoord = new Antwoord();
            antwoord.setInput(scanner.next());
            vraag.setAntwoord(antwoord);

            antwoord = vraag.controleer();
            if (antwoord.isGoed()) {
                System.out.println("antwoord is goed!");
            }
            else {
                System.out.println("Antwoord is fout het correcte antwoord is: " + vraag.getCorrecteAntwoord());
            }


        }

        double cijfer = 1;

        int correct = 0;
        for (Vraag vraag : vragen) {
            Antwoord antwoord = vraag.controleer();
            correct += antwoord.isGoed() ? 1 : 0;
        }
        cijfer = correct / (double) vragen.size() * 9 + 1;

        Resultaat resultaat = new Resultaat(student, this, cijfer);
        Resultaat.alleResultaten.add(resultaat);
        JsonHandler.slaResultatenOp();

        return resultaat;
    }

    public String getExamenCode() {
        return examenCode;
    }

    public static Examen getExamenFromCode(String examenCode) {
        for (Examen examen : alleExamen) {
            if (examen.getExamenCode().equals(examenCode)) {
                return examen;
            }
        }

        return null;
    }


    // Rick 4.	Het is mogelijk tijdens het uitvoeren van het programma nieuwe examens en vragen toe te voegen.
    public static void newexamen() {

        ArrayList<Vraag> vragendrie = new ArrayList<>();
        boolean finishx = false;

        while (finishx == false) {
            System.out.println("gesloten of open vraag? g/o");
            String keuzevraag = scanner.nextLine();

            if (keuzevraag.equals("g")){
                System.out.println("Vraag:");
                String inhoud = scanner.nextLine();

                System.out.println("typ Ja of Nee let op hoofdletter");
                System.out.println("antwoord: ");
                String Antwoord = scanner.nextLine();
                vragendrie.add(new GeslotenVraag(inhoud, Antwoord));
            }
            else if (keuzevraag.equals("o")) {
                System.out.println("Vraag:");
                String inhoud = scanner.nextLine();

                System.out.println("antwoord: ");
                String Antwoord = scanner.nextLine();
                vragendrie.add(new OpenVraag(inhoud, Antwoord));
            }

            System.out.println("klaar? j/n");
            String finish = scanner.nextLine();

            if (finish.equals("j")){
                finishx = true;
            }
        }
        System.out.println("geef naam aan het examen: ");
        String examennaam = scanner.nextLine();
        new Examen(vragendrie, examennaam);
    }
}
