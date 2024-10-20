package be.kdg.prog6.boundedcontextLandside.adapter.in.requests;

import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.WBTDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.WeightBridgePassageRequestDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.WeightBridgeEntranceResponseDto;
import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgePassageCommand;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceResponse;
import be.kdg.prog6.boundedcontextLandside.port.in.EnterWeightingBridgeUseCase;
import be.kdg.prog6.boundedcontextLandside.port.in.ExitWeightingBridgeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/requests/weightingbridge_passage")
public class WeightingBridgePassageRestController {
    private final EnterWeightingBridgeUseCase enterWeightingBridgeUseCase;
    private final ExitWeightingBridgeUseCase exitWeightingBridgeUseCase;

    @Autowired
    public WeightingBridgePassageRestController(EnterWeightingBridgeUseCase enterWeightingBridgeUseCase, ExitWeightingBridgeUseCase exitWeightingBridgeUseCase) {
        this.enterWeightingBridgeUseCase = enterWeightingBridgeUseCase;
        this.exitWeightingBridgeUseCase = exitWeightingBridgeUseCase;
    }

    @PostMapping("/entrances")
    public ResponseEntity<WeightBridgeEntranceResponseDto> handleWeightingBridgeEntranceRequest(@RequestBody WeightBridgePassageRequestDto weightBridgePassageRequestDto) {
        WeightBridgePassageCommand weightBridgePassageCommand = weightBridgePassageRequestDto.toCommand();
        WeightBridgeEntranceResponse weightBridgeEntranceResponse = enterWeightingBridgeUseCase.handleWeightBridgeEntranceRequest(weightBridgePassageCommand);
        return ResponseEntity.accepted().body(WeightBridgeEntranceResponseDto.of(weightBridgeEntranceResponse));
    }

    @PostMapping("/exits")
    public ResponseEntity<WBTDto> handleWeightingBridgeExitRequest(@RequestBody WeightBridgePassageRequestDto weightBridgePassageRequestDto) {
        WeightBridgePassageCommand weightBridgePassageCommand = weightBridgePassageRequestDto.toCommand();
        WBT wbt = exitWeightingBridgeUseCase.handleWeightBridgeExitRequest(weightBridgePassageCommand);
        return ResponseEntity.accepted().body(WBTDto.of(wbt));
    }
}
