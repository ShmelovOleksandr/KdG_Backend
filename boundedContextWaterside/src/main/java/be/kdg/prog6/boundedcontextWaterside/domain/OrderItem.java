package be.kdg.prog6.boundedcontextWaterside.domain;

public record OrderItem(int lineNumber, MaterialType materialType, String description, int quantity, UOM uom) {
}
