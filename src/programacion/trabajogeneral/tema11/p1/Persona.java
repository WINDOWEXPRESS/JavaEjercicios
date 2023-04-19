package trabajogeneral.tema11.p1;

public class Persona {
    private String name;
    private String telefono;
    private int edad;

    public Persona() {
    }

    public Persona(String name, String telefono, int edad) {
        this.name = name;
        this.telefono = telefono;
        this.edad = edad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }
}
