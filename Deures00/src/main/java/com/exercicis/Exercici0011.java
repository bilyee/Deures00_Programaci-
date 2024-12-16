package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {

        if (quantitat > noms.size()) {
            System.out.println("La quantitat no pot ser més gran que " + noms.size() + ".");
        }

        ArrayList<String> nombres = new ArrayList<>();
        Random random = new Random();

        ArrayList<String> copiaNoms = new ArrayList<>(noms);
        for (int i = 0; i < quantitat; i++) {
            if (copiaNoms.isEmpty()) {
                break;
            }
            int index = random.nextInt(copiaNoms.size());
            nombres.add(copiaNoms.remove(index));
        }
        return new ArrayList<>();
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        /*
            TODO: Resol aquí la funció
        */
        return new ArrayList<>();
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        /*
            TODO: Resol aquí la funció
        */
        return new ArrayList<>();
    }

    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

        /*
            TODO: Resol aquí l'exercici
        */
    }
}
