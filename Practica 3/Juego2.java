package com.mycompany.juego2;

import java.util.Scanner;

public class Juego2 {

    public static void main(String[] args) {
        JuegoAdivinaNumero ju1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar ju2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar ju3 = new JuegoAdivinaImpar(3);

        
        ju1.juega();

        
        ju2.juega();

        
        ju3.juega();
    }
}

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

    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas, 0);
    }

    public void juega() {
        Scanner u = new Scanner(System.in);
        super.reiniciaPartida();

        
        this.numeroAAdivinar = (int) (Math.random() * 11);

        System.out.println("Adivine un número del 0 al 10:");

        boolean quedanVidas = true;

        while (quedanVidas) {
            int intento = u.nextInt();

            
            if (validaNumero(intento)) {
                System.out.println("Intente de nuevo:");
            }

            if (intento == this.numeroAAdivinar) {
                System.out.println("¡Acertaste!!");
                super.actualizaRecord(super.getRecord() + 1);
            } else {
                quedanVidas = super.quitaVida();
                if (quedanVidas) {
                    if (this.numeroAAdivinar > intento) {
                        System.out.println("El número a adivinar es MAYOR. Intenta de nuevo:");
                    } else {
                        System.out.println("El número a adivinar es MENOR. Intenta de nuevo:");
                    }
                }
            }
        }

        System.out.println("Ya no te quedan más vidas");
    }

    public boolean validaNumero(int n) {
        if (n >= 0 && n <= 10) {
            return true;
        } else {
            System.out.println("Error: El número debe estar entre 0 y 10.");
            return false;
        }
    }
}

class JuegoAdivinaPar extends JuegoAdivinaNumero {

    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public void juega() {
        this.numeroAAdivinar = ((int) (Math.random() * 6)) * 2;
        super.juega();
    }

    @Override
    public boolean validaNumero(int n) {
        if (n >= 0 && n <= 10 && n % 2 == 0) {
            return true;
        } else {
            System.out.println("Error: Debe ingresar un número PAR entre 0 y 10.");
            return false;
        }
    }
}

class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public void juega() {
        this.numeroAAdivinar = (((int) (Math.random() * 5)) * 2) + 1;
        super.juega();
    }

    @Override
    public boolean validaNumero(int n) {
        if (n >= 0 && n <= 10 && n % 2 != 0) {
            return true;
        } else {
            System.out.println("Error: Debe ingresar un número IMPAR entre 0 y 10.");
            return false;
        }
    }
}