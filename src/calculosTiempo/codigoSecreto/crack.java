package calculosTiempo.codigoSecreto;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


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

        double nConvinations = Math.pow(10, nLong);

        long nConvinationsInt = (long) nConvinations;

        long interval = nConvinationsInt / nProcesors;
        long num1 = 0;
        long num2 = interval;


        try {

            LocalTime start = LocalTime.now();

            // bucle lanzar procesos
            for (int i = 0; i < nProcesors; i++) {

                ProcessBuilder pb = new ProcessBuilder(pathCompiladorCasa,
                        "-classpath", pathClassCasa, nombreClass, String.valueOf(num1), String.valueOf(num2), String.valueOf(i)
                );

                pb.redirectErrorStream(true);
                pb.inheritIO();
                aProcess[i] = pb.start();

                num1 += interval;
                num2 = num1 + interval;

            }

//            boolean encontrado = false;
//            while (!encontrado) {
//            Thread.sleep(1000);
//
//                for (int i = 0; i < nProcesors; i++) {
//
//                    if(aProcess[i].isAlive()) continue;
//
//                    if (aProcess[i].exitValue() == 0) {
//                        for (int j = 0; j < nProcesors; j++) {
//                            aProcess[j].destroy();
//                            System.out.println("ha finalizado el proceso" + j);
//                        }
//                        encontrado = true;
//                        break;
//                    }
//                }
//            }

            CountDownLatch fin = new CountDownLatch(1); // para desbloquear el main cuando alguien encuentre
            AtomicInteger nProcessFinally = new AtomicInteger();

            for (int i = 0; i < nProcesors; i++) {
                final int idx = i;

                aProcess[i].onExit().thenAccept(proc -> {
                    int exit = proc.exitValue();
                    if (exit == 0) {
                        System.out.println("El proceso " + idx + " encontró el código.");
                        // parar inmediatamente al resto
                        for (int j = 0; j < nProcesors; j++) {
                            if (j != idx && aProcess[j].isAlive()) {
                                aProcess[j].destroy();
                                System.out.println("ha finalizado el proceso " + j);
                            }
                        }
                        // medir tiempo aquí si quieres
                        LocalTime end = LocalTime.now();
                        System.out.println("Ha tardado " + ChronoUnit.MILLIS.between(start, end) + " ms");

                        fin.countDown(); // ya podemos salir del main
                    } else {
                        if (exit != 0) {
                            nProcessFinally.addAndGet(1);
                            // proceso que terminó sin éxito
                            System.out.println("El proceso " + idx + " terminó sin encontrar el código.");
                        }
                        if (nProcessFinally.get() == nProcesors) {
                            fin.countDown();
                        }
                    }
                });
            }

            // Bloquea el main hasta que uno haya encontrado y haya parado a los demás
            try {
                fin.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

