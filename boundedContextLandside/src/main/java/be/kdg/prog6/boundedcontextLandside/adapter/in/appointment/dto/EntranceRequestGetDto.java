package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;

import java.time.LocalDateTime;

public record EntranceRequestGetDto(String licensePlate, LocalDateTime requestTime, Boolean isApproved, AppointmentGetDto approvedAppointment) {
    public static EntranceRequestGetDto of(EntranceRequest entranceRequest) {
        return new EntranceRequestGetDto(
                entranceRequest.getLicensePlate().licensePlateString(),
                entranceRequest.getRequestTime(),
                entranceRequest.isApproved(),
                AppointmentGetDto.of(entranceRequest.getApprovedAppointment())
        );
    }
}
