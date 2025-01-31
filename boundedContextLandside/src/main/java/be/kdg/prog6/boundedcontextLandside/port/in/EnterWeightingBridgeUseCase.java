package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgePassageCommand;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceResponse;

public interface EnterWeightingBridgeUseCase {
    WeightBridgeEntranceResponse handleWeightBridgeEntranceRequest(WeightBridgePassageCommand weightBridgePassageCommand);
}
