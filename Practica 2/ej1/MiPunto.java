package ej1;

public class MiPunto {
    private double x;
    private double y;


    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public MiPunto() {
        this.x = 0;
        this.y = 0;
    }

    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distancia(MiPunto p) {
        double dx = p.getX() - this.x;
        double dy = p.getY() - this.y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

 
    public double distancia(double x, double y) {
        double dx = x - this.x;
        double dy = y - this.y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }


    public static void main(String[] args) {
        MiPunto p1 = new MiPunto();
        MiPunto p2 = new MiPunto(10, 30.5);


        System.out.printf("Distancia entre p1 y p2: "+ p1.distancia(p2));
    }
}