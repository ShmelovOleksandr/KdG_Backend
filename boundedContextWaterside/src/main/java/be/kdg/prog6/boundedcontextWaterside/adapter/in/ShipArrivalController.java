package be.kdg.prog6.boundedcontextWaterside.adapter.in;

import be.kdg.prog6.boundedcontextWaterside.adapter.in.dto.SOGetDto;
import be.kdg.prog6.boundedcontextWaterside.adapter.in.dto.SOPostDto;
import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.port.in.ShipArrivedUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/SOs")
public class ShipArrivalController {
    private final ShipArrivedUseCase shipArrivedUseCase;

    @Autowired
    public ShipArrivalController(ShipArrivedUseCase shipArrivedUseCase) {
        this.shipArrivedUseCase = shipArrivedUseCase;
    }

    @PostMapping
public ResponseEntity<SOGetDto> postSO(@RequestBody SOPostDto soPostDto) {
        SO so = soPostDto.toDomain();
        SO savedSO = shipArrivedUseCase.manageShipArrival(so);
        return ResponseEntity.status(HttpStatus.CREATED).body(SOGetDto.of(savedSO));
    }
}
