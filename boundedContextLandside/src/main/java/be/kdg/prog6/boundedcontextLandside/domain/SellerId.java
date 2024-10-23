package be.kdg.prog6.boundedcontextLandside.domain;

import java.util.Objects;
import java.util.UUID;

public record SellerId(UUID id) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerId sellerId = (SellerId) o;
        return Objects.equals(id, sellerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
