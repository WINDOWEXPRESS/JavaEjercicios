package trabajogeneral.tema11.p2;

import java.time.LocalDate;


public final class CongeladoNitro extends Congelado {
    private final String metodoCongelacion;
    //En segundo
    private final int tiempoExposicionAlNitro;

    public CongeladoNitro(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada, String paisOrigen, String metodoCongelacion, int tiempoExposicionAlNitro) {
        super(nombreProducto, numeroLote, fechaCaducidad, fechaEnvasada, paisOrigen);
        this.metodoCongelacion = metodoCongelacion;
        this.tiempoExposicionAlNitro = tiempoExposicionAlNitro;
    }

    @Override
    public String toString() {
        return "CongeladoNitro{" +super.toString()+
                "metodoCongelacion='" + metodoCongelacion + '\'' +
                ", tiempoExposicionAlNitro=" + tiempoExposicionAlNitro +
                '}';
    }
}
