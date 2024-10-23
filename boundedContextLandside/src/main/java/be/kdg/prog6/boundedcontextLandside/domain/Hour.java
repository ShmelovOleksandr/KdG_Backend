package be.kdg.prog6.boundedcontextLandside.domain;

import java.util.Objects;

public record Hour(int hourNumber) {
    public Hour {
        // TODO Add custom exception
        if (hourNumber < 0 || hourNumber > 23) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hour hour = (Hour) o;
        return hourNumber == hour.hourNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hourNumber);
    }
}
