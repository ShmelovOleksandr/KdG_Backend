package be.kdg.prog6.boundedcontextLandside.adapter.out.exception;

import jakarta.persistence.EntityNotFoundException;

public class WBTNotFoundException extends EntityNotFoundException {
    public WBTNotFoundException(String message) {
        super(message);
    }
}
