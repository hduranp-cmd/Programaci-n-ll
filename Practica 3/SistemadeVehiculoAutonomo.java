package sistemadevehiculoautonomo;


class Sensor {
    public String tipo = "Genérico";
    public String id;
    public boolean encendido;

    public Sensor(String id) {
        this.id = id;
        this.encendido = false;
    }

    public void activar() {
        this.encendido = true;
        System.out.println("Sensor " + id + " activado.");
    }

    public void desactivar() {
        this.encendido = false;
        System.out.println("Sensor " + id + " desactivado.");
    }
}


interface CamaraInterface {
    String getResolucion();
}


interface SensorLuzLaserInterface {
    int getAlcance();
}


class VehiculoAutonomo extends Sensor implements CamaraInterface, SensorLuzLaserInterface {
    public String resolucion;
    public int alcance;

    public VehiculoAutonomo(String id, String resolucion, int alcance) {
        super(id);
        this.tipo = "Vehículo Autónomo";
        this.resolucion = resolucion;
        this.alcance = alcance;
    }

    @Override
    public String getResolucion() {
        return this.resolucion;
    }

    @Override
    public int getAlcance() {
        return this.alcance;
    }
}


public class SistemadeVehiculoAutonomo {
    public static void main(String[] args) {
        VehiculoAutonomo v = new VehiculoAutonomo("Gama alta", "1080p", 150);
        
        System.out.println("Tipo: " + v.tipo);
        System.out.println("ID: " + v.id);
        System.out.println("Resolución: " + v.getResolucion());
        System.out.println("Alcance: " + v.getAlcance());
        
        v.activar();
    }
}