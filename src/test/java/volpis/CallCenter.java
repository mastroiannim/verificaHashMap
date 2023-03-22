package volpis;
import java.util.*;
import java.time.LocalDate;

public class CallCenter{
    //Punto 1
    private HashMap<String, Operator> operatori;
    private HashMap<Integer, FeedBack> feedbacks;

    //Punto 6
    public CallCenter() {
        operatori = new HashMap<>();
        feedbacks = new HashMap<>();
    }

    //Punto 2
    public String registraOperatore(String nome, String cognome, LocalDate dataNascita) throws NotUniqueOperatorException {
        String matricola = Operator.calcolaMatricola(nome, cognome, dataNascita);
        if (operatori.containsKey(matricola)) {
            throw new NotUniqueOperatorException("Operatore già presente");
        }
        Operator operatore = new Operator(nome, cognome, dataNascita);
        operatori.put(matricola, operatore);
        return matricola;
    }
    
    //Punto 3
    public int registraValutazione(String matricola, int punteggio, LocalDate data) throws InvalidOperatorException {
        Operator operatore = operatori.get(matricola);
        if (operatore == null) {
            throw new InvalidOperatorException("Operatore non trovato");
        }
        FeedBack feedback = new FeedBack(operatore, punteggio, data);
        feedbacks.put(feedback.getId(), feedback);
        return feedback.getId();
    }

    //punto 6
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CallCenter: \n").append("operatori:\n");
        for (Operator op : operatori.values()) {
            sb.append(op.toString()).append("\n");
        }
        sb.append("feedbacks:\n");
        for (FeedBack fb : feedbacks.values()) {
            sb.append(fb.toString()).append("\n");
        }
        return sb.toString();
    }    


    //Punto 7
    public FeedBack[] restituisciValutazioni() {
        return feedbacks.values().toArray(new FeedBack[0]);
    }
    
    //Punto 8
    public int valutazioneComplessiva(String matricola) throws InvalidOperatorException {
        Operator operatore = operatori.get(matricola);
        if (operatore == null) {
            throw new InvalidOperatorException("Operatore non trovato");
        }
        int valutazioneComplessiva = 0;
        for (FeedBack fb : feedbacks.values()) {
            if (fb.getOperatore().equals(operatore)) {
                valutazioneComplessiva += fb.getPunteggio();
            }
        }
        return valutazioneComplessiva;
    }

    //Punto 9    
    public int valutazioneMese(String matricola, int m, int a) throws InvalidOperatorException{
        Operator operatore = operatori.get(matricola);
        if (operatore == null) {
            throw new InvalidOperatorException("Operatore non trovato");
        }
        int valutazioneMese = 0;
        for (FeedBack fb : feedbacks.values()) {
            LocalDate data = fb.getData();
            if (fb.getOperatore().equals(operatore) && data.getMonthValue() == m && data.getYear() == a) {
                valutazioneMese += fb.getPunteggio();
            }
        }
        return valutazioneMese;
    }
    
    public Operator[] valutazioniNegative(){
        ArrayList<Operator> operatoriNegativi = new ArrayList<Operator>();
        for (FeedBack fb : feedbacks.values()) {
            if (fb.getPunteggio() < 0) {
                operatoriNegativi.add(fb.getOperatore());
            }
        }
        return operatoriNegativi.toArray(new Operator[0]);
    }

    public Operator[] best() {
        return null;
    }
    
}