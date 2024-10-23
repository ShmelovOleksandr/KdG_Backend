package be.kdg.prog6.boundedcontextLandside;

import be.kdg.prog6.boundedcontextLandside.core.ManageTruckArrivalUseCaseImpl;
import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrivalUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindCurrentHourSlotPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistAppointmentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManageTruckArrivalUseCaseStubbingTest {
    private ManageTruckArrivalUseCase manageTruckArrivalUseCase;

    @BeforeEach
    void setUp() {
        FindCurrentHourSlotPort findCurrentHourSlotPort = new FindCurrentHourSlotPortStub();
        PersistAppointmentPort persistAppointmentPort = new PersistAppointmentPortStub();

        manageTruckArrivalUseCase = new ManageTruckArrivalUseCaseImpl(findCurrentHourSlotPort, persistAppointmentPort);
    }

    @Test
    void shouldAllowEntranceForTheTruckWithValidLicensePlateAndAtTheScheduledTime() {
        //Act
        EntranceRequest entranceRequest = manageTruckArrivalUseCase.manageEntranceRequest(new EntranceRequest(
                FindCurrentHourSlotPortStub.LICENSE_PLATE,
                FindCurrentHourSlotPortStub.MATERIAL_TYPE
        ));

        //Assert

        assertNotNull(entranceRequest);
        assertTrue(entranceRequest.isApproved());
        assertEquals(FindCurrentHourSlotPortStub.LICENSE_PLATE, entranceRequest.getLicensePlate());
        assertEquals(FindCurrentHourSlotPortStub.MATERIAL_TYPE, entranceRequest.getMaterialType());
        assertEquals(FindCurrentHourSlotPortStub.APPOINTMENT_ID, entranceRequest.getApprovedAppointment().getAppointmentId());
        assertEquals(FindCurrentHourSlotPortStub.APPOINTMENT_DATE, entranceRequest.getApprovedAppointment().getDate());
        assertEquals(FindCurrentHourSlotPortStub.SELLER_ID, entranceRequest.getApprovedAppointment().getSellerId());
        assertEquals(FindCurrentHourSlotPortStub.LICENSE_PLATE, entranceRequest.getApprovedAppointment().getLicensePlate());
    }
}
