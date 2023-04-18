package trabajogeneral.tema11.p3;

public class Administrador extends Persona {
    private String codigoAdminist;
    private String finca;
    private int numVecinos;
    private float salario;

    public Administrador() {
    }

    public Administrador(String nombre, int edad, String dni, String codigoAdminist, String finca, int numVecinos, float salario) {
        super(nombre, edad, dni);
        this.codigoAdminist = codigoAdminist;
        this.finca = finca;
        this.numVecinos = numVecinos;
        this.salario = salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public boolean codigoValido(String codigoAdminist) {
        if (codigoAdminist.length()>5){
            return false;
        }
        return codigoAdminist.charAt(0) == 'A' || codigoAdminist.charAt(0) == 'a';
    }

    public double salarioMaximo(float c) {
        return salario = c*numVecinos/2;
    }

    @Override
    public String toString() {
        return "Administrador{" +super.toString()+
                "codigoAdminist='" + codigoAdminist + '\'' +
                ", finca='" + finca + '\'' +
                ", numVecinos=" + numVecinos +
                ", salario=" + salario +
                '}';
    }
}
