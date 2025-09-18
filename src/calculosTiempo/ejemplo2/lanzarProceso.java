package calculosTiempo.ejemplo2;

public class lanzarProceso {

    public static void EjecutarPrograma(String comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            pb.start();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        EjecutarPrograma("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
        System.out.println("Programa finalizado");
    }

}
