package be.kdg.prog6.boundedcontextLandside.adapter.in.requests;

import be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto.DepartureRequestPostDto;
import be.kdg.prog6.boundedcontextLandside.port.in.DepartureCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckDepartureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/requests/departures")
public class DepartureRequestController {
    private final ManageTruckDepartureUseCase manageTruckDepartureUseCase;

    @Autowired
    public DepartureRequestController(ManageTruckDepartureUseCase manageTruckDepartureUseCase) {
        this.manageTruckDepartureUseCase = manageTruckDepartureUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> handleEntranceRequest(@RequestBody DepartureRequestPostDto departureRequestPostDto) {
        DepartureCommand departureCommand = departureRequestPostDto.toDepartureCommand();
        manageTruckDepartureUseCase.manageDepartureRequest(departureCommand);
        return ResponseEntity.accepted().build();
    }
}
