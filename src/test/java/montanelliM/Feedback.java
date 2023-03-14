package montanellim;

import java.time.*;
import java.time.LocalDate;

public class Feedback
{
    String matricola; // matricola dell’operatore
    int punteggio; // compreso tra -3 e +3
    LocalDate data; // quando è stata ricevuta la valutazione
    int id;
    public Feedback(int p, LocalDate l )
    {
        this.punteggio=p;
        this.data=l;
       
    }
    public Feedback()
    {
    
    }
    public int getPunteggio (){
        return this.punteggio;
    }
    
    public int getId (){
        return this.id;
    }
   
    public LocalDate getDate(){
        return this.data;
    }
    
    public String getMatricola(){
        return this.matricola;
    }
    
      public void SetPunteggio (int p){
        this.punteggio=p;
    }
    
    public void setId (int ido){
         this.id=ido;
    }
   
    public void setDate(LocalDate l){
         this.data=l;
    }
    
    public void setMatricola(String m){
       this.matricola=m;
    }

    public String toString(){
        String bello=("ho punteggio "+ punteggio+ " sono stato conferito il "+ data + " e ho una matricola" + matricola+ " ho id "+ id);
        return bello;
            
    }
}
