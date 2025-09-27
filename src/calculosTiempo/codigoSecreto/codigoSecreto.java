package calculosTiempo.codigoSecreto;

public class codigoSecreto {
    private static long num = 536554678812l;
    private static int longNum = 12;

    public static boolean compare(long numCompare){
        return (num == numCompare);
    }

    public static int getLongNum() {
        return longNum;
    }
}
