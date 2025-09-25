package calculosTiempo.codigoSecreto;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Scanner;

public class crack {
    static Scanner sc = new Scanner(System.in);
    final static String pathCompilador = "C:\\Users\\Banlles\\.jdks\\openjdk-23.0.2\\bin\\java.exe";

    final static String pathCompiladorCasa = "C:\\Users\\JanBanlles\\.jdks\\openjdk-24\\bin\\java.exe";

    final static String pathClass = "C:\\worksPace\\IntelIj\\PSP\\PSP_25_26\\out\\production\\PSP_25_26";

    final static String pathClassCasa = "C:\\Users\\JanBanlles\\IdeaProjects\\PSP_25_26\\out\\production\\PSP_25_26";

    public static void main(String[] args) {
        String nombreClass = buscadorCodigo.class.getName();

        System.out.println("Cuantos procesos");
        int nProcesors = Integer.parseInt(sc.nextLine());
        Process[] aProcess = new Process[nProcesors];

        int nLong = codigoSecreto.getLongNum();

        double nConvinations = Math.pow(nLong, nLong);

        long nConvinationsInt = (long) nConvinations; // Resultado: 9


        long interval = nConvinationsInt / nProcesors;
        long num1 = 0;
        long num2 = interval;

        try {

            // bucle lanzar procesos
            for (int i = 0; i < nProcesors; i++) {

                ProcessBuilder pb = new ProcessBuilder(pathCompiladorCasa,
                        "-classpath", pathClassCasa, nombreClass, String.valueOf(num1), String.valueOf(num2), String.valueOf(i)
                );

                aProcess[i] = pb.start();

                num1 += interval;
                num2 = num1 + interval - 1;

            }

            File file = new File("salida.txt");
            FileWriter fw = new FileWriter(file);

            for (int i = 0; i < nProcesors; i++) {
                InputStream is = aProcess[i].getInputStream();  //lee las salidas del proceso ejecutado, los system out
                byte[] datos = is.readAllBytes(); //  //guarda la salida de lo de arriba en un array de bytes
                String str = new String(datos); //Guardamos el array de bytes en un String
                fw.write(str);
            }
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

