package nl.hhs.eksameneer;

import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.jsonHandler.JsonHandler;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.Vraag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Eksameneer {

    // ingelogde student op client
    static Student student = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here //
        JsonHandler.initialiseer();

        Scanner scanner = new Scanner(System.in);

        registerExamens();

        int keuze;

        while (true) {
            System.out.println("Menu");
            System.out.println("(1) Lijst met examens.");
            System.out.println("(2) Lijst met studenten.");
            System.out.println("(3) Nieuwe student inschrijven.");
            System.out.println("(4) Examen afnemen.");
            System.out.println("(5) Is student geslaagd voor test?");
            System.out.println("(6) Welke examens heeft student gehaald?");
            System.out.println("(7) Welke student heeft de meeste examens gehaald?");
            System.out.println("(0) Exit.");
            System.out.print("Uw keuze:");
            keuze = scanner.nextInt();

            switch (keuze) {
                case 1 -> {
                    ArrayList<Examen> alleExamen = Examen.alleExamen;
                    System.out.println("== Selecteer een examen ==");
                    for (int i = 0; i < alleExamen.size(); i++) {
                        System.out.println(i + 1 + ") " + alleExamen.get(i).getExamenCode());
                    }
                    System.out.println("0) Terug naar menu");
                    System.out.println("====");

                    int examenOptie = scanner.nextInt();
                    if (examenOptie != 0) {
                        Examen gekozenExamen = alleExamen.get(examenOptie - 1);
                        ArrayList<Vraag> vragen = gekozenExamen.getVragen();
                        System.out.println("== Vragen van Examen: " + gekozenExamen.getExamenCode() + " ==");

                        for (int j = 0; j < vragen.size(); j++) {
                            System.out.println(j + ". " + vragen.get(j).getInhoud());
                        }
                    }
                }
                case 2 -> showStudents();
                case 3 -> Student.loginStudent();
                case 4 -> {
                    if (Student.isLoggedIn(student)) {
                        System.out.println("Welk examen wil je afnemen? (getal)");
                        int selectedExam = scanner.nextInt();
                        Resultaat resultaat = Examen.alleExamen.get(selectedExam - 1).neemAf(student);
                        System.out.println(resultaat.getCijfer());
                    } else {
                        Student.loginStudent();
                        System.out.println("Welk examen wil je afnemen? (getal)");
                        int selectedExam = scanner.nextInt();
                        Resultaat resultaat = Examen.alleExamen.get(selectedExam - 1).neemAf(student);
                        System.out.println(resultaat.getCijfer());
                    }
                }
                case 5 -> isStudentSuccessful();
                case 6 -> System.out.println("nummer 7 is gekozen");
                case 7 -> meestBehaaldeResultaat();
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

    private static void showStudents() {
        for (Student student : Student.alleStudenten) {
            System.out.println(student.toString());
        }
    }

    private static void isStudentSuccessful() {
        System.out.println("Studentnummer: ");
        int studentNummer = scanner.nextInt();
        System.out.println("Examencode: ");
        String examenCode = scanner.next();
        Resultaat resultaat = JsonHandler.haalResultaatOp(studentNummer, examenCode);

        if (resultaat != null) {
            boolean gehaald = resultaat.getCijfer() > 5.5;
            System.out.println("Student " + studentNummer + " heeft een " + resultaat.getCijfer() + " en het examen dus " + (gehaald ? "wel" : "niet") + " gehaald!");
        } else {
            System.out.println("Student " + studentNummer + " heeft dit examen niet gemaakt!");
        }

    }

    private static void meestBehaaldeResultaat() {
        System.out.println("Meest behaald examens");
        ArrayList<Student> studenten = JsonHandler.haalStudentenOp();

        Student highestScore = new Student(-1, "Niemand");
        highestScore.setBehaaldeExamens(new ArrayList<>());

        for (Student student : studenten) {
            if (student.getBehaaldeExamens() == null) continue;

            if (student.getBehaaldeExamens().size() > highestScore.getBehaaldeExamens().size()) {
                highestScore = student;
            }
        }

        System.out.println(highestScore.getNaam() + " heeft de meeste resultaten behaalt!");
    }
}
