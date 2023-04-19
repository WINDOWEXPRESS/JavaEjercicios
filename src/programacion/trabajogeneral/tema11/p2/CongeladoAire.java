package trabajogeneral.tema11.p2;

import java.time.LocalDate;

public final class CongeladoAire extends Congelado{
    String[] AIRE_CONGELADO = {"Nitrogeno", "Oxigeno", "Dioxido de carbono", "Vapor de agua"};
    private final float[] porcentajeCongeladoAire;

    public CongeladoAire(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada,
                         String paisOrigen, float[] porcentajeAireCongelado) {
        super(nombreProducto, numeroLote, fechaCaducidad, fechaEnvasada, paisOrigen);
        this.porcentajeCongeladoAire = porcentajeAireCongelado;
    }

    public String listadoPorcentajeCongeladoAire() {
        StringBuilder cadena= new StringBuilder();
        for (int i = 0; i < porcentajeCongeladoAire.length; i++) {
            cadena.append(AIRE_CONGELADO[i]).append(":").append(porcentajeCongeladoAire[i]).append(",");
        }
        return cadena.toString();
    }

    @Override
    public String toString() {
        return "CongeladoAire{" +super.toString()+
                ", porcentajeCongeladoAire=" + listadoPorcentajeCongeladoAire() +
                '}';
    }
}
