package trabajogeneral.tema11.p2;

import java.time.LocalDate;

public class Congelado extends AbstractProducto {
    protected int temperaturaRecomendada;
    public Congelado(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada, String paisOrigen) {
        super(nombreProducto, numeroLote, fechaCaducidad, fechaEnvasada, paisOrigen);
    }

    @Override
    public String toString() {
        return super.toString()+
                ", temperaturaRecomendada=" + temperaturaRecomendada;
    }
}
