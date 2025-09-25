package calculosTiempo.ejemplo3;

import java.io.File;
import java.io.InputStream;

public class lanzador {
    final static String pathCompilador = "C:\\Users\\Banlles\\.jdks\\openjdk-23.0.2\\bin\\java.exe";
    final static String pathClass = "C:\\worksPace\\IntelIj\\PSP\\PSP_25_26\\out\\production\\PSP_25_26";

    public static void main(String[] args) {
        try {
            String nombreClass = programaExterno.class.getName();
            ProcessBuilder pb = new ProcessBuilder(pathCompilador,
                    "-classpath", pathClass, nombreClass,
                    String.valueOf(5), String.valueOf(15));
           // pb.redirectOutput(new File("resultados.txt"));
           // pb.redirectError(new File("errors.txt"));
            Process p = pb.start();  //Guarda el proceso que se ejecuta en una variable
            InputStream is = p.getInputStream();  //lee las salidas del proceso ejecutado, los system out
            byte[] datos = is.readAllBytes(); //  //guarda la salida de lo de arriba en un array de bytes
            String str = new String(datos); //Guardamos el array de bytes en un String
            System.out.println(str);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
