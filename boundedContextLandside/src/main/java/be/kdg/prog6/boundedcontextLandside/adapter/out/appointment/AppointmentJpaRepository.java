package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentJpaEntity, UUID> {

//    List<AppointmentJpaEntity> findAppointmentsWithArrivalDateNotNullAndDepartureDateNull();
    List<AppointmentJpaEntity> findAllByEntranceTimeIsNotNullAndDepartureTimeIsNull();
}
