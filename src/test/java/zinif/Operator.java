package zinif;

import java.time.LocalDate;

public class Operator {
    private String name;            // nome dell’operatore
    private String surname;         // cognome
    private LocalDate birthDate;    // data di nascita
    private String matricola;       // matricola

    Operator(String n, String c, LocalDate b, String matricola){
        name = n;
        surname = c;
        birthDate = b;
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    @Override
    public String toString(){
        String message = getMatricola()+": "+getName()+" "+getSurname()+", nato in data: "+getBirthDate()+"\n";
        return message;
    }
}
