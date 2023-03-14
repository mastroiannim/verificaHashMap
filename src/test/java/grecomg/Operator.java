package grecomg;
import java.time.LocalDate;

public class Operator
{
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String matricola;
    
    public Operator(String n, String s, LocalDate b)
    {
        name = n;
        surname = s;
        birthDate = b;
    }
    
    public String toString() {
        return "Nome operatore: "+name+
        "; Cognome operatore: "+surname+
        "; Data di nascita operatore: "+birthDate+
        "; Matricola operatore: "+matricola;
    }
    
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public LocalDate getBirthDate() {return birthDate;}
    public String getMatricola() {return matricola;}
    public void setMatricola(String m) {matricola = m;}
}
