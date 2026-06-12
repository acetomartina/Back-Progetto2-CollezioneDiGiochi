package acetomartina;

import acetomartina.entities.*;
import exceptions.GiocoNonTrovato;
import services.Collezione;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Collezione collezione = new Collezione();

        Videogioco zelda = new Videogioco(
                "V001",
                "The Legend of Zelda: Tears of Kingdom",
                2023,
                69.99,
                120,
                Piattaforma.SWITCH,
                Genere.ADVENTURE
        );

        Videogioco assassinsCreed = new Videogioco(
                "V002",
                "Assassin's Creed: The Ezio Collections",
                2016,
                79.99,
                110,
                Piattaforma.PS5,
                Genere.ACTION
        );

        Videogioco outlast = new Videogioco(
                "V003",
                "Outlast",
                2013,
                19.99,
                10,
                Piattaforma.PC,
                Genere.HORROR
        );

        Videogioco forzaHorizon = new Videogioco(
                "V004",
                "Forza Horizon 5",
                2021,
                59.99,
                60,
                Piattaforma.XBOX,
                Genere.RACING
        );

        GiocoDaTavolo villainous = new GiocoDaTavolo(
                "G001",
                "Disney Villainous",
                2018,
                39.99,
                6,
                60
        );

        GiocoDaTavolo risiko = new GiocoDaTavolo(
                "G002",
                "Cluedo",
                1957,
                34.99,
                4,
                120
        );

        GiocoDaTavolo cluedo = new GiocoDaTavolo(
                "G003",
                "Cluedo",
                1949,
                29.99,
                5,
                45
        );

        GiocoDaTavolo monopolyGot = new GiocoDaTavolo(
                "G004",
                "Monopoly Game of Thrones",
                2019,
                49.99,
                6,
                120
        );

        collezione.aggiungiGioco(zelda);
        collezione.aggiungiGioco(assassinsCreed);
        collezione.aggiungiGioco(outlast);
        collezione.aggiungiGioco(forzaHorizon);

        collezione.aggiungiGioco(villainous);
        collezione.aggiungiGioco(risiko);
        collezione.aggiungiGioco(cluedo);
        collezione.aggiungiGioco(monopolyGot);

        for (Gioco gioco : collezione.getGiochi()) {
            System.out.println(gioco);
        }

        try {
            System.out.println(collezione.cercaPerId("V999"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       /* List<Gioco> risultati = collezione.cercaPerPrezzo(50);
        if (risultati.isEmpty()) {
            System.out.println("Non sono presenti videogiochi inferiori a questa soglia di prezzo."
            );
        } else {
            risultati.forEach(System.out::println);
        }
    } */

        try {
            List<GiocoDaTavolo> risultati = collezione.cercaPerNumeroGiocatori(19);
            if (risultati.isEmpty()) {
                System.out.println("Non sono presenti giochi con questo numero di giocatori."
                );
            } else {
                risultati.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            collezione.rimuoviPerId("V001");
            System.out.println("Gioco rimosso correttamente!");

            collezione.getGiochi().forEach(System.out::println);
        } catch (GiocoNonTrovato | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        collezione.stampaStatistiche();
    }


}
