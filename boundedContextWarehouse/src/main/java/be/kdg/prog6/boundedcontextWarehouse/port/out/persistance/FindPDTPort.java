package be.kdg.prog6.boundedcontextWarehouse.port.out.persistance;

import be.kdg.prog6.boundedcontextWarehouse.domain.AppointmentId;
import be.kdg.prog6.boundedcontextWarehouse.domain.PDT;

public interface FindPDTPort {
    PDT findPDTByAppointmentId(AppointmentId appointmentId);
}
