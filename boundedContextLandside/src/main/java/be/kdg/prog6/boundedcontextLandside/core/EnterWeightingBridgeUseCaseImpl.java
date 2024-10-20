package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.in.EnterWeightingBridgeUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindAppointmentPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWBTPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterWeightingBridgeUseCaseImpl implements EnterWeightingBridgeUseCase {
    private final FindAppointmentPort findAppointmentPort;
    private final FindWarehousePort findWarehousePort;
    private final PersistWBTPort persistWBTPort;

    @Autowired
    public EnterWeightingBridgeUseCaseImpl(FindAppointmentPort findAppointmentPort, FindWarehousePort findWarehousePort, PersistWBTPort persistWBTPort) {
        this.findAppointmentPort = findAppointmentPort;
        this.findWarehousePort = findWarehousePort;
        this.persistWBTPort = persistWBTPort;
    }

    @Override
    public WeightBridgeEntranceResponse handleWeightBridgeEntranceRequest(WeightBridgePassageCommand weightBridgePassageCommand) {
        Appointment appointment = findAppointmentPort.findAppointmentById(weightBridgePassageCommand.appointmentId());

        Warehouse warehouse = findWarehousePort.findWarehouseBySellerIdAndMaterialTypeStored(appointment.getSellerId(), appointment.getMaterialType());

        WBT weighBridgeTransaction = appointment.createWeighBridgeTransaction(weightBridgePassageCommand.weight());
        persistWBTPort.save(weighBridgeTransaction);

        return new WeightBridgeEntranceResponse(warehouse.getWarehouseId());
    }
}
