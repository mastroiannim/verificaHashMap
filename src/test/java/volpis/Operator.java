package volpis;

import java.time.LocalDate;

public class Operator {
    //Punto 1
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String matricola;

    public Operator(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.matricola = calcolaMatricola(nome, cognome, dataNascita);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }
    
    //Punto 5
    public String getMatricola() {
        return matricola;
    }

    public static String calcolaMatricola(String nome, String cognome, LocalDate dataNascita) {
        String inizialeNome = nome.substring(0, 1).toUpperCase();
        String inizialeCognome = cognome.substring(0, 1).toUpperCase();
        String annoNascita = String.valueOf(dataNascita.getYear());
        System.out.println(inizialeNome + inizialeCognome + annoNascita);
        return inizialeNome + inizialeCognome + annoNascita;
    }

    //Punto 6
    @Override
    public String toString() {
        return "Operator: " +"nome:'" + nome +"| cognome:'" + cognome  +"| dataNascita:" + dataNascita +"| matricola:'" + matricola ;         
    }

}
