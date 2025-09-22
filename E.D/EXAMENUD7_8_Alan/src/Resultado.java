public class Resultado {
    private int aciertos;
    private int coincidencias;
    private int intentos;
    public Resultado (int aciertos, int coincidencias, int intentos){
        this.aciertos = aciertos;
        this.coincidencias = coincidencias;
        this.intentos = intentos;
    }

    public boolean mensajeResultado(){
        if (aciertos == 4) {
            System.out.println("�Has adivinado la combinaci�n secreta en " + intentos + " intentos!");
            return true;
        } else {
            System.out.println("Aciertos en posici�n correcta: " + aciertos);
            System.out.println("Aciertos en posici�n incorrecta: " + coincidencias);
            return false;
        }
    }


}
