package com.exercicis;

import java.util.Locale;

public class Exercici0006 {

    public static double calculaEntrada(int numeroAdults, int numNens, int numGrans, String dia) {
        Double preuAdults = 10.0;
        Double preuNens = 5.0;
        Double preuGrans = 6.0;

        // Preu estandart
        Double preuEstandart = (numeroAdults * preuAdults) + (numNens * preuNens) + (numGrans * preuGrans);

        if (dia.equals("dimarts")) {
            preuEstandart *= 0.8;
        }

        else if (dia.equals("dijous") && numNens > 0 && numeroAdults > 0) {
            preuEstandart -= preuNens * 0.5;
            preuEstandart -= preuNens * (numNens - 1);
        }

        return preuEstandart;
    }

    public static void main(String[] args) {

        String template = "%-35s%.2f€";

        System.out.println(String.format(Locale.US, template, "Cas 1 (2 adults, 2 nens, 1 gran): ", calculaEntrada(2, 2, 1, "dimarts")));
        
    }
}
