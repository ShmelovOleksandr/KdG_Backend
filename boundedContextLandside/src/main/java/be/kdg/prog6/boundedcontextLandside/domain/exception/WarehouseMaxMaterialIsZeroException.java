package be.kdg.prog6.boundedcontextLandside.domain.exception;

public class WarehouseMaxMaterialIsZeroException extends RuntimeException {
    public WarehouseMaxMaterialIsZeroException(String message) {
        super(message);
    }
}
