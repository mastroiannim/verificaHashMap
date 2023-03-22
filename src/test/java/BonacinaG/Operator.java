package BonacinaG;
import java.util.*;
import java.time.LocalDate;

public class Operator
{
    public String nome;
    public String cognome; 
    public LocalDate dataDiNascita;
    public String matricola;
    LinkedList<Feedback> feedback;
    
    public Operator(String nome,String cognome,LocalDate dataDiNascita, String matricola)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.matricola = matricola;
        this.feedback = new LinkedList<>();
    }
      
    /*public void aggiungiOperatore(Operator p)
    {
        operatori.add(p);
    }*/
    
    public String getMatricola()
    {
        return this.matricola;
    }
    
    @Override
    public String toString(){
        String x = "";
        Iterator<Feedback> i = feedback.iterator();
        
        while(i.hasNext())
        {
            Feedback u = i.next();
            x += u;
        }
        
        return this.nome + " " + this.cognome + " " + this.dataDiNascita.toString() + " " + this.matricola + " " + x;
    }
}
