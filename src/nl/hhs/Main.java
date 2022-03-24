package nl.hhs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void toonMenu(){
        System.out.println("== Menu ==");
        System.out.println("1) Voeg examen toe");
        System.out.println("2) Toon alle examens");
        System.out.println("0) Exit");
        System.out.println("====");
    }

    public static void main(String[] args) {
        // write your code here //
        Scanner scanner = new Scanner(System.in);

        toonMenu();
        int gekozen = scanner.nextInt();
        while(gekozen != 0){
            switch(gekozen) {
                case 1:
                    System.out.println("Kies een code");
                    String examenCode = scanner.next();
                    new Examen(examenCode);
                    break;
                case 2:
                    ArrayList<Examen> alleExamen = Examen.getAlleExamen();
                    System.out.println("====");
                    for(int i = 0; i< alleExamen.size(); i++){
                        System.out.println(alleExamen.get(i).getExamenCode());
                    }
                    System.out.println("====");

                    break;
            }
            toonMenu();
            gekozen = scanner.nextInt();
        };
        //Examen nieuweExamen = new Examen();
    }
}
