package juego.buscamina1;

public enum Sign {
    CASILLA("·"),BANDERA("#"),INTERROGACION("?"),MINA("*");
    public final String sign;

    Sign(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
