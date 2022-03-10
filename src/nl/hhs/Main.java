package nl.hhs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1) Lijst van examens");
        System.out.println("2) Lijst met studenten");

        int gekozen = scanner.nextInt();
        System.out.println("gebruiker heeft voor optie " + gekozen + " gekozen");
    }
}
