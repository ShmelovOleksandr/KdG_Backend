package be.kdg.prog6.boundedcontextLandside.domain;

import java.math.BigDecimal;

public class WBT {
    private WBTId wbtId;
    private AppointmentId appointmentId;
    private BigDecimal entranceWeight;
    private BigDecimal exitWeight;

    public WBT(WBTId wbtId, AppointmentId appointmentId, BigDecimal entranceWeight) {
        this.wbtId = wbtId;
        this.appointmentId = appointmentId;
        this.entranceWeight = entranceWeight;
    }

    public WBT(WBTId wbtId, AppointmentId appointmentId, BigDecimal entranceWeight, BigDecimal exitWeight) {
        this.wbtId = wbtId;
        this.appointmentId = appointmentId;
        this.entranceWeight = entranceWeight;
        this.exitWeight = exitWeight;
    }

    public BigDecimal getWeightDifferance() {
        return entranceWeight.subtract(exitWeight);
    }

    public WBTId getWbtId() {
        return wbtId;
    }

    public void setWbtId(WBTId wbtId) {
        this.wbtId = wbtId;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(AppointmentId appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getEntranceWeight() {
        return entranceWeight;
    }

    public void setEntranceWeight(BigDecimal entranceWeight) {
        this.entranceWeight = entranceWeight;
    }

    public BigDecimal getExitWeight() {
        return exitWeight;
    }

    public void setExitWeight(BigDecimal exitWeight) {
        this.exitWeight = exitWeight;
    }
}
