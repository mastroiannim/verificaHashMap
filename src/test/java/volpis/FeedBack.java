package volpis;

import java.time.LocalDate;

public class FeedBack {
    //punto 1
    private static int idCounter = 0;

    private int id;
    private Operator operatore;
    private int punteggio;
    private LocalDate data;

    public FeedBack(Operator operatore, int punteggio, LocalDate data) {
        this.operatore = operatore;
        setPunteggio(punteggio);
        this.data = data;
        this.id = ++idCounter;
    }

    public String getMatricola() {
        return operatore.getMatricola();
    }

    public int getPunteggio() {
        return punteggio;
    }

    public Operator getOperatore() {
        return operatore;
    }
    
    //punto 4
    public void setPunteggio(int punteggio) {
        if (punteggio < -3 || punteggio > 3) {
            throw new IllegalArgumentException("Il punteggio deve essere compreso tra -3 e +3");
        }
        this.punteggio = punteggio;
    }

    public LocalDate getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    //Punto 6
    @Override
    public String toString() {

        return "FeedBack: " +"id:" + id +"| operatore:" + operatore.getMatricola() +"| punteggio:" + punteggio +"| data:" + data;
    }
}
