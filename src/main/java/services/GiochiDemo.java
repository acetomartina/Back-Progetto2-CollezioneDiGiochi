package services;

import acetomartina.entities.Genere;
import acetomartina.entities.GiocoDaTavolo;
import acetomartina.entities.Piattaforma;
import acetomartina.entities.Videogioco;

public class GiochiDemo {

    public static void caricaGiochiDemo(Collezione collezione) {
        collezione.aggiungiGioco(new Videogioco(
                "V001",
                "The Legend of Zelda: Tears of Kingdom",
                2023,
                69.99,
                120,
                Piattaforma.SWITCH,
                Genere.ADVENTURE
        ));


        collezione.aggiungiGioco(new Videogioco(
                "V002",
                "Assassin's Creed: The Ezio Collections",
                2016,
                79.99,
                110,
                Piattaforma.PS5,
                Genere.ACTION
        ));

        collezione.aggiungiGioco(new Videogioco(
                "V003",
                "Outlast",
                2013,
                19.99,
                10,
                Piattaforma.PC,
                Genere.HORROR
        ));

        collezione.aggiungiGioco(new Videogioco(
                "V004",
                "Forza Horizon 5",
                2021,
                59.99,
                60,
                Piattaforma.XBOX,
                Genere.RACING
        ));

        collezione.aggiungiGioco(new GiocoDaTavolo(
                "G001",
                "Disney Villainous",
                2018,
                39.99,
                6,
                60
        ));

        collezione.aggiungiGioco(new GiocoDaTavolo(
                "G002",
                "Risiko",
                1957,
                34.99,
                4,
                120
        ));

        collezione.aggiungiGioco(new GiocoDaTavolo(
                "G003",
                "Cluedo",
                1949,
                29.99,
                5,
                45
        ));

        collezione.aggiungiGioco(new GiocoDaTavolo(
                "G004",
                "Monopoly Game of Thrones",
                2019,
                49.99,
                6,
                120
        ));

    }
}