package trabajogeneral.tema11.p2;

import java.time.LocalDate;

public class Refrigerado extends AbstractProducto {
    private final int codigoOrganismo;
    private final float temperaturaRecomendada;

    public Refrigerado(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada,
                       String paisOrigen, int codigoOrganismo, float temperaturaRecomendada) {
        super(nombreProducto, numeroLote, fechaCaducidad, fechaEnvasada, paisOrigen);
        this.codigoOrganismo = codigoOrganismo;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return "Refrigerado{" +super.toString()+
                "codigoOrganismo=" + codigoOrganismo +
                ", temperaturaRecomendada=" + temperaturaRecomendada +
                '}';
    }
}
