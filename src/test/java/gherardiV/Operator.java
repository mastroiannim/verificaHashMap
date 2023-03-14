package gherardiV;
import java.time.LocalDate;

public class Operator {
    public String name;
    public String surname;
    public LocalDate birthDate;
    private String matricola;

    public Operator(String nome, String cognome, LocalDate nascita){
        this.name = nome;
        this.surname = cognome;
        this.birthDate = nascita;
        this.matricola = generateMatricola();
    }

    public String getMatricola(){
        return this.matricola;
    }

    public String generateMatricola() {
        return "" + this.name.charAt(0) + this.surname.charAt(0) + this.birthDate.toString().replace("-", "");

    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", birthDate=" + this.birthDate +
                ", matricola='" + this.matricola + '\'' +
                '}';
    }
}
