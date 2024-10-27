package be.kdg.prog6.boundedcontextWaterside.port.out;

import be.kdg.prog6.boundedcontextWaterside.domain.PO;
import be.kdg.prog6.boundedcontextWaterside.domain.POId;

public interface FindPOPort {
    PO findPOById(POId poId);
}
