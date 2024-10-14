package be.kdg.prog6.boundedcontextLandside.domain;

import java.time.LocalDateTime;

public class EntranceRequest {
    private LicensePlate licensePlate;
    private LocalDateTime requestTime;
    private boolean isApproved;
    private Appointment approvedAppointment;


    public EntranceRequest(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
        this.requestTime = LocalDateTime.now();
        this.isApproved = false;
        this.approvedAppointment = null;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Appointment getApprovedAppointment() {
        return approvedAppointment;
    }

    public void setApprovedAppointment(Appointment approvedAppointment) {
        this.approvedAppointment = approvedAppointment;
    }
}
