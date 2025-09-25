package calculosTiempo.codigoSecreto;

public class buscadorCodigo {

    public static void main(String[] args) {
        long nInitial = Long.parseLong(args[0]);
        long nFinal = Long.parseLong(args[1]);
        int idProcess = Integer.parseInt(args[2]);

        for (long i = nInitial; i < nFinal; i++) {
            if (codigoSecreto.compare(i)) {
                System.out.println("Codigo encontrado " + i + " por el proceso " + idProcess);
                System.exit(0);
            }
        }
        System.exit(1);
    }
}
