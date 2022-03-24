package nl.hhs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here //
        Scanner scanner = new Scanner(System.in);

        // De vragen moeten aangemaakt worden
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Werkt dit examen?", "Nee"));
        // Examen aangemaakt worden
        Examen werkExamen = new Examen(vragen, "Werkend examen");

        // Student aanmaken
        System.out.print("Geef je naam: ");
        String naam = scanner.nextLine();
        System.out.print("Geef je studentnummer: ");
        int studentNummer = scanner.nextInt();
        Student student = new Student(studentNummer, naam);

        // Neem het examen af
        werkExamen.neemAf(student);
    }
}
