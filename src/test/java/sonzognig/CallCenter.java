package sonzognig;
import java.util.*;
import java.time.LocalDate;

public class CallCenter
{
    public class NotUniqueOperatorException extends RuntimeException{}
    public class InvalidOperatorException extends RuntimeException{}
    public class InvalidScoreException extends RuntimeException{}
    HashMap<String, Operator> operatori;
    HashMap<String, LinkedList> feedbacks;
    
    public CallCenter(){
        operatori = new HashMap<String, Operator>();
        feedbacks = new HashMap<String, LinkedList>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException {
        Operator o = new Operator(n, c, b);
        if(operatori.containsKey(o.getMatricola())){
            throw new NotUniqueOperatorException();
        }
        operatori.put(o.getMatricola(), o);
        return o.getMatricola();
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException, Feedback.InvalidScoreException{
        if(!operatori.containsKey(m)){
            throw new InvalidOperatorException();
        }
        LinkedList<Feedback> feed = new LinkedList<Feedback>();
        Feedback f = new Feedback(m, s, d);
        if(!feedbacks.containsKey(m)){
            feedbacks.put(m, feed);
            feedbacks.get(m).add(f);
        }
        else{
            feedbacks.get(m).add(f);
        }
        return f.getId();
    }
    
    public String toString(){
        String s = "Operatori: " + "\n" + operatori.toString() + "\n" +
                    "Feedbacks: " + "\n" + feedbacks.toString();
        return s;
    }
    
    public Feedback[] restituisciValutazioni(){
        Feedback[] f = feedbacks.values().toArray(new Feedback[feedbacks.size()]);
        return f;
    }
    
    public int valutazioneComplessiva(String matricola) throws InvalidOperatorException{
        if(!operatori.containsKey(matricola)){
            throw new InvalidOperatorException();
        }
        int somma = 0;
        LinkedList feed = feedbacks.get(matricola);
        Iterator<Feedback> i = feed.iterator();
        while(i.hasNext()){
            Feedback u = i.next();
            somma += u.punteggio;
        }
        return somma;
    }
    
    public int valutazioneMese(String matricola, int m, int a) throws InvalidOperatorException{
        if(!operatori.containsKey(matricola)){
            throw new InvalidOperatorException();
        }
        int somma = 0;
        LinkedList feed = feedbacks.get(matricola);
        Iterator<Feedback> i = feed.iterator();
        while(i.hasNext()){
            Feedback u = i.next();
            if(u.data.getYear() == a && u.data.getMonthValue() == m ){
                somma += u.punteggio;
            }
        }
        return somma;
    }
    
    public Operator[] valutazioniNegative() throws InvalidOperatorException {
        List<String> l = new ArrayList<String>(operatori.keySet());
        LinkedList<Operator> o = new LinkedList<Operator>();
        Iterator<String> i = l.iterator();
        while(i.hasNext()){
            String u = i.next();
            int v = valutazioneComplessiva(u);
            if(v < 0){
                o.add(operatori.get(u));
            }
        }
        return o.toArray(new Operator[o.size()]);
    }
    
    public Operator[] best() throws InvalidOperatorException {
        Double max = Double.NEGATIVE_INFINITY;
        List<String> l = new ArrayList<String>(operatori.keySet());
        LinkedList<Operator> o = new LinkedList<Operator>();
        Iterator<String> i = l.iterator();
        while(i.hasNext()){
            String u = i.next();
            double v = valutazioneComplessiva(u);
            if(v > max){
                o = new LinkedList<Operator>();
                o.add(operatori.get(u));
                max = v;
            }
            else if(v == max){
                o.add(operatori.get(u));
            }
        }
        return o.toArray(new Operator[o.size()]);
    }
}
