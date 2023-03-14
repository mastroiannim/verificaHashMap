package crisafullip;
import java.time.LocalDate;


public class Operator
{
    String name;
    String surname;
    LocalDate birthDate;
    String matricola;
    
    public Operator(String n, String c, LocalDate b, String m){
        this.name = n;
        this.surname = c;
        this.birthDate = birthDate;
        this.matricola = m;
        
    }
    
    public void setMatricola(String mat){
        this.matricola = mat;
    }
    
    public String getMatricola(){
        return matricola;
    }
    
    
    
    public String toString(){
        return "nome: " + name + " ,cognome:  " + surname + " , nascita: " + birthDate +  ", matricola:  " + matricola;
    }
}
