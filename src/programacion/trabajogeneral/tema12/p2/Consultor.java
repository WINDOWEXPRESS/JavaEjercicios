package trabajogeneral.tema12.p2;

public class Consultor extends Empleado{
    private float precioHora;
    private float numHoras;

    public Consultor() {
    }

    public Consultor(String name) {
        super(name);
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public float getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(float numHoras) {
        this.numHoras = numHoras;
    }
}
