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

        toonMenu();
        int gekozen = scanner.nextInt();
        while(gekozen != 0){
            switch(gekozen) {
                case 1:
                    ArrayList<Examen> alleExamen = Examen.getAlleExamen();
                    System.out.println("== Selecteer een examen ==");
                    for(int i = 0; i< alleExamen.size(); i++){
                        System.out.println(i+1 + ") " + alleExamen.get(i).getExamenCode());
                    }
                    System.out.println("0) Terug naar menu");
                    System.out.println("====");

                    int examenOptie = scanner.nextInt();
                    if(examenOptie == 0){
                        break;
                    }

                    break;
            }
            toonMenu();
            gekozen = scanner.nextInt();
        };
        //Examen nieuweExamen = new Examen();
    }
}
