package daniellol;
import java.time.LocalDate;
import java.util.*;

public class CallCenter {
    //HashMap<Operator, Feedback> feedbacks;

    HashMap<String, Operator> operators;
    HashMap<Integer, Feedback> feedback;

    CallCenter() {
        //feedbacks = new HashMap<Operator, Feedback>();

        operators = new HashMap<String, Operator>();
        feedback = new HashMap<Integer, Feedback>();
    }

    public String registraOperatore(String n, String c, LocalDate d) throws NotUniqueOperatorException {
        Operator op = new Operator(n, c, d);

        if (operators.containsKey(op.getMatricola())) {
            throw new NotUniqueOperatorException();
        }

        operators.put(op.getMatricola(), op);
        
        return op.getMatricola();
    }

    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException {
        if (!operators.containsKey(m.toLowerCase())) {
            throw new InvalidOperatorException();
        }
        
        Feedback feed = new Feedback(m.toLowerCase(), s, d);

        feedback.put(feed.getId(), feed);

        return feed.getId();
    }

    public String toString() {
        String operatori = operators.toString();
        String feedbackString = feedback.toString();

        return "Operatori: " + operatori + "\nFeedbacks: " + feedbackString;
    }

    public Feedback[] restituisciValutazioni() {
        ArrayList<Feedback> f = new ArrayList<Feedback>();       
        feedback.forEach((key, value) -> {
            f.add(value);
        });

        return (Feedback[]) f.toArray();
    }

    public Operator[] restituisciOperatori() {
        ArrayList<Operator> f = new ArrayList<Operator>();       
        operators.forEach((key, value) -> {
            f.add(value);
        });

        return (Operator[]) f.toArray();
    }

    public int valutazioneComplessiva(String matricola) throws InvalidOperatorException {
        if (!operators.containsKey(matricola.toLowerCase())) {
            throw new InvalidOperatorException();
        }

        int valutazioneTot = 0;
        Feedback[] f = restituisciValutazioni();

        for (int i = 0; i < f.length; i++) {
            if (f[i].getMatricola().equals(matricola)) {
                valutazioneTot += f[i].getPunteggio();
            }
        }
        
        return valutazioneTot;
    }

    public int valutazioneMese(String matricola, int m, int a) throws InvalidOperatorException {
        if (!operators.containsKey(matricola.toLowerCase())) {
            throw new InvalidOperatorException();
        }

        int valutazioneTot = 0;
        Feedback[] f = restituisciValutazioni();

        for (int i = 0; i < f.length; i++) {
            if (f[i].getMatricola().equals(matricola) && f[i].getDate().getMonthValue() == m && f[i].getDate().getYear() == a) {
                valutazioneTot += f[i].getPunteggio();
            }
        }

        return valutazioneTot;
    }

    public Operator[] valutazioniNegative() throws InvalidOperatorException {
        Operator[] op = restituisciOperatori();
        Feedback[] f = restituisciValutazioni();
        ArrayList<Operator> negativi = new ArrayList<Operator>();

        for (int i = 0; i < op.length; i++) {
            if (valutazioneComplessiva(f[i].getMatricola()) < 0) {
                negativi.add(op[i]);
            }
        }

        return (Operator[]) negativi.toArray();
    }

    public Operator[] best() {
        return null;
    }
}
