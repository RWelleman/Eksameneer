package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.Eksameneer;
import nl.hhs.eksameneer.jsonHandler.JsonHandler;
import nl.hhs.eksameneer.resultaat.Resultaat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private final int studentNummer;
    private final String naam;
    private ArrayList<Resultaat> behaaldeExamens;
    private final ArrayList<Resultaat> resultaten = new ArrayList<>();


    // ArrayList van alle studenten
    public static ArrayList<Student> alleStudenten = new ArrayList<>();

    public Student(int studentNummer, String naam) {
        this.studentNummer = studentNummer;
        this.naam = naam;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Resultaat> getBehaaldeExamens() {
        return behaaldeExamens;
    }

    public void setBehaaldeExamens(ArrayList<Resultaat> behaaldeExamens) {
        List<Resultaat> nieuweLijst = behaaldeExamens.stream().filter(r -> r.getCijfer() > 5.5).toList();

        this.behaaldeExamens = new ArrayList<>(nieuweLijst);
    }


    public static boolean isLoggedIn(Student student) {
        return student != null;
    }

    public static void loginStudent() {
        Scanner scanner = new Scanner(System.in);

        // Student aanmaken
        System.out.println("Geef je studentnummer: ");
        int studentNummer = scanner.nextInt();

        Student student = JsonHandler.haalStudentOp(studentNummer);

        if (student == null) {
            System.out.println("Geef je naam: ");
            String naam = scanner.next();
            student = new Student(studentNummer, naam);
            JsonHandler.slaStudentenOp();
        }

        Eksameneer.student = student;
        System.out.println("Ingelogd als " + student.getNaam());
        Student.alleStudenten.add(student);
    }

    @Override
    public String toString() {
        return naam + " (" + studentNummer + ")";
    }
}