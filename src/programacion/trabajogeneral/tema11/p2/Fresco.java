package trabajogeneral.tema11.p2;

import java.time.LocalDate;

public class Fresco extends AbstractProducto {

    public Fresco(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada, String paisOrigen) {
        super(nombreProducto, numeroLote, fechaCaducidad, fechaEnvasada, paisOrigen);
    }

    @Override
    public String toString() {
        return "Fresco{" +
                super.toString()+
                '}';
    }
}
