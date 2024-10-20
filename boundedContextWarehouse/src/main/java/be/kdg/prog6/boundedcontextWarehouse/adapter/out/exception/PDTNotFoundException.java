package be.kdg.prog6.boundedcontextWarehouse.adapter.out.exception;

import jakarta.persistence.EntityNotFoundException;

public class PDTNotFoundException extends EntityNotFoundException {
    public PDTNotFoundException(String message) {
        super(message);
    }
}
