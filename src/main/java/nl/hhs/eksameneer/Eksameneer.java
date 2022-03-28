package nl.hhs.eksameneer;

import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.vraag.GeslotenVraag;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Eksameneer {
    public static void toonMenu(){
        System.out.println("== Menu ==");
        System.out.println("1) Selecteer een examen");
        System.out.println("0) Exit");
        System.out.println("====");
    }

    public static void main(String[] args) {
        // write your code here //
        Scanner scanner = new Scanner(System.in);


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
                case 3 -> System.out.println("nummer 3 is gekozen");
                case 4 -> System.out.println("nummer 4 is gekozen");
                case 5 -> System.out.println("nummer 5 is gekozen");
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
}
