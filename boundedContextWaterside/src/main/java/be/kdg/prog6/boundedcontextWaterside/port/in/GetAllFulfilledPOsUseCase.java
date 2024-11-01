package be.kdg.prog6.boundedcontextWaterside.port.in;

import be.kdg.prog6.boundedcontextWaterside.domain.PO;

import java.util.List;

public interface GetAllFulfilledPOsUseCase {
    List<PO> getAllFulfilledPOs();
}
