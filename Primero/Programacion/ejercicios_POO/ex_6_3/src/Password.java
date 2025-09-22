import java.util.Random;
public class Password {
    Random rand  = new Random();
    private String password;
    private int length;
    private final int limiteInfASCII = 33;
    private final int limiteSupASCII = 126;

    public Password() {
        this.length = 8; // Longitud por defecto
        StringBuilder pwd = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (rand.nextInt(limiteSupASCII - limiteInfASCII) + limiteInfASCII);
            pwd.append(randomChar);
        }
        this.password = pwd.toString();
    }


    public Password(int length) {
        this.length = length;
        StringBuilder pwd = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (rand.nextInt(limiteSupASCII - limiteInfASCII) + limiteInfASCII);
            pwd.append(randomChar);
        }
        this.password = pwd.toString();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public boolean esRobusta() {
        boolean esRobusta = false;
        boolean mayus =false;
        boolean minuscula = false;
        boolean numero = false;
        boolean simbolo = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                mayus = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                minuscula = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                numero = true;
            }
            if (!Character.isLetter(password.charAt(i))) {
                simbolo = true;
            }
        }
        if (mayus & minuscula & numero & simbolo) {
            esRobusta = true;
        }
        return esRobusta;
    }
}
