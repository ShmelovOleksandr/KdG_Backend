package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WBT;

public interface FindWBTPort {
    WBT findWBTByAppointmentId(AppointmentId appointmentId);
}
