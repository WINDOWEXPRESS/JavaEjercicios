package trabajogeneral.fibonacci;
public class MainFibonacci {
    static long[] sucesivoFibo;

    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();
        if(args.length>0){
        int n = Integer.parseInt(args[0]);
        sucesivoFibo = new long[n+1];
        System.out.println("El numero fibonacci es : " + n + " -> " + fibonacci(n));
        }
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
        System.out.println("TIEMPO TRANSCURRIDO :" + tiempoTranscurrido +" millisecond.");
        for (long x : sucesivoFibo
        ) {
            System.out.print(x + " ");
        }
    }

    static long fibonacci(int n) {
        if (n <= 1) {
            sucesivoFibo[n] = n;
            return n;
        } else if (sucesivoFibo[n] != 0) {
            //SI EL VALOR EXISTIESE EN ARRAY NO CALCULA DEVUELVE DIRECTO
            return sucesivoFibo[n];
        } else {
            sucesivoFibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return sucesivoFibo[n];
        }
    }
}
