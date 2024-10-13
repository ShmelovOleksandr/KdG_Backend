package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.*;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class AppointmentJpaToDomainConverter implements Converter<AppointmentJpaEntity, Appointment> {
    @Override
    public Appointment convert(MappingContext<AppointmentJpaEntity, Appointment> mappingContext) {
        AppointmentJpaEntity appointmentJpaEntity = mappingContext.getSource();

        return new Appointment(
                new AppointmentId(appointmentJpaEntity.getId()),
                new SellerId(appointmentJpaEntity.getSeller().getId()),
                new LicensePlate(appointmentJpaEntity.getTruckLicensePlate()),
                appointmentJpaEntity.getExpectedMaterialType(),
                appointmentJpaEntity.getDate(),
                new Hour(appointmentJpaEntity.getHourSlot().getHour())
        );
    }
}
