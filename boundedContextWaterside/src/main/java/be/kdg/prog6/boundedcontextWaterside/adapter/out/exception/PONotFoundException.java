package be.kdg.prog6.boundedcontextWaterside.adapter.out.exception;

import jakarta.persistence.EntityNotFoundException;

public class PONotFoundException extends EntityNotFoundException {
    public PONotFoundException(String message) {
        super(message);
    }
}
