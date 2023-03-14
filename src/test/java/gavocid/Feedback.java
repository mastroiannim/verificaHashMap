package gavocid;

import java.util.*;
import java.time.LocalDate;

public class Feedback
{
    String matricola; // matricola dell’operatore
    int punteggio; // compreso tra -3 e +3
    LocalDate data; // quando è stata ricevuta la valutazione
    int id; // identificativo progressivo univoco
    
    static int progressivoId = 0;
    
    public Feedback(String m, int s, LocalDate d){
        matricola = m;
        punteggio = s;
        data = d;
        id = Feedback.progressivoId++;
    }
    
    public String toString(){
        return "matricola: " + matricola + "punteggio: " + punteggio + "date: " + data + "id: " + id;
    }

}
