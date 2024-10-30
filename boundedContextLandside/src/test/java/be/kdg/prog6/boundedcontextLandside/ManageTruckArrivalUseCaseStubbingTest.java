package be.kdg.prog6.boundedcontextLandside;

import be.kdg.prog6.boundedcontextLandside.core.ManageTruckArrivalUseCaseImpl;
import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrivalUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindHourSlotPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistAppointmentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManageTruckArrivalUseCaseStubbingTest {
    private ManageTruckArrivalUseCase manageTruckArrivalUseCase;

    @BeforeEach
    void setUp() {
        FindHourSlotPort findHourSlotPort = new FindHourSlotPortStub();
        PersistAppointmentPort persistAppointmentPort = new PersistAppointmentPortStub();

        manageTruckArrivalUseCase = new ManageTruckArrivalUseCaseImpl(findHourSlotPort, persistAppointmentPort);
    }

    @Test
    void shouldAllowEntranceForTheTruckWithValidLicensePlateAndAtTheScheduledTime() {
        //Act
        EntranceRequest entranceRequest = manageTruckArrivalUseCase.manageEntranceRequest(new EntranceRequest(
                FindHourSlotPortStub.LICENSE_PLATE,
                FindHourSlotPortStub.MATERIAL_TYPE
        ));

        //Assert

        assertNotNull(entranceRequest);
        assertTrue(entranceRequest.isApproved());
        assertEquals(FindHourSlotPortStub.LICENSE_PLATE, entranceRequest.getLicensePlate());
        assertEquals(FindHourSlotPortStub.MATERIAL_TYPE, entranceRequest.getMaterialType());
        assertEquals(FindHourSlotPortStub.APPOINTMENT_ID, entranceRequest.getApprovedAppointment().getAppointmentId());
        assertEquals(FindHourSlotPortStub.APPOINTMENT_DATE, entranceRequest.getApprovedAppointment().getDate());
        assertEquals(FindHourSlotPortStub.SELLER_ID, entranceRequest.getApprovedAppointment().getSellerId());
        assertEquals(FindHourSlotPortStub.LICENSE_PLATE, entranceRequest.getApprovedAppointment().getLicensePlate());
    }
}
