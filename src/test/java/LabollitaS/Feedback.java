package LabollitaS;
import java.time.LocalDate;

public class Feedback
{
    String matricola;
    int punteggio;
    LocalDate data;
    int id;
    static int idProgressivo = 0;
    
    public Feedback(String m, int p, LocalDate d){
        matricola = m;
        punteggio = p;
        data = d;
        id = idProgressivo;
        idProgressivo++;
    }
    
    public String getMatricola(){
        return matricola;
    }

    public int getPunteggio(){
        return punteggio;
    }
}
