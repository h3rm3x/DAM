public class escultura extends Obradearte {
    private String material;

    public escultura(String material, String nombre, int ano_creacion, String autor) {
        super(nombre, ano_creacion, autor);
        this.material = material;

    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public void exhibir() {
        super.exhibir();
        System.out.println("Se esta exhibiendo la escultura " + getNombre() + "hecha por el escultor" + getAutor() + "con " + material);
    }

    public String toString() {
        return "Escultura { \n" + super.toString() + '\n' + "material: " + material + '\n' + "}";
    }
}
