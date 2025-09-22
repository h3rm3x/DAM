public class Fecha {
    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        if (esValida(dia, mes, ano)) {

            this.dia = dia;
            this.mes = mes;
            this.ano = ano;

        }
    }

    private boolean esValida(int dia, int mes, int ano) {
        if (dia < 1 || mes < 1 || mes > 12) {
            return false;
        }
        int diasDelmes = DiasDelMes(mes);
       // System.out.println(diasDelmes<=dia);    //test
       // System.out.println(diasDelmes+" <="+ dia); //test
        return diasDelmes >= dia;
    }
    private int DiasDelMes(int mes) {
        int dias = 0;
        switch (mes) {
            case 4: case 6: case 9: case 11:
                dias = 30;
                break;
            case 2:
                if (Esbisiesto(ano)) {
                    dias = 29;
               }
                else
                    dias = 28;
                break;
            default: dias = 31; break;
        }
        return dias;
    }
    private boolean Esbisiesto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }
    public void SetDia(int dia) {
        this.dia = dia;
    }
    public void SetMes(int mes) {
        this.mes = mes;
    }
    public void SetAno(int ano) {
        this.ano = ano;
    }
    public int GetDia() {
        return this.dia;
    }
    public int GetMes() {
        return this.mes;
    }
    public int GetAno() {
        return this.ano;
    }
    public Fecha manana(){
        dia+=1;
        if (dia>DiasDelMes(mes)) {
            dia=1;
            mes++;

            if (mes>12){
                mes=1;
                ano+=1;
            }
        }
        return Fecha.this;

    }
}
