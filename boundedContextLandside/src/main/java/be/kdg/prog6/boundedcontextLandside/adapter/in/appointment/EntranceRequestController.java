package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment;

import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.EntranceRequestGetDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.EntranceRequestPostDto;
import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrivalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entrance_requests")
public class EntranceRequestController {
    private final ManageTruckArrivalUseCase manageTruckArrivalUseCase;

    @Autowired
    public EntranceRequestController(ManageTruckArrivalUseCase manageTruckArrivalUseCase) {
        this.manageTruckArrivalUseCase = manageTruckArrivalUseCase;
    }

    @PostMapping
    public ResponseEntity<EntranceRequestGetDto> handleEntranceRequest(@RequestBody EntranceRequestPostDto entranceRequestPostDto) {
        EntranceRequest entranceRequest = entranceRequestPostDto.toDomain();
        EntranceRequest handledEntranceRequest = manageTruckArrivalUseCase.manageEntranceRequest(entranceRequest);
        return ResponseEntity.accepted().body(EntranceRequestGetDto.of(handledEntranceRequest));
    }
}
