package be.kdg.prog6.boundedcontextLandside.domain.exception;

public class WarehouseCapacityLimitException extends RuntimeException {
    public WarehouseCapacityLimitException(String message) {
        super(message);
    }
}
