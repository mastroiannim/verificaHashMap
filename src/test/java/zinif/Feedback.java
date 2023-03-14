import java.time.LocalDate;

public class Feedback {
    private String matricola;           // matricola dell’operatore
    private int punteggio;              // compreso tra -3 e +3
    private LocalDate data;             // quando è stata ricevuta la valutazione
    private static int id;              // identificativo progressivo univoco
    private int idUnivoco;
    Feedback(String matricola, int punteggio, LocalDate data){
        this.matricola = matricola;
        this.punteggio = punteggio;
        idUnivoco = id;
        id++;
        this.data = data;
    }

    public String getMatricola() {
        return matricola;
    }
    public int getPunteggio() {
        return punteggio;
    }
    public LocalDate getData() {
        return data;
    }
    public static int getId() {
        return id;
    }
    public int getIdUnivoco() {
        return idUnivoco;
    }

    @Override
    public String toString(){
        String message = "Registrazione n."+getIdUnivoco()+": Operatore "+ getMatricola()+" con punteggio "+getPunteggio()+"\n"; 
        return message;
    }
}
