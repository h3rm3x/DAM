public class Main {
    public static void main(String[] args) {

       int []TaulaA= {50, 45, 13, 14, 35};
       int []TaulaB= {50, 38, 17, 23, 16};
       int []TaulaC= new int[5];
       for (int i = 0;i < 5; i++) {
           TaulaC[i]=TaulaA[i]+TaulaB[i];
           System.out.println("TaulaC[ "+i+"] = "+TaulaC[i]);
       }

    }

}