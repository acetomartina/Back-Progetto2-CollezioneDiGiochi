package acetomartina.entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private double durataMediaMinuti;

    public GiocoDaTavolo(String id, String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, double durataMediaMinuti) {
        super(id, titolo, annoPubblicazione, prezzo);

        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Il numero di giocatori deve essere tra 2 e 10.");
        }

        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaMinuti = durataMediaMinuti;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    @Override
    public String toString() {
        return "Gioco da Tavolo {" + super.toString() +
                ", Giocatori: " + numeroGiocatori +
                ", Durata media: " + durataMediaMinuti + " minuti }";
    }
}
