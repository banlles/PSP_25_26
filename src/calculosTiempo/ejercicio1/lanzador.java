package calculosTiempo.ejercicio1;

// OJO: programaNotaAlumno está en este mismo paquete, no hace falta importarlo

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class lanzador {
    final static String pathCompilador = "C:\\Users\\Banlles\\.jdks\\openjdk-23.0.2\\bin\\java.exe";
    final static String pathClass = "C:\\worksPace\\IntelIj\\PSP\\PSP_25_26\\out\\production\\PSP_25_26";

    public static void main(String[] args) {
        try {
            String nombreClass = programaNotaAlumno.class.getName();

            String[][] alumnos = {
                    {"Pedro",  "Fernandez", "6", "8", "7"},
                    {"Laura",  "Martinez",  "9", "7", "8"},
                    {"Carlos", "Sanchez",   "5", "6", "6"}
            };

            for (String[] alumno : alumnos) {
                ProcessBuilder pb = new ProcessBuilder(
                        pathCompilador,
                        "-classpath", pathClass,
                        nombreClass,
                        alumno[0], alumno[1], alumno[2], alumno[3], alumno[4]
                );

                Process p = pb.start();

                InputStream is = p.getInputStream();
                byte[] datos = is.readAllBytes();
                String str = new String(datos, StandardCharsets.UTF_8);
                if (!str.isBlank()) {
                    System.out.println("Info: " + str);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
