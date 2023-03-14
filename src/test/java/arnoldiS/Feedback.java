package arnoldiS;
import java.time.LocalDate;

public class Feedback
{
    String matricola; // matricola dell’operatore
    int punteggio=0; // compreso tra -3 e +3
    LocalDate data ;// quando è stata ricevuta la valutazione
    int id; // identificativo progressivo univoco
    private int cc;
    public Feedback(Operator o,int p, LocalDate d)
    {
        matricola=o.getMatricola();
        punteggio+=p;
        data=d;
        id=punteggio+cc;
        cc++;
    }
    public String  toString(){
        return "matricola:"+matricola+"; punteggio:"+punteggio+"; data:"+data+"; id:"+id;
    }  
}
