package acetomartina.entities;

public class Videogioco extends Gioco {
    private int durataOre;
    private Piattaforma piattaforma;
    private Genere genere;

    public Videogioco(String id, String titolo, int annoPubblicazione, double prezzo, int durataOre, Piattaforma piattaforma, Genere genere) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }


    @Override
    public String toString() {
        return "Videogioco {" + super.toString() +
                ", Piattaforma: " + piattaforma +
                ", Genere: " + genere +
                ", Durata: " + durataOre + " ore }";
    }


}
