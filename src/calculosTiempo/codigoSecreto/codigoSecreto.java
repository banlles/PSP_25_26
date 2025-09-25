package calculosTiempo.codigoSecreto;

public class codigoSecreto {
    private static long num = 9765246788l;
    private static int longNum = 10;

    public static boolean compare(int numCompare){
        return (num == numCompare);
    }

    public static int getLongNum() {
        return longNum;
    }
}
