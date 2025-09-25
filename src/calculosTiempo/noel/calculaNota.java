package calculosTiempo.noel;

public class calculaNota {


    public static int calcularMedia(alumno Patata) {

        int notaIngles = Patata.getNotaIngles();
        int notaProgramacion = Patata.getNotaProgramacion();

        return notaIngles / notaProgramacion;
    }

}
