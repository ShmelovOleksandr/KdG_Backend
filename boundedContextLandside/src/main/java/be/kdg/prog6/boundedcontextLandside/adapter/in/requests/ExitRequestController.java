package be.kdg.prog6.boundedcontextLandside.adapter.in.requests;

import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.EntranceRequestGetDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.EntranceRequestPostDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.ExitRequestPostDto;
import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.port.in.DepartureCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrivalUseCase;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckDepartureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/requests/departures")
public class ExitRequestController {
    private final ManageTruckDepartureUseCase manageTruckDepartureUseCase;

    @Autowired
    public ExitRequestController(ManageTruckDepartureUseCase manageTruckDepartureUseCase) {
        this.manageTruckDepartureUseCase = manageTruckDepartureUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> handleEntranceRequest(@RequestBody ExitRequestPostDto exitRequestPostDto) {
        DepartureCommand departureCommand = exitRequestPostDto.toDepartureCommand();
        manageTruckDepartureUseCase.manageDepartureRequest(departureCommand);
        return ResponseEntity.accepted().build();
    }
}
