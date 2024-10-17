package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceCommand;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceResponse;

public interface EnterWeightingBridgeUseCase {
    WeightBridgeEntranceResponse handleWeightBridgeEntranceRequest(WeightBridgeEntranceCommand weightBridgeEntranceCommand);
}
