public class Pintura extends Obradearte {
    private String tecnica;

    // contructor
    public Pintura(String nombre, int ano_creacion, String autor, String tecnica) {
        super(nombre, ano_creacion, autor);
        this.tecnica = tecnica;
    }

    // getters y setters
    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    //metodos
    //
    public void vender(int precio, String nombre_comprador) {
        System.out.println("La obra: " + getNombre() + "ha sido vendida a " + nombre_comprador + "por " + precio + "€");

    }


    public void exhibir() {
        System.out.println("La pintura: " + getNombre() + "hecha con la tecnica" + tecnica + "del pintor " + getAutor() + " esta siendo exhibida");
        super.exhibir();
    }

    public String toString() {
        return "Pintura { \n" + super.toString() + '\n' + "tecnica: " + tecnica + '\n' + "}";
    }


}
