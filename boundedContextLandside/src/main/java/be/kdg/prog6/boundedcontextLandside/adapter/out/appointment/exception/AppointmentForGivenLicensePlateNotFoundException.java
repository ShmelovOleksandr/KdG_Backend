package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.exception;

import jakarta.persistence.EntityNotFoundException;

public class AppointmentForGivenLicensePlateNotFoundException extends EntityNotFoundException {
    public AppointmentForGivenLicensePlateNotFoundException(String message) {
        super(message);
    }
}
