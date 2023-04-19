package trabajogeneral.tema11.p3;

public class Vecino extends Persona{
    private String codigoVecino;
    private String codigoVivienda;
    private String finca;
    private static double cuota;

    public Vecino(String nombre, int edad, String codigoVecino, String codigoVivienda, String finca) {
        super(nombre, edad);
        this.codigoVecino = codigoVecino;
        this.codigoVivienda = codigoVivienda;
        this.finca = finca;
    }

    public Vecino(String nombre, int edad, String dni, String codigoVecino, String codigoVivienda, String finca) {
        super(nombre, edad, dni);
        this.codigoVecino = codigoVecino;
        this.codigoVivienda = codigoVivienda;
        this.finca = finca;
    }

    public static double getCuota() {
        return cuota;
    }

    public boolean codigoVAlido(String cadena) {
        if (cadena.length()>5){
            return false;
        }
        return cadena.charAt(0) == 'V' || cadena.charAt(0) == 'v';
    }

    public void modifCuota(double cuota) {
        Vecino.cuota = cuota;
    }

    @Override
    public String toString() {
        return "Vecino{" +super.toString()+
                "codigoVecino='" + codigoVecino + '\'' +
                ", codigoVivienda='" + codigoVivienda + '\'' +
                ", finca='" + finca + '\'' +
                '}';
    }
}
