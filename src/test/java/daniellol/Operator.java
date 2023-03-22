package daniellol;

import java.time.LocalDate;

public class Operator {
    private String matricola;
    private String name;
    private String surname;
    private LocalDate birth;
    
    Operator(String name, String surname, LocalDate birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        creaMatricola();
    }

    private void creaMatricola() {
        this.matricola = (name + surname).toLowerCase();
    }

    public String getSurname() {
        return surname;
    }

    public String getBirth() {
        return birth.toString();
    }

    public String getName() {
        return name;
    }

    public String getMatricola() {
        return matricola;
    }

    public String toString() {
        return "\nNome: " + name + "\nCognome: " + surname + "\nNascita: " + birth.toString() + "\nMatricola: " + matricola;
    }
}
