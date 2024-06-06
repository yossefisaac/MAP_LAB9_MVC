package exceptions;

public class CustomExceptions {
    public static class AssentoIndisponivelException extends Exception {
        public AssentoIndisponivelException() {
            super("Essa cadeira está indisponível, por favor escolha outra!");
        }
    }

    public static class NumeroAssentoInvalidoException extends Exception {
        public NumeroAssentoInvalidoException() {
            super("Número de assento inválido");
        }
    }

    public static class StatusInvalidoException extends Exception {
        public StatusInvalidoException(String message) {
            super(message);
        }
    }

    public static class TentativaLiberarAssentoDisponivelException extends Exception {
        public TentativaLiberarAssentoDisponivelException () {
            super("Assento já está disponível");
        }
    }
}
