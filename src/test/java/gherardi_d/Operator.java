package gherardi_d;
import java.time.*;



public class Operator
{
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String matricola;
    private static int n=0;
    
    public Operator(String n, String c, LocalDate d){
        nome=n;
        cognome=c;
        dataNascita=d;
        matricola="o" + Operator.n;
        Operator.n++;
    }
    
    public String getMatricola(){
        return matricola;
    }
    
    public void to_string(){
        System.out.println("matricola: " + matricola);
        System.out.println("data di nascita " + dataNascita);
    }
}
