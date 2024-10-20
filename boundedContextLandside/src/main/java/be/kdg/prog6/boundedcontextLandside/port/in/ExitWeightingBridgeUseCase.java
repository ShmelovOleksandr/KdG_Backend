package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgePassageCommand;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceResponse;

public interface ExitWeightingBridgeUseCase {
    WBT handleWeightBridgeExitRequest(WeightBridgePassageCommand weightBridgePassageCommand);
}
