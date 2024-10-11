package be.kdg.prog6.boundedcontextLandside.domain.exception;

public class NoFreeAppointmentsSlots extends RuntimeException {
    public NoFreeAppointmentsSlots(String message) {
        super(message);
    }
}
