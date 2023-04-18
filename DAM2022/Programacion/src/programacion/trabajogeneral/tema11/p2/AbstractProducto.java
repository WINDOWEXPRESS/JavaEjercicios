package trabajogeneral.tema11.p2;

import java.time.LocalDate;

public abstract class AbstractProducto {
    protected String nombreProducto;
    protected int numeroLote;
    protected LocalDate fechaCaducidad;
    protected LocalDate fechaEnvasada;
    protected String paisOrigen;
    public AbstractProducto() {}
    public AbstractProducto(String nombreProducto, int numeroLote, LocalDate fechaCaducidad, LocalDate fechaEnvasada, String paisOrigen) {
        this.nombreProducto = nombreProducto;
        this.numeroLote = numeroLote;
        this.fechaCaducidad = fechaCaducidad;
        this.fechaEnvasada = fechaEnvasada;
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return  "nombreProducto='" + nombreProducto + '\'' +
                ", numeroLote=" + numeroLote +
                ", fechaCaducidad=" + fechaCaducidad +
                ", fechaEnvasada=" + fechaEnvasada +
                ", paisOrigen='" + paisOrigen + '\'';
    }
}
