package calculosTiempo.noel;

public class alumno {
    private static String nombre;
    private static String edad;
    private static int notaIngles ;
    private static int notaProgramacion;

    public alumno() {}

    public alumno(String nombre, String edad, int notaIngles, int notaProgramacion) {
        this.nombre = nombre;  //this nombre se refiere a la variable de arriba del todo
        this.edad = edad;
        this.notaIngles = notaIngles;
        this.notaProgramacion = notaProgramacion;
    }

    public String getNombre() { //public STRING getNombre() es una funcion que devuelve un String
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public int getNotaIngles() {
        return notaIngles;
    }

    public int getNotaProgramacion() {
        return notaProgramacion;
    }

    public void setNombre(String nombre) { //public void setNombre es una funcion que no devuelve nada, solamente
        // asigna un valor a la variable nombre
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setNotaIngles(int notaIngles) {
        this.notaIngles = notaIngles;
    }

    public void setNotaProgramacion(int notaProgramacion) {
        this.notaProgramacion = notaProgramacion;
    }


}
