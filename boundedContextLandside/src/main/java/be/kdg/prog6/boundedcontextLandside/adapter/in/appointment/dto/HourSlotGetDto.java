package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;

import java.time.LocalDate;
import java.util.List;

public record HourSlotGetDto(LocalDate date, Integer hour, List<AppointmentGetDto> appointments) {
    public static HourSlotGetDto of(HourSlot hourSlot) {
        return new HourSlotGetDto(
                hourSlot.getAppointments().stream().findAny().get().getDate(),
                hourSlot.getHour(),
                hourSlot.getAppointments().stream().map(AppointmentGetDto::of).toList()
        );
    }
}
