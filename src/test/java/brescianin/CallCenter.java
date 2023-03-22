package brescianin;

import java.util.*;
import java.time.*;

public class CallCenter
{
    public HashMap<String, Operator> operators;
    public HashMap<Integer, Feedback> feedbacks;
    public CallCenter(){
        operators = new HashMap<String, Operator>();
        feedbacks = new HashMap<Integer, Feedback>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException {
        String matricola = calcolaMatricola(n, c, b);
        if (operators.containsKey(matricola)) {
            throw new NotUniqueOperatorException();
        }
        Operator operatore = new Operator(n, c, b, matricola);
        operators.put(matricola, operatore);
        return matricola;
    }

    public String calcolaMatricola(String nome, String cognome, LocalDate dataNascita) {
        int hash = nome.hashCode() + cognome.hashCode() + dataNascita.hashCode();
        return  " " + Math.abs(hash);//Math.abs(hash) mi restituisce un valoe positivo
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException {
        Operator operatore = operators.get(m);
        if (operators.containsKey(operatore)) {
            throw new InvalidOperatorException();
        }
        Feedback feed = new Feedback(m, s, d);
        feedbacks.put(feed.getId(), feed);
        return feed.getId();
    }
    public String toString() {
        return "Operatori: " + operators.values() + "\n" + "Valutazioni: " + feedbacks.values()+"\n";
    }
    public Feedback[] restituisciValutazioni(){
         return feedbacks.values().toArray(new Feedback[0]);
    }

    public int valutazioneComplessiva(String matricola) {
        return 0;
    }

    public int valutazioneMese(String matricola, int mese, int anno) {
        return 0;
    }

    public Operator[] best() {
        return null;
    }

    public Operator[] valutazioniNegative() {
        return null;
    }
}
