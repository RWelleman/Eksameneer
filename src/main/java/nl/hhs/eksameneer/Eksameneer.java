package nl.hhs.eksameneer;

import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.MeerkeuzeVraag;
import nl.hhs.eksameneer.vraag.OpenVraag;
import nl.hhs.eksameneer.vraag.Vraag;
import java.util.ArrayList;
import java.util.Scanner;

public class Eksameneer {
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
        // GS EXAMEN
        ArrayList<Vraag> geschiedenisVragen = new ArrayList<>();
        geschiedenisVragen.add(new GeslotenVraag("Was Hitler geëxecuteerd?", "Nee"));
        ArrayList<String> mogelijkeAntwoordenGS = new ArrayList<>();
        mogelijkeAntwoordenGS.add("Italie en Nederland");
        mogelijkeAntwoordenGS.add("Italie, Duitsland en Japan");
        mogelijkeAntwoordenGS.add("Duitsland en Japan");
        mogelijkeAntwoordenGS.add("Japan, Italie, Turkije en Duitsland");
        geschiedenisVragen.add(new MeerkeuzeVraag("Welke landen werkte samen in de tweede wereldoorlog?", "2", mogelijkeAntwoordenGS));
        geschiedenisVragen.add(new OpenVraag("Wat gebeurde er tussen 1941 en 1945?","De tweede wereldoorlog vond plaats." ));
        // BE EXAMEN
        ArrayList<Vraag> bedrijfseconomieVragen = new ArrayList<>();
        bedrijfseconomieVragen.add(new GeslotenVraag("Debiteuren moeten jou nog geld geven?", "Ja"));
        ArrayList<String> mogelijkeAntwoordenBE = new ArrayList<>();
        mogelijkeAntwoordenBE.add("€25,-");
        mogelijkeAntwoordenBE.add("€15,-");
        mogelijkeAntwoordenBE.add("€7,50");
        mogelijkeAntwoordenBE.add("€5,-");
        bedrijfseconomieVragen.add(new MeerkeuzeVraag("Jan koopt 50 appels in voor €0.20. Zijn vaste kosten zijn €10,-. Hij verkoopt een set van 2 appels voor €1,-. Wat is zijn netto winst?", "4", mogelijkeAntwoordenBE));
        bedrijfseconomieVragen.add(new OpenVraag("Wat zijn journaalposten?","Een journaalpost geeft aan of een post credit of debit is. " ));
        // BIO EXAMEN
        ArrayList<Vraag> biologieVragen = new ArrayList<>();
        biologieVragen.add(new GeslotenVraag("Is een mens een organisme?", "Ja"));
        ArrayList<String> mogelijkeAntwoordenBIO = new ArrayList<>();
        mogelijkeAntwoordenBIO.add("Vagina");
        mogelijkeAntwoordenBIO.add("Erectus");
        mogelijkeAntwoordenBIO.add("Penis");
        mogelijkeAntwoordenBIO.add("Anus");
        biologieVragen.add(new MeerkeuzeVraag("Hoe wordt het mannelijke geslachtsdeel genoemd?", "3", mogelijkeAntwoordenBIO));
        biologieVragen.add(new OpenVraag("Wat is fotosynthese?"," Fotosynthese is het proces waarbij planten de koolstofdioxide opnemen om zo te groeien en zuurstof te produceren " ));
        // Examen aangemaakt worden
        new Examen(geschiedenisVragen, "42069");
        new Examen(bedrijfseconomieVragen, "11111");
        new Examen(biologieVragen, "99999");
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
