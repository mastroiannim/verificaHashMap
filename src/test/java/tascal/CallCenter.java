package tascal;
import java.util.*;
import java.time.LocalDate;


public class CallCenter
{
    HashMap<Operator, Feedback> callCenter;
    
    public CallCenter(){
        callCenter = new HashMap<>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException{
        Operator o = new Operator(n, c, b);
        if (callCenter.containsKey(o)){
            throw new NotUniqueOperatorException();
        }
        callCenter.put(o, new Feedback());
        return (o.getMatricola(n, c, b));
    }
    
    public int registraValutazione(String m, int s, LocalDate d){
        Feedback f = new Feedback(m, s, d);
        
        return -1;
    }

    public Feedback[] restituisciValutazioni() {
        return null;
    }

    public int valutazioneComplessiva(String matricola) {
        return 0;
    }

    public Operator[] valutazioniNegative() {
        return null;
    }

    public int valutazioneMese(String matricola, int mese, int anno) {
        return 0;
    }

    public Operator[] best() {
        return null;
    }
}
