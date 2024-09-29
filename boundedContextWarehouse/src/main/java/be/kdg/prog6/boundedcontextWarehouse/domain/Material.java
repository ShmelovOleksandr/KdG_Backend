package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;

public record Material(MaterialType materialType, BigDecimal tons) {
}
