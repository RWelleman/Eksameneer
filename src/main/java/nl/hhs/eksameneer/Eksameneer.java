package nl.hhs.eksameneer;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.jsonHandler.JsonHandler;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.MeerkeuzeVraag;
import nl.hhs.eksameneer.vraag.OpenVraag;
import nl.hhs.eksameneer.vraag.Vraag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Eksameneer {

    // ingelogde student op client
    public static Student student = null;
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
            System.out.println("(6) Welke student heeft de meeste examens gehaald?");
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
                case 6 -> meestBehaaldeResultaat();
                case 0 -> {
                    System.out.println("exit");
                    System.exit(0);
                }
            }
        }

    }

    private static void registerExamens() {
        // ArrayLists van Vragen die bij alle examens
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Zitten wij in Den Haag?", "Ja"));
        vragen.add(new GeslotenVraag("Zit de HHS alleen in Den Haag", "Nee"));
        vragen.add(new OpenVraag("Wat studeer je (geef de afkorting)?", "SE"));
        vragen.add(new OpenVraag("Noem de 4e grootste stad in Nederland", "Utrecht"));

        ArrayList<Vraag> vragenTwee = new ArrayList<>();
        vragenTwee.add(new OpenVraag("Stel dat auto 1 door rood rijdt. Hoe hoog is de boete in €", "150"));
        vragenTwee.add(new OpenVraag("Als er op een weg een maximale snelheid van 100 km/u geldt, hoe snel mag je rijden?", "100"));
        vragenTwee.add(new GeslotenVraag("Is het slim om ooit de hoogte van je voertuig te meten en te onthouden zodat je niet tegen een brug aankomt", "Ja"));

        // Examens aanmaken met die ArrayLists als parameter
        new Examen(vragen, "Haagse Hogeschool");
        new Examen(vragenTwee, "Rijexamen");
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
