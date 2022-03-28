package nl.hhs.eksameneer;

import java.util.Scanner;

public class Eksameneer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        static Student student = null;
        static Scanner scanner = new Scanner(System.in);

        int keuze = -1;

        while (keuze != 0) {
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
                case 1 -> System.out.println("nummer 1 is gekozen");
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


        registerExamens();

        // write your code here //
        int keuze= -1;
        while (keuze!=0) {
            System.out.print("Uw keuze:");
            System.out.println();
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
        student = new Student(studentNummer, naam);
        System.out.println("Ingelogd als " + naam);
    }
}
