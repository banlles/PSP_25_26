package calculosTiempo.codigoSecreto;

public class buscadorCodigo {

    public static void main(String[] args) {
        int nInitial = Integer.parseInt(args[0]);
        int nFinal = Integer.parseInt(args[1]);

        for (int i = nInitial; i < nFinal; i++) {
            if (codigoSecreto.compare(i)) {
                System.exit(0);
            }
        }
        System.exit(1);
    }
}
