package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.exception.WarehouseCapacityLimitException;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.AppointmentPersistencePort;
import be.kdg.prog6.boundedcontextLandside.port.out.FindAppointmentManagerPort;
import be.kdg.prog6.boundedcontextLandside.port.out.FindWarehousePort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ScheduleAppointmentUseCaseImpl implements ScheduleAppointmentUseCase {
    private final AppointmentPersistencePort appointmentPersistencePort;
    private final FindAppointmentManagerPort findAppointmentManagerPort;
    private final FindWarehousePort findWarehousePort;

    public ScheduleAppointmentUseCaseImpl(AppointmentPersistencePort appointmentPersistencePort, FindAppointmentManagerPort findAppointmentManagerPort, FindWarehousePort findWarehousePort) {
        this.appointmentPersistencePort = appointmentPersistencePort;
        this.findAppointmentManagerPort = findAppointmentManagerPort;
        this.findWarehousePort = findWarehousePort;
    }

    @Override
    @Transactional
    public Appointment scheduleAppointment(ScheduleAppointmentCommand scheduleAppointmentCommand) {
        //check warehouse capacity
        Warehouse warehouse = findWarehousePort.findWarehouseBySellerIdAndMaterialTypeStored(scheduleAppointmentCommand.sellerId(), scheduleAppointmentCommand.materialType());
        if (!warehouse.materialCanBeStored())
            throw new WarehouseCapacityLimitException("Warehouse [%s] has reached its maximal capacity.".formatted(warehouse.getWarehouseId().id()));

        //check available slot for the HourSlot
        AppointmentManager currentAppointmentManager = findAppointmentManagerPort.findAppointmentManagerForDate(scheduleAppointmentCommand.date());

        Appointment savedAppointment = currentAppointmentManager.tryScheduleAppointment(
                scheduleAppointmentCommand.sellerId(),
                scheduleAppointmentCommand.truckLicensePlate(),
                scheduleAppointmentCommand.materialType(),
                scheduleAppointmentCommand.date(),
                scheduleAppointmentCommand.prefferedHour()
        );

        appointmentPersistencePort.saveAppointment(savedAppointment);

        return savedAppointment;
    }
}
