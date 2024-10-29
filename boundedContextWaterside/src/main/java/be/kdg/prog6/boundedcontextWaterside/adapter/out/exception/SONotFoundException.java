package be.kdg.prog6.boundedcontextWaterside.adapter.out.exception;

import jakarta.persistence.EntityNotFoundException;

public class SONotFoundException extends EntityNotFoundException {
    public SONotFoundException(String message) {
        super(message);
    }
}
