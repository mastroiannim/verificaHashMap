package grecomg;
import java.time.LocalDate;
import java.util.*;


public class CallCenter
{   
    private HashMap<String, Operator> ops;
    private HashMap<String, LinkedList<Feedback>> feeds;
    
    public CallCenter() {
        ops = new HashMap<>();
        feeds = new HashMap<>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException {
        Operator o = new Operator(n, c, b);
        String matricola = getMatricola(o);
        o.setMatricola(matricola);
        if (ops.containsKey(matricola))
            throw new NotUniqueOperatorException();
        o.setMatricola(matricola);
        ops.put(matricola, o);
        feeds.put(matricola, new LinkedList<>());
        return matricola;
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException, InvalidScoreException {
        if (!ops.containsKey(m))
            throw new InvalidOperatorException();
        if (s > 3 || s < -3)
            throw new InvalidScoreException();
        Feedback f = new Feedback(m, s, d);
        feeds.get(m).add(f);
        return f.getId();
    }
    
    public String toString() {
        String s = "";
        
        for (Operator o : ops.values()) {
            s += o+"\n";
        }
        
        for (LinkedList<Feedback> l : feeds.values()) {
            for (Feedback f : l) {
                s += f+"\n";
            }
        }
        
        return s;
    }
    
    public Feedback[] restituisciValutazioni() {
        Feedback[] fs = new Feedback[1000];
        for (LinkedList<Feedback> l : feeds.values()) {
            for (Feedback f : l) {
                fs[fs.length] = f;
            }
        }
        return fs;
    }
    
    public int valutazioneComplessiva(String matricola) {
        if (!ops.containsKey(matricola))
            throw new InvalidOperatorException();
        int p = 0;
        for (LinkedList<Feedback> l : feeds.values()) {
            for (Feedback f : l) {
                if (f.getMatricola().equals(matricola)) {
                    p += f.getPunteggio();
                }
            }
        }
        return p;
    }
    
    public int valutazioneMese(String matricola, int m, int a) {
        if (!ops.containsKey(matricola))
            throw new InvalidOperatorException();
        int p = 0;
        for (LinkedList<Feedback> l : feeds.values()) {
            for (Feedback f : l) {
                LocalDate d = f.getLocalDate();
                if (f.getMatricola().equals(matricola) && d.getMonthValue() == m && d.getYear() == a) {
                    p += f.getPunteggio();
                }
            }
        }
        return p;
    }
    
    public Operator[] valutazioniNegative() {
        Operator[] negOps = new Operator[1000];
        for (Operator o : ops.values()) {
            if (valutazioneComplessiva(o.getMatricola()) < 0)
                negOps[negOps.length] = o;
        }
        return negOps;
    }
    
    public Operator[] best() {
        Operator[] bestOps = new Operator[100];
        int max = 0;
        for (Operator o : ops.values()) {
            int v = valutazioneComplessiva(o.getMatricola());
            if (v > max) {
                bestOps = new Operator[100];
                bestOps[bestOps.length] = o;
                max = v;
            } else if (v == max) {
                bestOps = new Operator[100];
            }
        }
        return bestOps;
    }
    
    private String getMatricola(Operator o)
    {
        return Integer.toString(o.getName().hashCode()) + 
        Integer.toString(o.getSurname().hashCode()) + 
        Integer.toString(o.getBirthDate().hashCode());
    }
}

class NotUniqueOperatorException extends RuntimeException {}
class InvalidOperatorException extends RuntimeException {}
class InvalidScoreException extends RuntimeException {}