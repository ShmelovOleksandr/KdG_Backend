package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment;

import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.AppointmentGetDto;
import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.AppointmentPostDto;
import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentRestController {
    private final ScheduleAppointmentUseCase scheduleAppointmentUseCase;

    public AppointmentRestController(ScheduleAppointmentUseCase scheduleAppointmentUseCase) {
        this.scheduleAppointmentUseCase = scheduleAppointmentUseCase;
    }


    @PostMapping
    public ResponseEntity<AppointmentGetDto> postAppointment(@RequestBody AppointmentPostDto appointmentPostDto) {
        Appointment appointment = appointmentPostDto.toAppointment();
        Appointment savedAppointment = scheduleAppointmentUseCase.scheduleAppointment(new ScheduleAppointmentCommand(
                appointment.getSellerId(),
                appointment.getLicensePlate(),
                appointment.getMaterialType(),
                appointment.getDate(),
                appointment.getArivalHour()
        ));
        AppointmentGetDto appointmentGetDto = AppointmentGetDto.of(savedAppointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentGetDto);
    }

}
