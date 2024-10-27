package be.kdg.prog6.boundedcontextWaterside.core;

import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.port.in.ShipArrivedUseCase;
import be.kdg.prog6.boundedcontextWaterside.port.out.PersistSOPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShipArrivedUseCaseImpl implements ShipArrivedUseCase {
    private final PersistSOPort persistSOPort;

    @Autowired
    public ShipArrivedUseCaseImpl(PersistSOPort persistSOPort) {
        this.persistSOPort = persistSOPort;
    }

    @Override
    @Transactional
    public SO manageShipArrival(SO so) {
        so.assignDates();
        return persistSOPort.save(so);
    }
}
