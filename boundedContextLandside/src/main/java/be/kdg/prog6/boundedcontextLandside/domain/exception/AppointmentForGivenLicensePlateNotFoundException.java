package be.kdg.prog6.boundedcontextLandside.domain.exception;

public class AppointmentForGivenLicensePlateNotFoundException extends RuntimeException {
    public AppointmentForGivenLicensePlateNotFoundException(String message) {
        super(message);
    }
}
