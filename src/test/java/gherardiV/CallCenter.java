package gherardiV;
import java.util.*;
import java.time.LocalDate;

public class CallCenter {
    HashMap<String, Operator> operators;
    HashMap<String, LinkedList<Feedback>> feedbacks;

    public CallCenter(){
        this.operators = new HashMap<>();
        this.feedbacks = new HashMap<>();
    }

    public String registraOperatore(String name, String surname, LocalDate birthDate) throws NotUniqueOperatorException{
        Operator operator = new Operator(name, surname, birthDate);
        if(this.operators.containsKey(operator.getMatricola())){
            throw new NotUniqueOperatorException("operatore con la stessa matricola gia esistente");
        }
        this.operators.put(operator.getMatricola(), operator);

        return operator.getMatricola();
    }

    public int registraValutazione(String matricola, int punteggio, LocalDate data) throws InvalidOperatorException{
        if (!this.operators.containsKey(matricola)) {
            throw new InvalidOperatorException("Operatore non trovato con matricola: " + matricola);
        }
        Feedback feedback = new Feedback(matricola, punteggio, data);
        if (!this.feedbacks.containsKey(matricola)) {
            this.feedbacks.put(matricola, new LinkedList<>());
        }
        this.feedbacks.get(matricola).add(feedback);
        return feedback.id;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Operator operator : this.operators.values()) {
            string.append(operator.toString()).append("\n");
        }
        string.append("------------------------\n");
        for (LinkedList<Feedback> feedbackList : this.feedbacks.values()) {
            for (Feedback feedback : feedbackList) {
                string.append(feedback.toString()).append("\n");
            }
        }
        return string.toString();
    }

    public Feedback[] restituisciValutazioni(){
        //Collection<LinkedList<Feedback>> values = this.feedbacks.values();
        //LinkedList<Feedback> tuttiValutazioni = new LinkedList<>();
        //for (LinkedList<Feedback> feedbackList : values) {
        /*    for (Feedback feedback : feedbackList) {
                tuttiValutazioni.add(feedback);
            }
        }
        return tuttiValutazioni.toArray(new Feedback[tuttiValutazioni.size()]);*/
        Collection<LinkedList<Feedback>> values = this.feedbacks.values();
        int totalSize = 0;
        for (LinkedList<Feedback> feedbackList : values) {
            totalSize += feedbackList.size();
        }
        Feedback[] result = new Feedback[totalSize];
        int index = 0;
        for (LinkedList<Feedback> feedbackList : values) {
            for (Feedback feedback : feedbackList) {
                result[index] = feedback;
                index++;
            }
        }
        return result;
    }
    public int valutazioneComplessiva(String matricola) throws InvalidOperatorException{
        if(!this.feedbacks.containsKey(matricola)){
            throw new InvalidOperatorException("l'operatore con questa matricola non esiste");
        }
        int tot = 0;
        LinkedList<Feedback> feedbackList = this.feedbacks.get(matricola);
        for (Feedback feedback : feedbackList) {
            tot += feedback.punteggio;
        }
        return tot;
    }

    public int valutazioneMese(String matricola, int mese, int anno) throws InvalidOperatorException{
        if(!this.feedbacks.containsKey(matricola)){
            throw new InvalidOperatorException("l'operatore con questa matricla non esiste");
        }
        int tot = 0;
        LinkedList<Feedback> feedbackList = this.feedbacks.get(matricola);
        for (Feedback feedback : feedbackList) {
            if(feedback.data.getMonthValue() == mese && feedback.data.getYear() == anno){
                tot += feedback.punteggio;
            }
        }
        return tot;
    }

    public Operator[] valutazioniNegative() throws InvalidOperatorException{
        int count = 0;
        for (Operator operator : this.operators.values()){
            if(this.valutazioneComplessiva(operator.getMatricola()) < 0) count++;
        }
        Operator[] res = new Operator[count];
        int index = 0;
        for(Operator operator : this.operators.values()){
            if(this.valutazioneComplessiva(operator.getMatricola()) < 0){
                res[index] = operator;
                index++;
            }
        }
        return res;
    }

    public Operator[] best() throws InvalidOperatorException {
        int maxValutazione = Integer.MIN_VALUE;
        int count = 0;
        for (Operator operator : this.operators.values()) {
            int valutazioneCorrente = this.valutazioneComplessiva(operator.getMatricola());
            if (valutazioneCorrente > maxValutazione) {
                maxValutazione = valutazioneCorrente;
                count = 1;
            } else if (valutazioneCorrente == maxValutazione) {
                count++;
            }
        }

        Operator[] res = new Operator[count];
        int index = 0;
        for (Operator operator : this.operators.values()) {
            int valutazioneCorrente = this.valutazioneComplessiva(operator.getMatricola());
            if (valutazioneCorrente == maxValutazione) {
                res[index] = operator;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // fare il package: gherardiV
        try {
            CallCenter c = new CallCenter();
            c.registraOperatore("victor", "gherardi", LocalDate.of(2005, 6, 10));
            c.registraOperatore("gabriele", "sonzogno", LocalDate.of(2005, 10, 10));

            c.registraValutazione("vg20050610", 2, LocalDate.now());
            c.registraValutazione("vg20050610", 90, LocalDate.now());
            // c.registraValutazione("vg20050610", -40, LocalDate.now());
            c.registraValutazione("gs20051010", 5, LocalDate.now());
            c.registraValutazione("gs20051010", 40, LocalDate.now());
            System.out.println("restituisci valutazioni");
            System.out.println(c.restituisciValutazioni().toString());
            System.out.println("vlutazioni complessiva");
            System.out.println(c.valutazioneComplessiva("vg20050610"));
            System.out.println("operatori negativi");
            System.out.println(c.valutazioniNegative().toString());
            System.out.println("operatori migliori");
            System.out.println(c.best().toString());

            System.out.println("tutto");
            System.out.println(c.toString());
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}

class NotUniqueOperatorException extends RuntimeException {
    public NotUniqueOperatorException(String message) {
        super(message);
    }
}

class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
