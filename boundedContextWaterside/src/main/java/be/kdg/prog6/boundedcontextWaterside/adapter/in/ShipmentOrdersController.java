package be.kdg.prog6.boundedcontextWaterside.adapter.in;

import be.kdg.prog6.boundedcontextWaterside.adapter.in.dto.SOGetDto;
import be.kdg.prog6.boundedcontextWaterside.adapter.in.dto.SOPostDto;
import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.domain.SOId;
import be.kdg.prog6.boundedcontextWaterside.port.in.ShipArrivedUseCase;
import be.kdg.prog6.boundedcontextWaterside.port.in.ShipDepartureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/SOs")
public class ShipmentOrdersController {
    private final ShipArrivedUseCase shipArrivedUseCase;
    private final ShipDepartureUseCase shipDepartureUseCase;

    @Autowired
    public ShipmentOrdersController(ShipArrivedUseCase shipArrivedUseCase, ShipDepartureUseCase shipDepartureUseCase) {
        this.shipArrivedUseCase = shipArrivedUseCase;
        this.shipDepartureUseCase = shipDepartureUseCase;
    }

    @PostMapping
    public ResponseEntity<SOGetDto> postSO(@RequestBody SOPostDto soPostDto) {
        SO so = soPostDto.toDomain();
        SO savedSO = shipArrivedUseCase.manageShipArrival(so);
        return ResponseEntity.status(HttpStatus.CREATED).body(SOGetDto.of(savedSO));
    }

    @PostMapping("/{soUUID}/departure")
    public ResponseEntity<Void> departureSO(@PathVariable UUID soUUID) {
        shipDepartureUseCase.manageShipDeparture(new SOId(soUUID));
        return ResponseEntity.accepted().build();
    }
}
