package calculosTiempo.codigoSecreto;

import calculosTiempo.ejemplo3.programaExterno;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Scanner;

public class crack {
    static Scanner sc = new Scanner(System.in);
    final static String pathCompilador = "C:\\Users\\Banlles\\.jdks\\openjdk-23.0.2\\bin\\java.exe";
    final static String pathClass = "C:\\worksPace\\IntelIj\\PSP\\PSP_25_26\\out\\production\\PSP_25_26";

    public static void main(String[] args) {
        String nombreClass = buscadorCodigo.class.getName();

        System.out.println("Cuantos procesos");
        int nProcesors = Integer.parseInt(sc.nextLine());
        Process[] aProcess = new Process[nProcesors];

        int longNum = codigoSecreto.getLongNum();

        double a = Math.pow(longNum, longNum);

        int interval = longNum / nProcesors;
        int num1 = 0;
        int num2 = interval;

        try {

            // bucle lanzar procesos
            for (int i = 0; i < nProcesors; i++) {

                ProcessBuilder pb = new ProcessBuilder(pathCompilador,
                        "-classpath", pathClass, nombreClass, String.valueOf(num1), String.valueOf(num2)
                );

                aProcess[i] = pb.start();

                num1 += interval;
                num2 = num1 + interval - 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

