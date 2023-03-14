package sonzognig;
import java.time.LocalDate;

public class Operator
{
    String name;
    String surname;
    LocalDate birthDate;
    String matricola;
    
    public Operator (String name, String surname, LocalDate birthDate){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        matricola = name + surname + birthDate.getYear();
    }
    
    public String getMatricola(){
        return matricola;
    }
    
    public String toString(){
        String s = "Nome: " + name +" Cognome: " + surname + " Data di nascita: " + birthDate.toString() + " matricola: " + matricola;
        return s;
    }
}
