public class TaulaDeVeritat {
    public static void main(String[] args) {
        System.out.println("A\tB\tA OR B");
        System.out.println("---------------------");

        boolean A = false;
        boolean B = false;
        System.out.println(A + "\t" + B + "\t" + (A || B));

        A = false;
        B = true;
        System.out.println(A + "\t" + B + "\t" + (A || B));

        A = true;
        B = false;
        System.out.println(A + "\t" + B + "\t" + (A || B));

        A = true;
        B = true;
        System.out.println(A + "\t" + B + "\t" + (A || B));
    }
}
