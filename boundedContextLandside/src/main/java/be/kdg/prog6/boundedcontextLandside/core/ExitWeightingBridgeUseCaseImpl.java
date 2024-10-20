package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgePassageCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ExitWeightingBridgeUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.messaging.TransferDeliveredWeightPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindWBTPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWBTPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ExitWeightingBridgeUseCaseImpl implements ExitWeightingBridgeUseCase {
    private final FindWBTPort findWBTPort;
    private final PersistWBTPort persistWBTPort;
    private final TransferDeliveredWeightPort transferDeliveredWeightPort;

    @Autowired
    public ExitWeightingBridgeUseCaseImpl(FindWBTPort findWBTPort, PersistWBTPort persistWBTPort, TransferDeliveredWeightPort transferDeliveredWeightPort) {
        this.findWBTPort = findWBTPort;
        this.persistWBTPort = persistWBTPort;
        this.transferDeliveredWeightPort = transferDeliveredWeightPort;
    }

    @Override
    @Transactional
    public WBT handleWeightBridgeExitRequest(WeightBridgePassageCommand weightBridgePassageCommand) {
        WBT wbt = findWBTPort.findWBTByAppointmentId(weightBridgePassageCommand.appointmentId());
        wbt.setExitWeight(weightBridgePassageCommand.weight());
        WBT savedWbt = persistWBTPort.save(wbt);

        AppointmentId appointmentId = savedWbt.getAppointmentId();
        BigDecimal weightChange = wbt.getWeightDifferance();
        transferDeliveredWeightPort.publishDeliveredWeight(appointmentId, weightChange);

        return savedWbt;
    }
}
