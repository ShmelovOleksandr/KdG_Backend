package be.kdg.prog6.boundedcontextLandside.domain;

import java.time.LocalDateTime;

public class EntranceRequest {
    private EntranceRequestId entranceRequestId;
    private LicensePlate licensePlate;
    private LocalDateTime requestTime;
    private boolean isApproved;



    public EntranceRequest(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public EntranceRequestId getEntranceRequestId() {
        return entranceRequestId;
    }

    public void setEntranceRequestId(EntranceRequestId entranceRequestId) {
        this.entranceRequestId = entranceRequestId;
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
}
