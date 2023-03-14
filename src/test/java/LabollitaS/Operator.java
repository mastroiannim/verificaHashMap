package LabollitaS;
import java.time.LocalDate;

public class Operator 
{
    String nome;
    String cognome;
    LocalDate dataNascita;
    String matricola;
    
    public Operator(String n, String c, LocalDate d){
        nome = n;
        cognome = c;
        dataNascita = d;
    }
    
    public String getMatricola(){
        return String.format("%s-%s-%s", cognome.substring(0, 3).toUpperCase(),
            nome.substring(0, 3).toUpperCase(), dataNascita.toString());
    }
    
    public String toString(){
        return "Operatore" +" nome=" + nome +", cognome='" + cognome + ", dataNascita=" + dataNascita;
    }
}
