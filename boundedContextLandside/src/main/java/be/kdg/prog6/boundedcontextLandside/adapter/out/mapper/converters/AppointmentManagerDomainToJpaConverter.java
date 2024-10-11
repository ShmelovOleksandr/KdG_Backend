package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentManagerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.HourSlotJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.List;
import java.util.stream.Stream;

public class AppointmentManagerDomainToJpaConverter implements Converter<AppointmentManager, AppointmentManagerJpaEntity> {
    @Override
    public AppointmentManagerJpaEntity convert(MappingContext<AppointmentManager, AppointmentManagerJpaEntity> mappingContext) {
        AppointmentManager appointmentManager = mappingContext.getSource();

        AppointmentManagerJpaEntity appointmentManagerJpaEntity = new AppointmentManagerJpaEntity(
                appointmentManager.getManagedDate()
        );

        List<HourSlot> hourSlots = appointmentManager.getHourSlots();
        List<HourSlotJpaEntity> hourSlotsJpaEntities = hourSlots.stream().map(hourSlot -> {
            HourSlotJpaEntity hourSlotJpaEntity = new HourSlotJpaEntity(hourSlot.getHour(), appointmentManagerJpaEntity);
            List<AppointmentJpaEntity> appointmentJpaEntities = hourSlot.getAppointments().stream().map(appointment -> new AppointmentJpaEntity(
                    appointment.appointmentId().id(),
                    appointment.licensePlate().licensePlateString(),
                    appointment.materialType(),
                    hourSlotJpaEntity,
                    new SellerJpaEntity(appointment.sellerId().id())
            )).toList();
            hourSlotJpaEntity.setAppointments(appointmentJpaEntities);
            return hourSlotJpaEntity;
        }).toList();
        appointmentManagerJpaEntity.setHourSlots(hourSlotsJpaEntities);


        return appointmentManagerJpaEntity;
    }
}
