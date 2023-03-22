package BonacinaG;
import java.util.*;
import java.time.*;

public class CallCenter
{
    LinkedList<Feedback> feedbackOperatori;
    HashMap<String, Operator> operatori;
    private int progressivo = 0;
    
    public CallCenter()
    {
        feedbackOperatori = new LinkedList<>();
        operatori = new HashMap<>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException
    {
        String matricola=n+c+b.toString();
        
        int h = matricola.hashCode();
        h = h % matricola.length();
        h = h < 0 ? -h : h;
        
        if(operatori.containsKey(String.valueOf(h))){ //prima era solo h
            throw new NotUniqueOperatorException();
        }
        
        matricola = String.valueOf(h);
        Operator a = new Operator(n, c, b, matricola);
        operatori.put(matricola, a);
        
        return matricola;
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws PunteggioNonValidoException, NotUniqueOperatorException, InvalidOperatorException
    {
        if(!operatori.containsKey(m)){
            throw new /*NotUniqueOperatorException*/ InvalidOperatorException();
        }
        
        Feedback c = new Feedback(m, s, d, progressivo);
        operatori.get(m).feedback.add(c);
        
        feedbackOperatori.add(c);
        progressivo++;
        return c.id;
    }
    
    @Override
    public String toString(){
        Iterator<Feedback> i = feedbackOperatori.iterator();
        int conta = 0;
        String stringa = "";
        
        while(i.hasNext())
        {
            conta++;
            Feedback u = i.next();
            stringa += String.valueOf(conta)+": "+ u.toString()+"\n";
        }
        
        return stringa;
    }
    
    public Feedback[] restituisciValutazioni() throws PunteggioNonValidoException
    {
        Feedback[] x = new Feedback[feedbackOperatori.size()];
        Iterator<Feedback> i = feedbackOperatori.iterator();
        int conta = 0;
        //String stringa = "";
        
        while(i.hasNext())
        {
            Feedback u = i.next();
            x[conta] = new Feedback(u.matricola, u.punteggio, u.data, u.id);
            conta++;
        }
        
        return x;
    }
    
    public int valutazioneComplessiva(String matricola) throws NotUniqueOperatorException
    {
        if(!operatori.containsKey(matricola)){
            throw new NotUniqueOperatorException();
        }
        
        int totale = 0;
        Operator x = operatori.get(matricola);
        Iterator<Feedback> i = x.feedback.iterator();
        
        while(i.hasNext())
        {
            Feedback u = i.next();
            totale += u.punteggio;
        }
        
        return totale;
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
