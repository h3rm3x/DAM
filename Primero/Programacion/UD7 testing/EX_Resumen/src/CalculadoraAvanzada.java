public class CalculadoraAvanzada {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero");
        }
        return a / b;
    }

    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public String obtenerNombreOperacion(String codigo) {
        if (codigo == null) {
            return null;
        }
        return switch (codigo) {
            case "S" -> "Suma";
            case "R" -> "Resta";
            case "M" -> "Multiplicación";
            case "D" -> "División";
            default -> "Desconocido";
        };
    }

    public Object obtenerValorNulo(boolean devolverNulo) {
        return devolverNulo ? null : new Object();
    }

    public boolean esNumeroPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public String clasificarNumero(int numero) {
        if (numero < 0) {
            return "Negativo";
        } else if (numero == 0) {
            return "Cero";
        } else {
            return "Positivo";
        }
    }
}