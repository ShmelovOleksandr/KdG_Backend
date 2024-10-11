package be.kdg.prog6.boundedcontextLandside.domain;

public record Hour(int hourNumber) {
    public Hour {
        // TODO Add custom exception
        if (hourNumber < 0 || hourNumber > 23) throw new IndexOutOfBoundsException();
    }
}
