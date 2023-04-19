package trabajogeneral.tema11.p3;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public boolean dniValido(String dni) {
        if (dni.length()>9){
            return false;
        }
        for (int i = 0; i < dni.length(); i++) {
            char caracter = dni.charAt(i);
            if ((!Character.isDigit(caracter) && i!=dni.length()-1)||(!Character.isAlphabetic(caracter) && i==dni.length()-1) ) {
                return false;
            }
        }
        return true;
    }
    public boolean esMayorDeEdad(int edad) {
        if (edad<18){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                '}';
    }
}
