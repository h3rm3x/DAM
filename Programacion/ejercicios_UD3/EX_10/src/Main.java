public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 0;
        a = a + a * ( a + a * (a + a));
        System.out.println(a);
    }
}