package calculosTiempo.codigoSecreto;

public class codigoSecreto {
    private static long num = 5465246788l;
    private static int longNum = 10;

    public static boolean compare(long numCompare){
        return (num == numCompare);
    }

    public static int getLongNum() {
        return longNum;
    }
}
