package be.kdg.prog6.boundedcontextWaterside.adapter.out.exception;

import jakarta.persistence.EntityNotFoundException;

public class WarehouseNotFoundException extends EntityNotFoundException {
    public WarehouseNotFoundException(String message) {
        super(message);
    }
}
