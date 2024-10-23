package be.kdg.prog6.boundedcontextLandside;


import be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse.WarehouseJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse.WarehouseJpaRepository;
import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWarehousePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleAppointmentUseCaseImplIntegrationTest extends AbstractDatabaseTest {
    @Autowired
    private ScheduleAppointmentUseCase scheduleAppointmentUseCase;

    @Autowired
    private PersistWarehousePort persistWarehousePort;

    @Test
    public void scheduleAppointmentShouldCreateNewAppointmentIfThereAreNoAppointmentsForTheHourSlotAndWarehouseIsLessThan80PercentFull() {
        //Arrange
        final UUID SELLER_UUID = UUID.randomUUID();
        final SellerId ownerId = new SellerId(SELLER_UUID);

        final UUID WAREHOUSE_UUID = UUID.randomUUID();
        final MaterialType materialType = MaterialType.PETCOKE;

        final Warehouse savedWarehouse = persistWarehousePort.save(new Warehouse(
                new WarehouseId(WAREHOUSE_UUID),
                ownerId,
                new Material(materialType, new BigDecimal(0)),
                new BigDecimal(100)
        ));


        //Act
        final LicensePlate truckLicensePlate = new LicensePlate("123ABC");
        final LocalDate dateNow = LocalDate.now();
        final Hour prefferedHour = new Hour(LocalDateTime.now().getHour());
        final Appointment scheduledAppointment = scheduleAppointmentUseCase.scheduleAppointment(new ScheduleAppointmentCommand(
                ownerId,
                truckLicensePlate,
                materialType,
                dateNow,
                prefferedHour
        ));

        //Assert
        assertNotNull(savedWarehouse);
        assertNotNull(scheduledAppointment);
        assertNotNull(scheduledAppointment.getAppointmentId());
        assertNotNull(scheduledAppointment.getSellerId());
        assertNotNull(scheduledAppointment.getLicensePlate());
        assertNotNull(scheduledAppointment.getMaterialType());
        assertNotNull(scheduledAppointment.getArrivalHour());
        assertNotNull(scheduledAppointment.getDate());
        assertNull(scheduledAppointment.getEntranceTime());
        assertNull(scheduledAppointment.getDepartureTime());

        assertEquals(ownerId, scheduledAppointment.getSellerId());
        assertEquals(truckLicensePlate, scheduledAppointment.getLicensePlate());
        assertEquals(materialType, scheduledAppointment.getMaterialType());
        assertEquals(dateNow, scheduledAppointment.getDate());
        assertEquals(prefferedHour, scheduledAppointment.getArrivalHour());


    }

}
