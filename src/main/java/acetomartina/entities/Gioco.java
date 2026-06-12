package acetomartina.entities;

public abstract class Gioco {
    protected String id;
    protected String titolo;
    protected int annoPubblicazione;
    protected double prezzo;


    public Gioco(String id, String titolo, int annoPubblicazione, double prezzo) {
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere un valore positivo.");
        }
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere un valore positivo.");
        }
        this.prezzo = prezzo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Titolo: " + titolo +
                ", Anno: " + annoPubblicazione +
                ", Prezzo: " + prezzo + "€";
    }
}
