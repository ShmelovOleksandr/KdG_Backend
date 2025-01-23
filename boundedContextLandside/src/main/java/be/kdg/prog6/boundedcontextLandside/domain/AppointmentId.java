package be.kdg.prog6.boundedcontextLandside.domain;

import java.util.Objects;
import java.util.UUID;

public record AppointmentId(UUID id) {

    public AppointmentId {
        Objects.requireNonNull(id);
    }
}
