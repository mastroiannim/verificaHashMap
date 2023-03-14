package brescianin;
import java.time.LocalDate;

public class Operator
{
    public String name;
    public String surname;
    public LocalDate birthDate;
    public String matricola;
    public Operator(String n, String c, LocalDate b, String matricola) {
        this.name = n;
        this.surname = c;
        this.birthDate = b;
        this.matricola = matricola;
    }
    public String getMatricola() {
        return matricola;
    }
    
    public String toString() {
        return "L'operatore:  [matricola: " + matricola + ", nome: " + name + ", cognome: " + surname + ", data di nascita: " + birthDate + "]\n";
    }
}
