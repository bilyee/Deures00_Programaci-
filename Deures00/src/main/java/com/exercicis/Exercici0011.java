package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {

        if (quantitat > noms.size()) {
            throw new IllegalArgumentException("La quantitat no pot ser més gran que " + noms.size() + ".");
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
        return nombres;
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        ArrayList<String> nomsVocals = new ArrayList<>();
        for (String nom : noms) {
            char ultimaLetra = nom.toLowerCase().charAt(nom.length() - 1);
            if ("aeiou".indexOf(ultimaLetra) >= 0) {
                nomsVocals.add(nom);
            }
        }
        return nomsVocals;
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        ArrayList<String> nomsCompostos = new ArrayList<>();
        for (String nom : noms) {
            if (nom.contains(" ")) {
                nomsCompostos.add(nom);
            }
        }
        return nomsCompostos;
    }

    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(Arrays.asList("Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"));

        ArrayList<String> nomsAleatoris = escullNomsAleatoris(noms, 5);
        System.out.println("Noms escollits a l'atzar: " + nomsAleatoris);
        try {
            ArrayList<String> seleccionatsError = escullNomsAleatoris(noms, 25);
            System.out.println("Noms escollits: " + seleccionatsError);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<String> nomsVocal = nomsAcabenVocal(noms);
        System.out.println("Noms que acaben amb vocal: " + nomsVocal);

        ArrayList<String> nomsCompostos = nomsCompostos(noms);
        System.out.println("Noms compostos: " + nomsCompostos);
    }
}
