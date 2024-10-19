package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.exception;

import jakarta.persistence.EntityNotFoundException;

public class AppointmentNotFoundException extends EntityNotFoundException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
