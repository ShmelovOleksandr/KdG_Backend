package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class AppointmentDomainToJpaConverter implements Converter<Appointment, AppointmentJpaEntity> {
    @Override
    public AppointmentJpaEntity convert(MappingContext<Appointment, AppointmentJpaEntity> mappingContext) {
        Appointment appointment = mappingContext.getSource();

        return new AppointmentJpaEntity(
                appointment.appointmentId().id(),
                appointment.licensePlate().licensePlateString(),
                appointment.materialType(),
                appointment.scheduleTime().preferredTime(),
                new SellerJpaEntity(appointment.sellerId().id())
        );
    }
}
