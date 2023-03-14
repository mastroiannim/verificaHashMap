

public class Istruzioni
{
    /*
   L’amministratore di un call center richiede lo sviluppo di un sistema per memorizzare e analizzare le
valutazioni ricevuti dai propri operatori.
1. Implementare la classe CallCenter utilizzando tabelle ad indirizzamento hash che memorizzano
oggetti di tipo Operator e Feedback.
Ogni operatore deve essere memorizzato specificando il nome, il cognome e la data di nascita.
2. Implementare nella classe CallCenter un metodo che calcola e restituisce la matricola
specificando il nome (String), cognome (String) e la data di nascita (java.time.LocalDate)
dell’operatore; il metodo solleva una NotUniqueOperatorException se esiste già un operatore
con la stessa matricola.
Implementare String registraOperatore(String n, String c, LocalDate b)
Ciascuna valutazione deve essere memorizzata specificando la matricola dell’operatore (String), il
punteggio (int) di feedback assegnatogli (da -3 a +3), e la data (java.time.LocalDate) in cui la
valutazione è stata ricevuta.
3. Implementare nella classe CallCenter un metodo che calcola e restituisce l’identificativo di una
valutazione specificando la matricola dell’operatore, il punteggio e la data della valutazione; il
metodo solleva una InvalidOperatorException se l’operatore non esiste.
Implementare int registraValutazione(String m, int s, LocalDate d)
4. Modellare la classe Feedback per memorizzare le valutazioni.
Implementare la classe includendo almeno le seguenti caratteristiche:
String matricola // matricola dell’operatore
int punteggio // compreso tra -3 e +3
LocalDate data // quando è stata ricevuta la valutazione
int id // identificativo progressivo univoco
5. Modellare la classe Operator per memorizzare gli operatori.
Implementare la classe includendo almeno il metodo getMatricola() le seguenti
caratteristiche:
String name; // nome dell’operatore
String surname; // cognome
LocalDate birthDate; // data di nascita
String matricola; // matricola
6. Per le classi Operator, Feedback e CallCenter:
implementare dei metodi toString() che siano significativi;
implementare nella classe CallCenter un costruttore senza argomenti.

continua...

1/2

Verifica: Strutture dati in Java - HashMap 07/03/2023

Il sistema deve poi consentire quanto segue:
7. Restituzione di tutte le valutazioni registrate.
Implementare public Feedback[] restituisciValutazioni()
8. Calcolo della valutazione complessiva di un operatore (somma di tutti i punteggi registrati nelle
valutazioni che lo riguardano); il metodo solleva una InvalidOperatorException se l’operatore
non esiste.
Implementare public int valutazioneComplessiva(String matricola)
9. Calcolo della valutazione di un operatore in un determinato mese di un determinato anno;
il metodo solleva una InvalidOperatorException se l’operatore non esiste.
Implementare public int valutazioneMese(String matricola, int m, int a)
10.Calcolo dell’insieme di operatori con una valutazione complessiva negativa.
Implementare public Operator[] valutazioniNegative()
11.Calcolo dell’insieme dei migliori operatori (ovvero degli operatori con valutazione complessiva
massima).
Implementare public Operator[] best()

Per la valutazione considerare un punto per ognuno dei seguenti item completo e corretto:
1. metodi toString() + costruttori
2. registraOperatore()
3. registraOperatore() che scatena NotUniqueOperatorException
4. registraValutazione()
5. registraValutazione() che scatena InvalidOperatorException
6. restituisciValutazioni()
7. valutazioneComplessiva()
8. valutazioniMese()
9. valutazioniNegative() + getMatricola()
10. best() + getMatricola()

NB. (pdp)
4. metodi toString() + costruttori
5. registraOperatore() + getMatricola()
6. registraValutazione()
7. registraOperatore() che scatena NotUniqueOperatorException
8. registraValutazione() che scatena InvalidOperatorException
9. restituisciValutazioni()
10.valutazioneComplessiva()
*/
}
