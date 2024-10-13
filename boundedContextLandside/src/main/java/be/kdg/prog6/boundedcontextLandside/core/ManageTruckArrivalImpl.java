package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrival;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ManageTruckArrivalImpl implements ManageTruckArrival {

    @Override
    @Transactional
    public EntranceRequest manageEntranceRequest(EntranceRequest entranceRequest) {
        // find appointment

        // check time and approve or disapprove

        // set (+1 truck in the facility)
        return ;
    }
}
