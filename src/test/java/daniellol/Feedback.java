package daniellol;
import java.time.LocalDate;

public class Feedback {
    private String matricola;
    private int punteggio;
    private LocalDate date;
    static int id = 0;

    Feedback(String matricola, int punteggio, LocalDate data) {
        this.matricola = matricola;
        this.punteggio = punteggio;
        controllo();
        this.date = data;
        Feedback.id++;
    }

    public int getId() {
        return id;
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
        return "Matricola: " + matricola + "Punteggio: " + punteggio + "Data valutazione: " + date.toString() + "Id: " + id;
    }
}
