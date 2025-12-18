public class Main { // Asume fichero llamado Main.java
    
    static java.util.Scanner in;
    
    public static void casoDePrueba() {
        int toneladas, distancia, peniques_por_ton_milla;
        int coste_combustible, coste_mantenimiento, salario_peones;
        
        // Leer los datos del caso
        toneladas = in.nextInt();
        distancia = in.nextInt();
        peniques_por_ton_milla = in.nextInt();
        coste_combustible = in.nextInt();
        coste_mantenimiento = in.nextInt();
        salario_peones = in.nextInt();
        
        // Calcular ingresos
        int ingresos = toneladas * distancia * peniques_por_ton_milla;
        
        // Calcular gastos
        int gasto_combustible = coste_combustible * distancia * 2; // ida y vuelta
        int gastos_totales = gasto_combustible + coste_mantenimiento + salario_peones;
        
        // Calcular beneficio
        int beneficio = ingresos - gastos_totales;
        
        // Mostrar resultado
        System.out.println(beneficio);
    }
    
    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        int numCasos = in.nextInt();
        
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}