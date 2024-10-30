package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment;

import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.HourSlotGetDto;
import be.kdg.prog6.boundedcontextLandside.domain.Hour;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.in.GetHourSlotDetailsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointmentManagers")
public class AppointmentManagerRestController {
    private final GetHourSlotDetailsUseCase getHourSlotDetailsUseCase;

    @Autowired
    public AppointmentManagerRestController(GetHourSlotDetailsUseCase getHourSlotDetailsUseCase) {
        this.getHourSlotDetailsUseCase = getHourSlotDetailsUseCase;
    }

    @GetMapping("/{date}/hourSlots/{hour}")
    public ResponseEntity<HourSlotGetDto> getHourSlotByDateAndHour(@PathVariable LocalDate date, @PathVariable int hour) {
        HourSlot hourSlot = getHourSlotDetailsUseCase.getHourSlotDetailsForDateAndHour(date, new Hour(hour));
        return ResponseEntity.ok(HourSlotGetDto.of(hourSlot));
    }
}
