package be.kdg.prog6.boundedcontextLandside.adapter.in.requests;

import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.WeightBridgeEntranceRequestDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.WeightBridgeEntranceResponseDto;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceCommand;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceResponse;
import be.kdg.prog6.boundedcontextLandside.port.in.EnterWeightingBridgeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weightingbridge_passage_requests")
public class WeightingBridgePassageRestController {
    private final EnterWeightingBridgeUseCase enterWeightingBridgeUseCase;

    @Autowired
    public WeightingBridgePassageRestController(EnterWeightingBridgeUseCase enterWeightingBridgeUseCase) {
        this.enterWeightingBridgeUseCase = enterWeightingBridgeUseCase;
    }

    @PostMapping("/entrances")
    public ResponseEntity<WeightBridgeEntranceResponseDto> handleWeightingBridgeEntranceRequest(@RequestBody WeightBridgeEntranceRequestDto weightBridgeEntranceRequestDto) {
        WeightBridgeEntranceCommand weightBridgeEntranceCommand = weightBridgeEntranceRequestDto.toCommand();
        WeightBridgeEntranceResponse weightBridgeEntranceResponse = enterWeightingBridgeUseCase.handleWeightBridgeEntranceRequest(weightBridgeEntranceCommand);
        return ResponseEntity.accepted().body(WeightBridgeEntranceResponseDto.of(weightBridgeEntranceResponse));
    }
}
