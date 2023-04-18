package trabajogeneral.tema11.p1;

public class Trabajador extends Persona{
    char categoriaProfesional;
    int antiguedad;

    public void setCategoriaProfesional(char categoriaProfesional) {
        this.categoriaProfesional = categoriaProfesional;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Trabajador() {
    }

    public Trabajador(String name, String telefono, int edad, char categoriaProfesional, int antiguedad) {
        super(name, telefono, edad);
        this.categoriaProfesional = categoriaProfesional;
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return super.toString()+"\nTrabajador{" +
                "categoriaProfesional=" + categoriaProfesional +
                ", antiguedad=" + antiguedad +
                '}';
    }
}
