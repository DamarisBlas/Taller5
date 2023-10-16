package org.example;

import java.util.Random;

public class Person {
    private int pisoOrigen;
    private int pisoDestino;
    private Random random = new Random();

    public Person() {
        generarPisosOrigenYDestino();
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public void setPisoOrigen(int pisoOrigen) {
        this.pisoOrigen = pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void generarPisosOrigenYDestino() {
        do {
            pisoOrigen = generarPisoAleatorio();
            pisoDestino = generarPisoAleatorio();
        } while (pisoOrigen == pisoDestino);
    }

    private int generarPisoAleatorio() {
        return random.nextInt(3) + 1;
    }
}
