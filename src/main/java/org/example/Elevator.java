package org.example;
import java.util.Random;

public class Elevator{

    Random random = new Random();
    private int pisoActual;
    private int pisoDestino;
    private boolean enMovimiento;
    private boolean lleno;

    public Elevator() {
        pisoActual = 1;
    }

    public void llamarAscensor(int destino) {
        enMovimiento = true;
        pisoDestino = destino;
    }

    public void recogerPersona(int nuevoDestino) {
        enMovimiento = true;
        lleno = true;
        pisoActual = pisoDestino;
        pisoDestino = nuevoDestino;
    }

    public void dejarPersona() {
        enMovimiento = false;
        lleno = false;
        pisoActual = pisoDestino;
    }

    public Person crearPersona() {
        return new Person();
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public boolean isLleno() {
        return lleno;
    }
}
