package calculosTiempo.ejercicio2;

public class programaExterno {
    public static void main(String[] args) {
        int numInitial = Integer.parseInt(args[0]),
                numFinally = Integer.parseInt(args[1]);

        for (int i = numInitial; i < numFinally; i++) {
            System.out.println(i);
        }
    }
}
