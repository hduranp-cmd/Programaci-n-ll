package ej2;

import java.util.Scanner;

public class algebravectorial {

    private boolean sonMismoTamano(Vector a, Vector b) {
        return a.getDimension() == b.getDimension();
    }

    public boolean esPerpendicular(Vector a, Vector b) {
        if (!sonMismoTamano(a, b))
            return false;
        Vector vSuma = a.sumar(b);
        Vector vResta = a.restar(b);
        return Math.abs(vSuma.magnitud() - vResta.magnitud()) < 0.00001;
    }

    public boolean esPerpendicular(Vector a, Vector b, char metodo) {
        if (!sonMismoTamano(a, b))
            return false;
        if (metodo == 'b') {
            Vector aMenosB = a.restar(b);
            Vector bMenosA = b.restar(a);
            return Math.abs(aMenosB.magnitud() - bMenosA.magnitud()) < 0.00001;
        }
        return false;
    }

    public boolean esPerpendicular(Vector a, Vector b, boolean usarProductoPunto) {
        if (!sonMismoTamano(a, b))
            return false;
        return Math.abs(a.productoPunto(b)) < 0.00001;
    }

    public boolean esPerpendicular(Vector a, Vector b, int opcionPitagoras) {
        if (!sonMismoTamano(a, b))
            return false;
        double magA2 = Math.pow(a.magnitud(), 2);
        double magB2 = Math.pow(b.magnitud(), 2);
        Vector vSuma = a.sumar(b);
        double magSuma2 = Math.pow(vSuma.magnitud(), 2);
        return Math.abs(magSuma2 - (magA2 + magB2)) < 0.00001;
    }

    public boolean esParalelo(Vector a, Vector b) {
        if (!sonMismoTamano(a, b))
            return false;
        double r = 0;
        boolean proporcionEncontrada = false;
        for (int i = 0; i < a.getDimension(); i++) {
            if (b.getComponente(i) != 0) {
                r = a.getComponente(i) / b.getComponente(i);
                proporcionEncontrada = true;
                break;
            }
        }
        if (!proporcionEncontrada) {
            return a.magnitud() == 0;
        }
        for (int i = 0; i < a.getDimension(); i++) {
            double aEsperado = r * b.getComponente(i);
            if (Math.abs(a.getComponente(i) - aEsperado) > 0.00001) {
                return false;
            }
        }
        return true;
    }

    public boolean esParalelo(Vector a, Vector b, boolean usarProductoCruz) {
        if (!sonMismoTamano(a, b))
            return false;
        Vector c = a.productoCruz(b);
        if (c == null) {
            System.out.println("El producto cruz solo está implementado para 2D y 3D.");
            return false;
        }
        return Math.abs(c.magnitud()) < 0.00001;
    }

    public Vector proyeccion(Vector a, Vector b) {
        if (!sonMismoTamano(a, b))
            return null;

        double magBCuadrado = b.productoPunto(b);
        if (magBCuadrado == 0) {
            System.out.println("No se puede proyectar sobre el vector nulo.");
            return null;
        }
        double factor = a.productoPunto(b) / magBCuadrado;
        return b.multiplicarEscalar(factor);
    }

    public double componenteEnB(Vector a, Vector b) {
        if (!sonMismoTamano(a, b))
            return 0;
        double magB = b.magnitud();
        if (magB == 0)
            return 0;
        return a.productoPunto(b) / magB;
    }

    public static void main(String[] args) {
        algebravectorial algebra = new algebravectorial();

        Vector v1 = new Vector(2);
        Vector v2 = new Vector(2);

        v1.llenar();

        v2.llenar();

        System.out.println("Es Perpendicular  " + algebra.esPerpendicular(v1, v2, true));
        System.out.println("Paralelo " + algebra.esParalelo(v1, v2));
        System.out.println("Componente: " + algebra.componenteEnB(v1, v2));

        Vector proj = algebra.proyeccion(v1, v2);
        if (proj != null) {
            System.out.print("Proyección Ortogonal de V1 sobre V2: ");
            for (int i = 0; i < proj.getDimension(); i++) {
                System.out.print(proj.getComponente(i));
                if (i < proj.getDimension() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }
}

class Vector {
    private double[] componentes;
    private int tamano;
    private Scanner n = new Scanner(System.in);

    public Vector(int tamano) {
        this.tamano = tamano;
        this.componentes = new double[tamano];
    }

    public double[] llenar() {
        for (int i = 0; i < this.tamano; i++) {
            System.out.print("Componente [" + i + "]: ");
            this.componentes[i] = n.nextDouble();
        }
        return this.componentes;
    }

    public int getDimension() {
        return this.tamano;
    }

    public double getComponente(int i) {
        return this.componentes[i];
    }

    public double productoPunto(Vector b) {
        double suma = 0;
        for (int i = 0; i < this.tamano; i++) {
            suma += this.componentes[i] * b.getComponente(i);
        }
        return suma;
    }

    public double magnitud() {
        double sumaCuadrados = 0;
        for (int i = 0; i < this.tamano; i++) {
            sumaCuadrados += Math.pow(this.componentes[i], 2);
        }
        return Math.sqrt(sumaCuadrados);
    }

    public Vector sumar(Vector b) {
        Vector resultado = new Vector(this.tamano);
        for (int i = 0; i < this.tamano; i++) {
            resultado.componentes[i] = this.componentes[i] + b.getComponente(i);
        }
        return resultado;
    }

    public Vector restar(Vector b) {
        Vector resultado = new Vector(this.tamano);
        for (int i = 0; i < this.tamano; i++) {
            resultado.componentes[i] = this.componentes[i] - b.getComponente(i);
        }
        return resultado;
    }

    public Vector productoCruz(Vector b) {
        if (this.tamano == 3 && b.getDimension() == 3) {
            double rx = this.componentes[1] * b.getComponente(2) - this.componentes[2] * b.getComponente(1);
            double ry = this.componentes[2] * b.getComponente(0) - this.componentes[0] * b.getComponente(2);
            double rz = this.componentes[0] * b.getComponente(1) - this.componentes[1] * b.getComponente(0);

            Vector resultado = new Vector(3);
            resultado.componentes[0] = rx;
            resultado.componentes[1] = ry;
            resultado.componentes[2] = rz;
            return resultado;
        } else if (this.tamano == 2 && b.getDimension() == 2) {
            double rz = this.componentes[0] * b.getComponente(1) - this.componentes[1] * b.getComponente(0);
            Vector resultado = new Vector(1);
            resultado.componentes[0] = rz;
            return resultado;
        }
        return null;
    }

    public Vector multiplicarEscalar(double k) {
        Vector resultado = new Vector(this.tamano);
        for (int i = 0; i < this.tamano; i++) {
            resultado.componentes[i] = this.componentes[i] * k;
        }
        return resultado;
    }
}