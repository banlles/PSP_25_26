package calculosTiempo.ejercicio1;
import java.util.Scanner;
import java.io.FileWriter;

public class programaNotaAlumno {
    public static void main(String[] args) {
        String nombre = args[0],
                apellido = args[1];
        double nExamen   = Double.parseDouble(args[2]);
        double nPractica = Double.parseDouble(args[3]);
        double nContinua = Double.parseDouble(args[4]);

        try  {
            FileWriter fw = new FileWriter((apellido + nombre + ".txt"));
            fw.write("Nombre: " +nombre + "\n");
            fw.write("Apellido: " +apellido + "\n");
            fw.write("Nota Examen: " +nExamen + "\n");
            fw.write("Nota Práctica: " +nPractica + "\n");
            fw.write("Nota Continua: " +nContinua + "\n");
            fw.write("Nota Final: " + ((nExamen + nPractica + nContinua) / 3.0) + "\n");

            fw.close();
            System.out.println("Archivo guardado exitosamente del alumno " + (apellido + nombre));

        } catch (Exception e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}

