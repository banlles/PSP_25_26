package calculosTiempo.ejercicio2;

import calculosTiempo.ejemplo3.programaExterno;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Scanner;

public class lanzador {
    static Scanner sc = new Scanner(System.in);
    final static String pathCompilador = "C:\\Users\\Banlles\\.jdks\\openjdk-23.0.2\\bin\\java.exe";
    final static String pathClass = "C:\\worksPace\\IntelIj\\PSP\\PSP_25_26\\out\\production\\PSP_25_26";

    public static void main(String[] args) {
        String nombreClass = programaExterno.class.getName();

        System.out.println("Cuantos procesos");
        int nProcesors = Integer.parseInt(sc.nextLine());
        System.out.println("Numero de inicio");
        int nInitial = Integer.parseInt(sc.nextLine());
        System.out.println("Numero de fin");
        int nFinally = Integer.parseInt(sc.nextLine());
        System.out.println("Fichero de salida");
        String fileOut = sc.nextLine();

        Process[] aProcess = new Process[nProcesors];

        try {

            int intervalo = nFinally / nProcesors;
            int num1 = nInitial;
            int num2 = intervalo - 1;

            // bucle lanzar procesos
            for (int i = 0; i < nProcesors; i++) {

                ProcessBuilder pb = new ProcessBuilder(pathCompilador,
                        "-classpath", pathClass, nombreClass, String.valueOf(num1), String.valueOf(num2)
                );

                System.out.println("Inicio " + String.valueOf(num1));
                System.out.println("Fin " + String.valueOf(num2));

                aProcess[i] = pb.start();

                num1 += intervalo;
                num2 = num1 + intervalo - 1;

            }

            //bucle para recoger resultados de procesos
            File file = new File(fileOut);
            FileWriter fw = new FileWriter(file);

            for (int i = 0; i < nProcesors; i++) {
                InputStream is = aProcess[i].getInputStream();  //lee las salidas del proceso ejecutado, los system out
                byte[] datos = is.readAllBytes(); //  //guarda la salida de lo de arriba en un array de bytes
                String str = new String(datos); //Guardamos el array de bytes en un String
                fw.write("Proceso" + i + " " + str);
            }
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
////            ProcessBuilder pb = new ProcessBuilder(pathCompilador,
////                    "-classpath", pathClass, nombreClass,
////                    String.valueOf(5), String.valueOf(15));
////            // pb.redirectOutput(new File("resultados.txt"));
////            // pb.redirectError(new File("errors.txt"));
////            Process p = pb.start();  //Guarda el proceso que se ejecuta en una variable
////            InputStream is = p.getInputStream();  //lee las salidas del proceso ejecutado, los system out
////            byte[] datos = is.readAllBytes(); //  //guarda la salida de lo de arriba en un array de bytes
////            String str = new String(datos); //Guardamos el array de bytes en un String
////            System.out.println(str);
////        } catch (Exception e){
////            e.printStackTrace();
////        }

    }
}