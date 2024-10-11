package be.kdg.prog6.boundedcontextLandside.domain.exception;

public class IllegalHourException extends RuntimeException {
    public IllegalHourException() {
        super("Illegal hour was provided. Hour should be between 1 and 24.");
    }
}
