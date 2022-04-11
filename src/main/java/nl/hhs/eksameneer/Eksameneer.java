package nl.hhs.eksameneer;

import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.jsonHandler.JsonHandler;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.Vraag;
import java.util.ArrayList;
import java.util.Scanner;

public class Eksameneer {
    // ArrayList van alle studenten
    static ArrayList<Student> studenten;

    // ingelogde student op client
    static Student student = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here //
        Scanner scanner = new Scanner(System.in);

        registerExamens();

        int keuze;

        while (true) {
            System.out.println("Menu");
            System.out.println("(1) Lijst met examens.");
            System.out.println("(2) Lijst met studenten.");
            System.out.println("(3) Nieuwe student inschrijven.");
            System.out.println("(4) Student verwijderen.");
            System.out.println("(5) Examen afnemen.");
            System.out.println("(6) Is student geslaagd voor test?");
            System.out.println("(7) Welke examens heeft student gehaald?");
            System.out.println("(8) Welke student heeft de meeste examens gehaald?");
            System.out.println("(0) Exit.");
            System.out.print("Uw keuze:");
            keuze = scanner.nextInt();

            switch (keuze) {
                case 1 -> {
                  ArrayList<Examen> alleExamen = Examen.alleExamen;
                    System.out.println("== Selecteer een examen ==");
                    for(int i = 0; i < alleExamen.size(); i++){
                        System.out.println(i+1 + ") " + alleExamen.get(i).getExamenCode());
                    }
                    System.out.println("0) Terug naar menu");
                    System.out.println("====");

                    int examenOptie = scanner.nextInt();
                    if(examenOptie == 0){
                        break;
                    }else {
                        Examen gekozenExamen = alleExamen.get(examenOptie-1);
                        ArrayList<Vraag> vragen = gekozenExamen.getVragen();
                        System.out.println("== Vragen van Examen: " + gekozenExamen.getExamenCode() + " ==");

                        for (int j = 0; j < vragen.size() ; j++){
                            System.out.println(j + ". " + vragen.get(j).getInhoud());
                        }
                    }

                    break;
                }
                case 2 -> System.out.println("nummer 2 is gekozen");
                case 3 -> loginStudent();
                case 4 -> System.out.println("nummer 4 is gekozen");
                case 5 -> {
                    if(isLoggedIn(student)) {
                        System.out.println("Welk examen wil je afnemen? (getal)");
                        int selectedExam = scanner.nextInt();
                        Resultaat resultaat = Examen.alleExamen.get(selectedExam - 1).neemAf(student);
                        System.out.println(resultaat.getCijfer());
                    } else {
                        loginStudent();
                    }
                }
                case 6 -> System.out.println("nummer 6 is gekozen");
                case 7 -> System.out.println("nummer 7 is gekozen");
                case 8 -> System.out.println("nummer 8 is gekozen");
                case 0 -> {
                    System.out.println("exit");
                    System.exit(0);
                }
            }
        }

    }

    private static void registerExamens() {
        // De vragen moeten aangemaakt worden
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Werkt dit examen?", "Nee"));
        // Examen aangemaakt worden
        new Examen(vragen, "Werkend examen");
    }

    static boolean isLoggedIn(Student student) {
        return student != null;
    }

    static void loginStudent() {
        // Student aanmaken
        System.out.println("Geef je naam: ");
        String naam = scanner.next();
        System.out.println("Geef je studentnummer: ");
        int studentNummer = scanner.nextInt();
        boolean bestaatAl = true;
        while(bestaatAl){
            boolean gevonden = false;
            for(int i = 0; i < studenten.size() ; i++){
                Student s = studenten.get(i);
                if(s.getStudentNummer() == studentNummer){
                    gevonden = true;
                }
            }

            if(gevonden){
                System.out.println("Studentnummer bestaat al! Geef een nieuwe studentnumer op:");
                studentNummer = scanner.nextInt();
            }else{
                bestaatAl = false;
            }
        }

        student = new Student(studentNummer, naam);
        studenten.add(student);

        System.out.println("Ingelogd als " + naam);
    }
}
