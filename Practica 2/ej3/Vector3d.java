package ej3;

public class Vector3d {
    private double a1;
    private double a2;
    private double a3;

    public Vector3d(double a1, double a2, double a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public static void main(String[] args) {
        Vector3d a = new Vector3d(1.0, 2.0, 3.0);
        Vector3d b = new Vector3d(4.0, -5.0, 6.0);

        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);

        System.out.println("Suma: " + a.sumar(b));
        System.out.println("Escalar: " + a.multiplicarEscalar(2.0));
        System.out.println("Longitud: "+ a.longitud());

        System.out.println("Normal de a: " + a.normal());
        System.out.println("Producto Escalar : " + a.productoEscalar(b));
        System.out.println("Producto Vectorial : " + a.productoVectorial(b));
    }

    public double getA1() {
        return a1;
    }

    public double getA2() {
        return a2;
    }

    public double getA3() {
        return a3;
    }

    public Vector3d sumar(Vector3d b) {
        return new Vector3d(
                this.a1 + b.getA1(),
                this.a2 + b.getA2(),
                this.a3 + b.getA3()
        );
    }

    public Vector3d multiplicarEscalar(double r) {
        return new Vector3d(
                r * this.a1,
                r * this.a2,
                r * this.a3
        );
    }

    public double longitud() {
        return Math.sqrt(Math.pow(this.a1, 2) + Math.pow(this.a2, 2) + Math.pow(this.a3, 2));
    }

    public Vector3d normal() {
        double len = this.longitud();
        if (len == 0) {
            System.out.println("No se puede normalizar el vector nulo.");
            return new Vector3d(0, 0, 0);
        }
        return new Vector3d(
                this.a1 / len,
                this.a2 / len,
                this.a3 / len
        );
    }

    public double productoEscalar(Vector3d b) {
        return (this.a1 * b.getA1()) + (this.a2 * b.getA2()) + (this.a3 * b.getA3());
    }

    public Vector3d productoVectorial(Vector3d b) {
        double c1 = (this.a2 * b.getA3()) - (this.a3 * b.getA2());
        double c2 = (this.a3 * b.getA1()) - (this.a1 * b.getA3());
        double c3 = (this.a1 * b.getA2()) - (this.a2 * b.getA1());
        return new Vector3d(c1, c2, c3);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", a1, a2, a3);
    }
}
