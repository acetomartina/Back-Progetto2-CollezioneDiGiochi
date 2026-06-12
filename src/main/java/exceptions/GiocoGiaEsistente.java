package exceptions;

public class GiocoGiaEsistente extends RuntimeException {
    public GiocoGiaEsistente(String message) {
        super(message);
    }
}
