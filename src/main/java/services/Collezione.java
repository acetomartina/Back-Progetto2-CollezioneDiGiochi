package services;

import acetomartina.entities.Gioco;
import acetomartina.entities.GiocoDaTavolo;
import acetomartina.entities.Videogioco;
import exceptions.GiocoGiaEsistente;
import exceptions.GiocoNonTrovato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Collezione {

    private List<Gioco> giochi;

    public Collezione() {
        this.giochi = new ArrayList<>();
    }

    public List<Gioco> getGiochi() {
        return giochi;
    }

    public void aggiungiGioco(Gioco gioco) {

        if (gioco == null) {
            throw new IllegalArgumentException(
                    "Il gioco non può essere null."
            );
        }

        boolean esiste = giochi.stream()
                .anyMatch(g -> g.getId().equals(gioco.getId()));

        if (esiste) {
            throw new GiocoGiaEsistente(
                    "Esiste già un gioco con questo ID: " + gioco.getTitolo() + " - " + gioco.getId()
            );
        }
        giochi.add(gioco);

    }

    public Gioco cercaPerId(String id) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "L'ID non può essere vuoto."
            );
        }
        return giochi.stream()
                .filter(g -> g.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new GiocoNonTrovato("Nessun gioco trovato con ID: " + id));
    }

    public List<Gioco> cercaPerPrezzo(double prezzo) {

        if (prezzo <= 0.00) {
            throw new IllegalArgumentException(
                    "Ogni gioco deve essere maggiore di 0."
            );
        }
        return giochi.stream()
                .filter(g -> g.getPrezzo() < prezzo)
                .toList();
    }

    public List<GiocoDaTavolo> cercaPerNumeroGiocatori(int numeroGiocatori) {

        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Il numero di giocatori deve essere tra 2 e 10");
        }

        return giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == numeroGiocatori)
                .toList();
    }

    public void rimuoviPerId(String id) {
        Gioco giocoDaRimuovere = cercaPerId(id);
        giochi.remove(giocoDaRimuovere);
    }

    public void aggiornaGioco(String id, Gioco giocoAggiornato) {

        if (giocoAggiornato == null) {
            throw new IllegalArgumentException("Il gioco non può essere null."
            );
        }

        if (!id.equalsIgnoreCase(giocoAggiornato.getId())) {
            throw new IllegalArgumentException(
                    "L'ID non può essere modificato."
            );
        }


        Gioco giocoEsistente = cercaPerId(id);
        int indice = giochi.indexOf(giocoEsistente);
        giochi.set(indice, giocoAggiornato);
    }


    public void stampaStatistiche() {

        long totaleVideogiochi = giochi.stream()
                .filter(g -> g instanceof Videogioco)
                .count();

        long totaleGiochiDaTavolo = giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .count();

        Gioco giocoPiuCostoso = giochi.stream()
                .max(Comparator.comparingDouble(Gioco::getPrezzo))
                .orElseThrow(() -> new GiocoNonTrovato("La collezione è vuota."));

        double mediaPrezzi = giochi.stream()
                .mapToDouble(Gioco::getPrezzo)
                .average()
                .orElse(0.0);


        System.out.println("Il totale dei Videogiochi è: " + totaleVideogiochi);
        System.out.println("Il totale dei giochi da tavolo è: " + totaleGiochiDaTavolo);
        System.out.println("Il gioco -tra tutti- più costoso è: ");
        System.out.println(giocoPiuCostoso);
        System.out.println("La media dei prezzi dei giochi è: " + mediaPrezzi + "€");
    }

    public boolean esisteId(String id) {
        return giochi.stream()
                .anyMatch(g -> g.getId().equalsIgnoreCase(id));
    }


}

