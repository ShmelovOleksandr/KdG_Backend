package be.kdg.prog6.boundedcontextLandside.adapter.in.facility;

import be.kdg.prog6.boundedcontextLandside.adapter.in.facility.dto.FacilityDetailGetDto;
import be.kdg.prog6.boundedcontextLandside.dom.FacilityDetail;
import be.kdg.prog6.boundedcontextLandside.port.in.GetCurrentTruckNumberUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/facilities")
public class FacilityRestController {
    private final GetCurrentTruckNumberUseCase getCurrentTruckNumberUseCase;

    public FacilityRestController(GetCurrentTruckNumberUseCase getCurrentTruckNumberUseCase) {
        this.getCurrentTruckNumberUseCase = getCurrentTruckNumberUseCase;
    }

    @GetMapping("{id}")
    public ResponseEntity<FacilityDetailGetDto> getFacilityDetails(@PathVariable int id) {
        // {id} is not used, since for now we only have one facility
        FacilityDetail facilityDetail = getCurrentTruckNumberUseCase.findCurrentTruckNumberInTheFacility();
        return ResponseEntity.ok(FacilityDetailGetDto.of(facilityDetail));
    }
}
