package calculosTiempo.noel;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        alumno infoAlumnoArray[] = new alumno[1];


        for(int i = 0; i < infoAlumnoArray.length; i++) {
            alumno infoAlumno = new alumno();

            System.out.println("Pon tu nombre");
            infoAlumno.setNombre(sc.nextLine());  //  public void setNombre(String nombre)

            System.out.println("Pon tu edad");
            infoAlumno.setEdad(sc.nextLine());  //   public void setEdad(String edad)

            System.out.println("Pon tu nota de ingles");
            infoAlumno.setNotaIngles(Integer.parseInt(sc.nextLine())); // public void setNotaIngles(int notaIngles)

            System.out.println("Pon tu nota de programacion");
            infoAlumno.setNotaProgramacion(Integer.parseInt(sc.nextLine()));  // public void setNotaIngles(int notaIngles)

            System.out.println(calculaNota.calcularMedia(infoAlumno));

            infoAlumnoArray[i] = infoAlumno;
        }





        System.out.println("Se ha terminado el bucle");






        alumno infoAlumno = new alumno();

        System.out.println("Pon tu nombre");
         infoAlumno.setNombre(sc.nextLine());  //  public void setNombre(String nombre)

        System.out.println("Pon tu edad");
        infoAlumno.setEdad(sc.nextLine());  //   public void setEdad(String edad)

        System.out.println("Pon tu nota de ingles");
        infoAlumno.setNotaIngles(Integer.parseInt(sc.nextLine())); // public void setNotaIngles(int notaIngles)

        System.out.println("Pon tu nota de programacion");
        infoAlumno.setNotaProgramacion(Integer.parseInt(sc.nextLine()));  // public void setNotaIngles(int notaIngles)

        System.out.println(calculaNota.calcularMedia(infoAlumno));










        alumno infoAlumno2 = new alumno();

        System.out.println("Pon tu nombre");
        infoAlumno2.setNombre(sc.nextLine());  //  public void setNombre(String nombre

        System.out.println("Pon tu edad");
        infoAlumno2.setEdad(sc.nextLine());  //   public void setEdad(String edad

        System.out.println("Pon tu nota de ingles");
        infoAlumno2.setNotaIngles(Integer.parseInt(sc.nextLine())); // public void setNotaIngles(int notaIngles)

        System.out.println("Pon tu nota de programacion");
        infoAlumno2.setNotaProgramacion(Integer.parseInt(sc.nextLine()));  // public void setNotaIngles(int notaIngles)

        System.out.println(calculaNota.calcularMedia(infoAlumno2));

    }
}
