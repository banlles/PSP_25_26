package calculosTiempo.codigoSecreto;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class crack {
    static Scanner sc = new Scanner(System.in);
    final static String pathCompilador = "C:\\Users\\Banlles\\.jdks\\openjdk-24\\bin\\java.exe";

    final static String pathCompiladorCasa = "C:\\Users\\JanBanlles\\.jdks\\openjdk-24\\bin\\java.exe";

    final static String pathClass = "C:\\Users\\Banlles\\IdeaProjects\\PSP_25_26\\out\\production\\PSP_25_26";

    final static String pathClassCasa = "C:\\Users\\JanBanlles\\IdeaProjects\\PSP_25_26\\out\\production\\PSP_25_26";

    public static void main(String[] args) {
        String nombreClass = buscadorCodigo.class.getName();

        System.out.println("Cuantos procesos");
        int nProcesors = Integer.parseInt(sc.nextLine());
        Process[] aProcess = new Process[nProcesors];

        int nLong = codigoSecreto.getLongNum();

        double nConvinations = Math.pow(nLong, nLong);

        long nConvinationsInt = (long) nConvinations;

        long interval = nConvinationsInt / nProcesors;
        long num1 = 0;
        long num2 = interval;


        try {

            LocalTime start = LocalTime.now();

            // bucle lanzar procesos
            for (int i = 0; i < nProcesors; i++) {

                ProcessBuilder pb = new ProcessBuilder(pathCompilador,
                        "-classpath", pathClass, nombreClass, String.valueOf(num1), String.valueOf(num2), String.valueOf(i)
                );

                pb.redirectErrorStream(true);
                pb.inheritIO();
                aProcess[i] = pb.start();

                num1 += interval;
                num2 = num1 + interval - 1;

            }

            boolean encontrado = false;
            while (!encontrado) {
            Thread.sleep(1000);

                for (int i = 0; i < nProcesors; i++) {

                    if(aProcess[i].isAlive()) continue;

                    if (aProcess[i].exitValue() == 0) {
                        for (int j = 0; j < nProcesors; j++) {
                            aProcess[j].destroy();
                            System.out.println("ha finalizado el proceso" + j);
                        }
                        encontrado = true;
                        break;
                    }
                }
            }


            LocalTime end = LocalTime.now();
            System.out.println("Ha tardado " + ChronoUnit.MILLIS.between(start, end) + " milisegundos");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

