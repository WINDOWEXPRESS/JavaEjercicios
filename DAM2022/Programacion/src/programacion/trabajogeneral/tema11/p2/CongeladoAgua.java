package trabajogeneral.tema11.p2;

import java.time.LocalDate;

public final class CongeladoAgua extends Congelado{
    //En gramo de sal por litro de agua
    private final int salinidadAgua;

    public CongeladoAgua(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada, String paisOrigen, int salinidadAgua) {
        super(nombreProducto, numeroLote, fechaCaducidad, fechaEnvasada, paisOrigen);
        this.salinidadAgua = salinidadAgua;
    }

    @Override
    public String toString() {
        return "CongeladoAgua{" +super.toString()+
                ",salinidadAgua=" + salinidadAgua +
                '}';
    }
}
