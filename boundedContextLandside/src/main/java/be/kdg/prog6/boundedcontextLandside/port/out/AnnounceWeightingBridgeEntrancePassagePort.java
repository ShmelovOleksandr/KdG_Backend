package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;

import java.math.BigDecimal;

public interface AnnounceWeightingBridgeEntrancePassagePort {
    void announceWeightingBridgeEntrancePassage(Warehouse warehouse, BigDecimal truckWeight);
}
