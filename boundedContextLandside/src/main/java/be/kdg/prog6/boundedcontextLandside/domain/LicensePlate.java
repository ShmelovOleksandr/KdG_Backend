package be.kdg.prog6.boundedcontextLandside.domain;

import java.util.Objects;

public record LicensePlate(String licensePlateString) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicensePlate that = (LicensePlate) o;
        return Objects.equals(licensePlateString, that.licensePlateString);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(licensePlateString);
    }
}
