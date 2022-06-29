package fr.diginamic.bll;

public class BLLException extends Exception {

    public BLLException() {
        super();
    }

    public BLLException(String message, Throwable cause) {
        super("Erreur de la BLL " + message, cause);
    }

    public BLLException(String message) {
        super("Erreur de la BLL " + message);
    }
}
