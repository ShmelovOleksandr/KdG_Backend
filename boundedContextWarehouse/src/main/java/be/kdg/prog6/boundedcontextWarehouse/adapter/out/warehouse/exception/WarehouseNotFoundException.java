package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse.exception;

import jakarta.persistence.EntityNotFoundException;

public class WarehouseNotFoundException extends EntityNotFoundException {
    public WarehouseNotFoundException(String message) {
        super(message);
    }
}
