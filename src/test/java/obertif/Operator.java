package obertif;
import java.util.*;
import java.time.LocalDate;
import java.util.Date;

public class Operator
{
    String name; // nome dell’operatore
    String surname; // cognome
    LocalDate birthDate; // data di nascita
    String matricola; // matricola
    
    static int codiceProgressivo = 0;
    public Operator(String n, String c, LocalDate nascita){
        name = n;
        surname = c;
        birthDate = nascita;
        matricola = String.valueOf(codiceProgressivo);
        codiceProgressivo++;
    }
    
    public String getMatricola(){
        return matricola;
    }
    
    public String toString(){
        String s = "";
        s = (" operatore : " + name + "  " + surname + " con matricola: " + matricola + " nato il " + birthDate);
        return s;
    }
}
