package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

public interface AnnounceConveyorPayloadDumpPort {
    void announceConveyorPayloadDump(WarehouseId destinationWarehouseId);
}
