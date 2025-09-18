package calculosTiempo.ejemplo1;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class principal {
    public static void main(String[] args) {
        final int max = 1000000;


        // Bucle sin interacción
        LocalTime timeStart = LocalTime.now();
        long suma = 0;
        for (int i = 0; i < max; i++) {
            suma += i;
        }

        LocalTime timeEnd = LocalTime.now();

        System.out.println(suma + "Ha tardado " + ChronoUnit.MILLIS.between(timeStart, timeEnd) + " milisegundos");

        //Bucle son sout
        LocalTime timeStart2 = LocalTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < max; i++) {
            stringBuilder.append(i);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
        LocalTime timeEnd2 = LocalTime.now();
        System.out.println(suma + "Ha tardado " + ChronoUnit.MILLIS.between(timeStart2, timeEnd2) + " milisegundos");


        //Bucle volcado a fichero
        LocalTime timeStart3 = LocalTime.now();
        File file = new File("salida.txt");
        try {
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < max; i++) {
                fw.write(i + "\n");
            }
        } catch (Exception e) {

        }
        LocalTime timeEnd3 = LocalTime.now();
        System.out.println(suma + "Ha tardado " + ChronoUnit.MILLIS.between(timeStart3, timeEnd3) + " milisegundos");
    }
}
