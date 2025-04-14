class Persona {
    private String dni;
    private int edat;
    private String nom;

    public Persona(String nom, int edat, String dni) {
        this.dni = dni;
        this.edat = edat;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nom: " + nom + "Edat: " + edat;
    }
}
