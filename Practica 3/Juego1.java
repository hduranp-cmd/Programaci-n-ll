package com.mycompany.juego1;

import java.util.Scanner;

class Juego {

    private int numeroDeVidas;
    private int record;

    public Juego(int numeroDeVidas, int record) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = record;
    }

    protected void reiniciaPartida() {
    }

    protected void actualizaRecord(int nuevoRecord) {
        this.record = nuevoRecord;
    }

    protected Boolean quitaVida() {
        this.numeroDeVidas = this.numeroDeVidas - 1;
        if (this.numeroDeVidas <= 0) {
            return false;
        }
        return true;
    }

    public int getRecord() {
        return record;
    }
}

class JuegoAdivinaNumero extends Juego {

    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas, 0);
    }

    public void juega() {
        Scanner u = new Scanner(System.in);

        super.reiniciaPartida();

        this.numeroAAdivinar = (int) (Math.random() * 11);

        System.out.println("Adivine un número del 0 al 10:");
        int intento = u.nextInt();

        if (intento == this.numeroAAdivinar) {
            System.out.println("¡Acertaste!!");
            super.actualizaRecord(super.getRecord() + 1);
            return;
        } else {
            boolean quedanVidas = super.quitaVida();

            while (quedanVidas) {
                if (this.numeroAAdivinar > intento) {
                    System.out.println("El número a adivinar es MAYOR. Intenta de nuevo:");
                } else {
                    System.out.println("El número a adivinar es MENOR. Intenta de nuevo:");
                }

                intento = u.nextInt();

                if (intento == this.numeroAAdivinar) {
                    System.out.println("¡Acertaste!!");
                    super.actualizaRecord(super.getRecord() + 1);
                    return;
                } else {
                    quedanVidas = super.quitaVida();
                }
            }

            System.out.println("Ya no te quedan más vidas.");
        }
    }
}

public class Juego1 {

    public static void main(String[] args) {
        JuegoAdivinaNumero jueg1 = new JuegoAdivinaNumero(5);
        jueg1.juega();
    }
}