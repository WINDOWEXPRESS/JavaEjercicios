package tiempo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PracticaDate {
    private static GregorianCalendar calendario1;

    public static void main(String[] args) {
        //1.Instanciar un objeto de la clase con el constructor por defecto. Muestra
        //por pantalla la fecha que se ha instanciado.
        Date  tiempo  = new Date();
        System.out.println(tiempo);
        //2. Instancia una segunda fecha utilizando el constructor al que le pasas
        //los parámetros, año, mes y día. Comprueba y visualiza el resultado.
        Date  tiempo1  = new Date(2000,1,22);
        System.out.println(tiempo1);
        //3. ¿Cuál es la fecha inicial utilizada por la clase Date?
        //LA HORA  LOCAL
        //4. Visualiza las fechas instanciadas utilizando métodos para mostrar
        //formatos distintos. Usa el método para visualizar el método de formato local.
        SimpleDateFormat formatoDate = new SimpleDateFormat();
        System.out.println(formatoDate.format(tiempo));
        //5. Utiliza algún método para visualizar cuál de las fechas es anterior a la otra.
        System.out.println(tiempo.compareTo(tiempo1));

        //1. Instancia 2 objetos de la clase utilizando distintos constructores. Comprueba
        GregorianCalendar calendario = new GregorianCalendar(2000,2,22);
        GregorianCalendar calendario1 = new GregorianCalendar(Locale.CHINA);
        System.out.println(calendario.getTime());
        System.out.println(calendario1.getTime());
        //2. Utilizando el método get para obtener los valores de los distintos
        //FIELD, muestra la información de alguna de las fechas instanciadas.
        for (int i = 0; i < 10; i++) {
            System.out.println(calendario.get(i));
        }
        //3. Utilizando lo anterior visualiza la primera fecha con el formato
        //dd/mm/yyy y la segunda día día de la semana, dd de <nombre del
        //mes> de yyyy
        //System.out.println(calendario.get(2011,11,1));
        //4. Calcular el tiempo transcurrido entre las dos fechas.
       // System.out.println(calendario1.getTime() - calendario.getTime());
        //5. Comprobar si el año de una fecha es bisiesto
        System.out.println(calendario.isLeapYear(2000   ));
        //6. Sumar y restar valores al día, mes o año de una fecha.
    }

}
