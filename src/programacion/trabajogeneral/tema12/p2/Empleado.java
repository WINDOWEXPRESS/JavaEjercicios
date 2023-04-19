package trabajogeneral.tema12.p2;

public class Empleado {
    //Variables
    private String nombre;
    private String nSS;
    private double sueldoBase;

    //Constructores
    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, String nSS, double sueldoBase) {
        this.nombre = nombre;
        this.nSS = nSS;
        this.sueldoBase = sueldoBase;
    }

    //Getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnSS() {
        return nSS;
    }

    public void setnSS(String nSS) {
        this.nSS = nSS;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    /*
    public double calcularSueldo() {

    } */

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
