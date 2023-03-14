package tascal;
import java.time.LocalDate;


public class Operator
{
    String nome;
    String cognome;
    LocalDate dataNascita;
    String matricola;
    public Operator(String nome, String cognome, LocalDate dataNascita){
        nome = nome;
        cognome = cognome;
        dataNascita = dataNascita;
    }
    
    public String getMatricola(String n, String c, LocalDate dN){
        matricola = ("n: " + n + ", c: " + c + ", dN: " + dN);
        return matricola;
    }

    public String getMatricola(){
        matricola = ("n: " + nome + ", c: " + cognome + ", dN: " + dataNascita);
        return matricola;
    }
}
