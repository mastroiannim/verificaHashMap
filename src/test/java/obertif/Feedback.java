package obertif;
import java.time.LocalDate;

public class Feedback
{
    String matricola; // matricola dell’operatore
    int punteggio; // compreso tra -3 e +3
    LocalDate data; // quando è stata ricevuta la valutazione
    int id;  // identificativo progressivo univoco
    static int codiceProgressivo;
    public Feedback(String m, int s, LocalDate d){
        matricola = m;
        punteggio = s;
        data = d;
        id = codiceProgressivo;
        codiceProgressivo++;
    }
    
    public String toString(){
        String s = "";
        s = ("la matricola : " + matricola + " ha ricevuto un punteggio di : " + punteggio + " il : " + data);
        return s;
    }
    
    public int getPunteggio(){
        return punteggio;
    }
    
    public LocalDate getData(){
        return data;
    }
}
