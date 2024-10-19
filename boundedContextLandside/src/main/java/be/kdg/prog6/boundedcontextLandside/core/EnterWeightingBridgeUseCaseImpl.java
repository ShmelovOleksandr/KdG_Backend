package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.in.EnterWeightingBridgeUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.FindAppointmentPort;
import be.kdg.prog6.boundedcontextLandside.port.out.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.PersistWBTPort;
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
    public WeightBridgeEntranceResponse handleWeightBridgeEntranceRequest(WeightBridgeEntranceCommand weightBridgeEntranceCommand) {
        Appointment appointment = findAppointmentPort.findAppointmentById(weightBridgeEntranceCommand.appointmentId());

        Warehouse warehouse = findWarehousePort.findWarehouseBySellerIdAndMaterialTypeStored(appointment.getSellerId(), appointment.getMaterialType());

        WBT weighBridgeTransaction = appointment.createWeighBridgeTransaction(weightBridgeEntranceCommand.weight());
        persistWBTPort.save(weighBridgeTransaction);

        return new WeightBridgeEntranceResponse(warehouse.getWarehouseId());
    }
}
