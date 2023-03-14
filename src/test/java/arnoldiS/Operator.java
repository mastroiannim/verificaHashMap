package arnoldiS;
import java.time.LocalDate;

public class Operator
{
    String name; // nome dell’operatore
    String surname; // cognome
    LocalDate birthDate; // data di nascita
    String matricola; // matricola
    private int mm=0;
    public Operator(String n, String s,LocalDate b )
    {
        name=n;
        surname=s;
        birthDate=b;
        matricola=getMatricola();
        mm++;
        
    }
    public String getMatricola(){
        matricola=name+surname+mm;
        return matricola;
    }
    public String  toString(){
        return "name:"+name+"; surname:"+surname+"; birthDate:"+birthDate+"matricola:"+matricola;
    }
}
