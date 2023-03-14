package montanellim;

import java.time.*;


public class Operator
{
    private String name; // nome dell’operatore
    private String surname; // cognome
    private LocalDate birthDate; // data di nascita
    private String matricola; // matricola
    public Operator(String n, String c, LocalDate nascita)
    {
       this.name = n;
       this.surname = c;
       this.birthDate = nascita;
    }
     public Operator()
    {
    
    }
    
    public String getName (){
        return this.name;
    }
    
    public String getSurname (){
        return this.surname;
    }
   
    public LocalDate getDate(){
        return this. birthDate;
    }
    
    public String getMatricola(){
        return this.matricola;
    }
    
    public void setMatricola(String m){
        this.matricola =m;
    }
    
      public void setName(String namep){
        this.name=namep;
    }
    
    public void setSurname (String sur){
         this.surname=sur;
    }
   
    public void setDate(LocalDate l){
         this.birthDate=l;
    }
    
      public String toString(){
        String bello=("ho il nome "+ name+ " il cognome "+ surname+ " sono nato il "+ birthDate + " e ho una matricola" + matricola);
        return bello;
            
    }
}
