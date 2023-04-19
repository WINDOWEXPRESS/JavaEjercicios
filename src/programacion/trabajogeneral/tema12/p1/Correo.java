package trabajogeneral.tema12.p1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Correo {
    private final String origen;
    private final String destino;
    private final String asunto;
    private final String cuerpo;
    private final LocalDate fechaLlegada;
    private final LocalTime horaLlegada;

    public Correo(String origen, String destino, String asunto, String cuerpo, LocalDate fechaLlegada, LocalTime horaLlegada) {
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaLlegada = fechaLlegada;
        this.horaLlegada = horaLlegada;
    }

    public String getOrigen() {
        return origen;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String todoContenido() {
        return "Correo{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", fechaLlegada=" + fechaLlegada +
                ", horaLlegada=" + horaLlegada +
                '}';
    }

    @Override
    public String toString() {
        return "Correo{" +
                "origen='" + origen + '\'' +
                ", asunto='" + asunto + '\'' +
                ", fechaLlegada=" + fechaLlegada +
                ", horaLlegada=" + horaLlegada +
                '}';
    }
}
