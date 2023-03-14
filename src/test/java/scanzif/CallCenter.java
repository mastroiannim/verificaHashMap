package scanzif;
import java.time.LocalDate;
import java.util.*;

public class CallCenter
{
    HashMap<String, Operator> operatori = new HashMap<String, Operator>();
    int somma;
    int quanteValutazioni = 0;
    int i = 0;
    public CallCenter()
    {
        
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException {
        String matricola = n + c + b;
        if(operatori.containsKey(matricola)){
            throw new NotUniqueOperatorException();
        }else{
            operatori.put(matricola, new Operator(n, c, b, matricola));
            return matricola;
        }
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws scanzif.InvalidOperatorException {
        if(operatori.containsKey(m)){
            int id = operatori.get(m).quanteValutazioni;
            operatori.get(m).feedback.put(id, new Feedback(m, s,d, id));
            operatori.get(m).quanteValutazioni++;
            quanteValutazioni++;
            return id;
        }else{
            throw new InvalidOperatorException();
        }
    }
    
    public String toString(){
        return operatori.toString();
    }
    
    public Feedback[] restituisciValutazioni(){
        i = 0;
        Feedback[] feedbacks = new Feedback[quanteValutazioni];
        operatori.forEach((key, value) ->  
            value.feedback.forEach((k, v) -> {
                feedbacks[i] = v;
                i++;
            })
        );
        return feedbacks;
    }
    
    public int valutazioneComplessiva(String matricola){
        HashMap<Integer, Feedback> a = operatori.get(matricola).feedback;
        somma = 0;
        a.forEach((key, value) -> somma += value.punteggio);
        return somma;
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
class NotUniqueOperatorException extends Exception{}
class InvalidOperatorException extends Exception{}