package zinif;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Iterator;

public class CallCenter {
    class NotUniqueOperatorException extends Exception{
        NotUniqueOperatorException(){
        }
    }
    class InvalidOperatorException extends Exception{
        InvalidOperatorException(){
        }
    }
    Hashtable<String,Operator> operators;
    Hashtable<Integer, Feedback> feedbacks;
    
    CallCenter(){
        operators = new Hashtable<String,Operator>();
        feedbacks = new Hashtable<Integer, Feedback>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException{
        String matricola = n+c+b;
        //controllo
        if(operators.get(matricola) == null){
            //Operator op = new Operator(n, c, b, matricola);
            //operators.put(matricola, op);
            return matricola;
        }
        if(operators.get(matricola) != null ){
            System.out.println(matricola + " è già registrata.");
            throw new NotUniqueOperatorException();
        }
        Operator op = new Operator(n, c, b, matricola);
        operators.put(matricola, op);
        System.out.println("matricola: [" + matricola + "] registrata con successo.");
        return matricola;
    }
    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException{
        //da -3 a +3
        if(operators.get(m) == null){
            System.out.println("Operatore di matricola: ["+m+"] non trovato");
            throw new InvalidOperatorException();
        }
        Feedback fee = new Feedback(m, s, d);
        feedbacks.put(Feedback.getId(), fee);
        return Feedback.getId();
    }
    public Feedback[] restituisciValutazioni(){
        Feedback[] fees = new Feedback[feedbacks.size()];
        Iterator<Feedback> fee = feedbacks.values().iterator();
        int i = 0;
        while(fee.hasNext()){
            fee.next();
            fees[i] = (Feedback)fee;
        }
        return fees;
    }
    public int valutazioneComplessiva(String matricola)throws InvalidOperatorException{
        Iterator<Feedback> fee = feedbacks.values().iterator();
        boolean exists = false;
        while(fee.hasNext()){
            fee.next();
            Feedback matri = (Feedback)fee;
            if(matri.getMatricola() == matricola){
                exists=true;
                break;
            }
        }
        if(!exists){
            throw new InvalidOperatorException();
        }
        int sum = 0;
        fee = feedbacks.values().iterator();
        while(fee.hasNext()){
            fee.next();
            Feedback attuale = (Feedback)fee;
            sum += attuale.getPunteggio();
        }
        return sum;
    }
    public Operator[] valutazioniNegative(){
        Operator[] worst = new Operator[operators.size()];
        Iterator<Operator> op = operators.values().iterator();
        int i = 0;
        while(op.hasNext()){
            op.next();
            Operator attuale = (Operator)op;
            int feedback = 0;
            try {
                feedback = valutazioneComplessiva(attuale.getMatricola());
            } catch (CallCenter.InvalidOperatorException e) {
                e.printStackTrace();
            }
            if(feedback < 0){
                worst[i] = attuale;
                i++;
            }
        }
        return worst;
    }
    public Operator[] best(){
        Operator[] best = new Operator[operators.size()];
        Iterator<Operator> op = operators.values().iterator();
        int i = 0;
        while(op.hasNext()){
            op.next();
            Operator attuale = (Operator)op;
            int feedback = 0;
            try {
                feedback = valutazioneComplessiva(attuale.getMatricola());
            } catch (CallCenter.InvalidOperatorException e) {
                e.printStackTrace();
            }
            if(feedback == 3){
                best[i] = attuale;
                i++;
            }
        }
        return best;
    }
    public int valutazioneMese(String matricola, int m, int a) throws InvalidOperatorException{
        if(operators.get(matricola) == null){
            System.out.println("Operatore di matricola: ["+matricola+"] non trovato");
            throw new InvalidOperatorException();
        }
        int sommaMensile = 0;
        Feedback[] valutazioni = restituisciValutazioni();
        for (Feedback feedback : valutazioni) {
            int mo = feedback.getData().getMonth().getValue();
            int ye = feedback.getData().getYear();
            if(mo == m && ye == a){
                sommaMensile+=feedback.getPunteggio();
            }
        } 
        return sommaMensile;
    }
    @Override
    public String toString(){
        String message = "Operatori registrati: \n";
        Iterator<Operator> op = operators.values().iterator();
        while(op.hasNext()){
            op.next();
            Operator attuale = (Operator)op;
            message+=attuale.toString();
        }
        message += "\nValutazioni registrate: \n";
        Iterator<Operator> fee = operators.values().iterator();
        while(fee.hasNext()){
            fee.next();
            Feedback attuale = (Feedback)fee;
            message+=attuale.toString();
        }
        return message;
    }
}
