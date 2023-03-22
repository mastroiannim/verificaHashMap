package daniellol;
import java.time.LocalDate;

public class Feedback {
    private String matricola;
    private int punteggio;
    private LocalDate date;
    private int id_private = 0;
    static int id = 0;

    Feedback(String matricola, int punteggio, LocalDate data) {
        this.matricola = matricola;
        this.punteggio = punteggio;
        controllo();
        this.date = data;
        id_private = Feedback.id;
        Feedback.id++;
    }

    public int getId() {
        return id_private;
    }

    public String getMatricola() {
        return matricola;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public LocalDate getDate() {
        return date;
    }

    private void controllo() {
        if (this.punteggio < -3) {
            this.punteggio = -3;
        }
        if (this.punteggio > 3) {
            this.punteggio = 3;
        }
    }

    public String toString() {
        return "Matricola: " + matricola + " Punteggio: " + punteggio + " Data valutazione: " + date.toString() + " Id: " + getId();
    }
}
