package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentManagerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.HourSlotJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.*;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.List;

public class AppointmentManagerJpaToDomainConverter implements Converter<AppointmentManagerJpaEntity, AppointmentManager> {

    @Override
    public AppointmentManager convert(MappingContext<AppointmentManagerJpaEntity, AppointmentManager> mappingContext) {
        AppointmentManagerJpaEntity appointmentManagerJpaEntity = mappingContext.getSource();

        return new AppointmentManager(
                appointmentManagerJpaEntity.getManagedDate(),
                new ArrayList<>(appointmentManagerJpaEntity.getHourSlots().stream().map(
                        hourSlotJpaEntity -> new HourSlot(
                                hourSlotJpaEntity.getHour(),
                                new ArrayList<>(hourSlotJpaEntity.getAppointments().stream().map(
                                        appointmentJpaEntity -> new Appointment(
                                                new AppointmentId(appointmentJpaEntity.getId()),
                                                new SellerId(appointmentJpaEntity.getSeller().getId()),
                                                new LicensePlate(appointmentJpaEntity.getTruckLicensePlate()),
                                                appointmentJpaEntity.getExpectedMaterialType(),
                                                new Hour(appointmentJpaEntity.getHourSlot().getHour())
                                        )
                                ).toList())
                        )
                ).toList())
        );
    }
}
