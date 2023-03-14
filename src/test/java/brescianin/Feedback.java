package brescianin;
import java.time.LocalDate;

public class Feedback
{
    public String matricola;
    public int punteggio;
    public LocalDate data;
    public int id;
    public static int progressivo = 1;

    public Feedback(String matricola, int punteggio, LocalDate data) {
        this.matricola = matricola;
        this.punteggio = punteggio;
        this.data = data;
        this.id = progressivo++;
    }

    public String getMatricola() {
        return matricola;
    }

    public int getId() {
        return id;
    }
    public String toString() {
        return "Feedback [id=" + id + ", matricola operatore=" + matricola + ", punteggio=" + punteggio + ", data=" + data + "]\n";
    }
}
