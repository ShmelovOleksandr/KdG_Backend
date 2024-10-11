package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentManagerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.HourSlotJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;

public class AppointmentDomainToJpaConverter implements Converter<Appointment, AppointmentJpaEntity> {
    @Override
    public AppointmentJpaEntity convert(MappingContext<Appointment, AppointmentJpaEntity> mappingContext) {
        Appointment appointment = mappingContext.getSource();

        AppointmentManagerJpaEntity appointmentManagerJpa = new AppointmentManagerJpaEntity(LocalDate.now());
        HourSlotJpaEntity hourSlot = new HourSlotJpaEntity(appointment.preferredHour().hourNumber(), appointmentManagerJpa);
        SellerJpaEntity seller = new SellerJpaEntity(appointment.sellerId().id());

        return new AppointmentJpaEntity(
                appointment.appointmentId().id(),
                appointment.licensePlate().licensePlateString(),
                appointment.materialType(),
                hourSlot,
                seller
        );
    }
}
