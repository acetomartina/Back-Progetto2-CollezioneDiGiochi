package acetomartina;

import acetomartina.entities.*;
import exceptions.GiocoNonTrovato;
import services.Collezione;
import services.GiochiDemo;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Collezione collezione = new Collezione();
        GiochiDemo.caricaGiochiDemo(collezione);

        int scelta = -1;

        while (scelta != 0) {
            System.out.println("\nBenvenuto nella nostra Game Colletion!");
            System.out.println("Cosa ti andrebbe di fare?");
            System.out.println("1 - Visualizza catalogo disponibile");
            System.out.println("2 - Aggiungi gioco");
            System.out.println("3 - Cerca gioco per ID");
            System.out.println("4 - Cerca giochi per prezzo");
            System.out.println("5 - Cerca giochi da tavolo per numero giocatori");
            System.out.println("6 - Rimuovi gioco");
            System.out.println("7 - Aggiorna gioco");
            System.out.println("8 - Visualizza statistiche");
            System.out.println("0 - Esci");

            try {
                scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1 -> {
                        System.out.println("--- CATALOGO DISPONIBILE ---");
                        System.out.println();
                        collezione.getGiochi().forEach(System.out::println);
                    }

                    case 2 -> {
                        System.out.println("Che tipo di gioco vuoi aggiungere?");
                        System.out.println("1 - Videogioco");
                        System.out.println("2 - Gioco da tavolo");

                        int tipoGioco = Integer.parseInt(scanner.nextLine());

                        String id;

                        while (true) {
                            System.out.println(
                                    "Inserisci l'ID (formato: V seguito da numeri, es. V005)"
                            );

                            id = scanner.nextLine().toUpperCase();
                            if (id.matches("V\\d{3}")) {
                                break;
                            }
                        }
                        System.out.println("ID non valido. Deve iniziare con V ed essere seguito da 3 numeri. Esempio: V005.");


                        System.out.println("Inserisci il titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.println("Anno di pubblicazione: ");
                        int anno = Integer.parseInt(scanner.nextLine());

                        System.out.println("Prezzo: ");
                        double prezzo = Integer.parseInt(scanner.nextLine());

                        switch (tipoGioco) {
                            case 1 -> {
                                System.out.println("Piattaforme disponibili: PC, PS5, XBOX, SWITCH");
                                System.out.println("Piattaforma: ");
                                Piattaforma piattaforma = Piattaforma.valueOf(scanner.nextLine().toUpperCase());

                                System.out.println("Generi disponibili: ACTION, ADVENTURE, RPG, STRATEGY, SPORT, HORROR, SHOOTER, RACING");
                                System.out.println("Genere: ");
                                Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());

                                System.out.println("Durata di gioco in ore: ");
                                int durataOre = Integer.parseInt(scanner.nextLine());

                                Videogioco videogioco = new Videogioco(
                                        id,
                                        titolo,
                                        anno,
                                        prezzo,
                                        durataOre,
                                        piattaforma,
                                        genere
                                );

                                collezione.aggiungiGioco(videogioco);
                                System.out.println("Videogioco aggiunto correttamente!");

                            }
                        }


                    }

                    case 3 -> {
                        System.out.println("Inserisci l'ID del gioco: ");
                        String id = scanner.nextLine();

                        Gioco gioco = collezione.cercaPerId(id);

                        System.out.println("\nGioco trovato!");
                        System.out.println(gioco);
                    }

                    case 4 -> {
                        System.out.println("Inserisci la soglia di prezzo: ");
                        double prezzo = Double.parseDouble(scanner.nextLine());

                        List<Gioco> risultati = collezione.cercaPerPrezzo(prezzo);

                        if (risultati.isEmpty()) {
                            System.out.println("Non sono presenti giochi inferiori a questa soglia di prezzo.");
                        } else {
                            System.out.println("--- RISULTATI ---");
                            risultati.forEach(System.out::println);
                        }
                    }

                    case 5 -> {
                        System.out.println("Inserisci il numero dei giocatori: ");
                        int numeroGiocatori = Integer.parseInt(scanner.nextLine());

                        List<GiocoDaTavolo> risultati = collezione.cercaPerNumeroGiocatori(numeroGiocatori);

                        if (risultati.isEmpty()) {
                            System.out.println("Non sono presenti giochi da tavolo con questo numero di giocatori.");
                        } else {
                            System.out.println("---RISULTATI---");
                            risultati.forEach(System.out::println);
                        }
                    }

                    case 6 -> {
                        System.out.println("Inserisci l'ID del gioco da rimuovere: ");
                        String id = scanner.nextLine();

                        collezione.rimuoviPerId(id);
                        System.out.println("Gioco rimosso correttamente.");
                    }

                    case 8 -> {
                        System.out.println("--- STATISTICHE ---");
                        collezione.stampaStatistiche();
                    }

                    case 0 -> System.out.println("Uscita dal programma. Alla prossima!");
                    default -> System.out.println("Scelta non valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero valido");
            } catch (IllegalArgumentException | GiocoNonTrovato e) {
                System.out.println(e.getMessage());
            }


        }
    }


}
