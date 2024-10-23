package be.kdg.prog6.boundedcontextLandside;

import be.kdg.prog6.boundedcontextLandside.core.ExitWeightingBridgeUseCaseImpl;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.domain.WBTId;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgePassageCommand;
import be.kdg.prog6.boundedcontextLandside.port.out.messaging.TransferDeliveredWeightPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindWBTPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWBTPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExitWeightingBridgeUseCaseImplMockingTest {
    private final static WBTId WBT_ID = new WBTId(UUID.randomUUID());
    private final static AppointmentId APPOINTMENT_ID = new AppointmentId(UUID.randomUUID());
    private final static BigDecimal ENTRANCE_WEIGHT = new BigDecimal(25);
    private final static BigDecimal EXIT_WEIGHT = new BigDecimal(0);

    private ExitWeightingBridgeUseCaseImpl exitWeightingBridgeUseCaseImpl;
    private PersistWBTPort persistWBTPort;

    @BeforeEach
    void setUp() {
        final WBT wbt = new WBT(
                WBT_ID,
                APPOINTMENT_ID,
                ENTRANCE_WEIGHT
        );

        FindWBTPort findWBTPort = mock(FindWBTPort.class);
        when(findWBTPort.findWBTByAppointmentId(APPOINTMENT_ID)).thenReturn(wbt);

        persistWBTPort = mock(PersistWBTPort.class);
        when(persistWBTPort.save(wbt)).thenReturn(wbt);

        TransferDeliveredWeightPort transferDeliveredWeightPort = mock(TransferDeliveredWeightPort.class);

        exitWeightingBridgeUseCaseImpl = new ExitWeightingBridgeUseCaseImpl(findWBTPort, persistWBTPort, transferDeliveredWeightPort);
    }

    @Test
    void shouldReturnWbt() {
        //Act
        WBT wbt = exitWeightingBridgeUseCaseImpl.handleWeightBridgeExitRequest(new WeightBridgePassageCommand(
                APPOINTMENT_ID,
                EXIT_WEIGHT
        ));

        //
        assertNotNull(wbt);
        assertEquals(WBT_ID, wbt.getWbtId());
        assertEquals(APPOINTMENT_ID, wbt.getAppointmentId());
        assertEquals(ENTRANCE_WEIGHT, wbt.getEntranceWeight());
        assertEquals(EXIT_WEIGHT, wbt.getExitWeight());

    }
}
