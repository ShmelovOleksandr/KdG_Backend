package be.kdg.prog6.boundedcontextLandside.domain.exception;

import jakarta.persistence.EntityNotFoundException;

public class AppointmentForGivenLicensePlateNotFoundException extends EntityNotFoundException {
    public AppointmentForGivenLicensePlateNotFoundException(String message) {
        super(message);
    }
}
