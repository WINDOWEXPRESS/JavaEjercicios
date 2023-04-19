package trabajogeneral.tema12.p2;

public class Comercial extends Empleado{
    private double comision;

    public Comercial() {
    }

    public Comercial(String nombre) {
        super(nombre);
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }
    /*
    public double calcularSueldo() {

    } */
}
