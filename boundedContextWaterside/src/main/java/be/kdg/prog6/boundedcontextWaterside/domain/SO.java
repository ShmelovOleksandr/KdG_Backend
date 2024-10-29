package be.kdg.prog6.boundedcontextWaterside.domain;

import be.kdg.prog6.boundedcontextWaterside.domain.exception.SONotInspectedException;

import java.time.LocalDate;

public class SO {
    private SOId id;
    private POId purchaseOrderId;
    private String vesselNumber;
    private LocalDate estimatedArrivalDate;
    private LocalDate estimatedDepartureDate;
    private LocalDate actualArrivalDate;
    private LocalDate actualDepartureDate;

    private LocalDate dateOfInspectionOperationSignature;
    private LocalDate dateOfBunkeringOperationSignature;

    public SO() {
    }

    public SO(SOId id, POId purchaseOrderId, String vesselNumber, LocalDate estimatedArrivalDate, LocalDate estimatedDepartureDate) {
        this.id = id;
        this.purchaseOrderId = purchaseOrderId;
        this.vesselNumber = vesselNumber;
        this.estimatedArrivalDate = estimatedArrivalDate;
        this.estimatedDepartureDate = estimatedDepartureDate;
    }

    public SO(SOId id, POId purchaseOrderId, String vesselNumber, LocalDate estimatedArrivalDate, LocalDate estimatedDepartureDate, LocalDate actualArrivalDate, LocalDate actualDepartureDate, LocalDate dateOfInspectionOperationSignature, LocalDate dateOfBunkeringOperationSignature) {
        this.id = id;
        this.purchaseOrderId = purchaseOrderId;
        this.vesselNumber = vesselNumber;
        this.estimatedArrivalDate = estimatedArrivalDate;
        this.estimatedDepartureDate = estimatedDepartureDate;
        this.actualArrivalDate = actualArrivalDate;
        this.actualDepartureDate = actualDepartureDate;
        this.dateOfInspectionOperationSignature = dateOfInspectionOperationSignature;
        this.dateOfBunkeringOperationSignature = dateOfBunkeringOperationSignature;
    }

    public void assignDates() {
        LocalDate now = LocalDate.now();
        setActualArrivalDate(now);
        setDateOfInspectionOperationSignature(now.plusDays(1));
        setDateOfBunkeringOperationSignature(now.plusDays(1));
    }

    public void validateAllInspections() {
        if (this.dateOfInspectionOperationSignature == null || this.dateOfBunkeringOperationSignature == null)
            throw new SONotInspectedException("SO [%s] is not completely inspected yet.".formatted(this.id.id()));
    }

    public SOId getId() {
        return id;
    }

    public void setId(SOId id) {
        this.id = id;
    }

    public POId getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(POId purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public LocalDate getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(LocalDate estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public LocalDate getEstimatedDepartureDate() {
        return estimatedDepartureDate;
    }

    public void setEstimatedDepartureDate(LocalDate estimatedDepartureDate) {
        this.estimatedDepartureDate = estimatedDepartureDate;
    }

    public LocalDate getActualArrivalDate() {
        return actualArrivalDate;
    }

    public void setActualArrivalDate(LocalDate actualArrivalDate) {
        this.actualArrivalDate = actualArrivalDate;
    }

    public LocalDate getActualDepartureDate() {
        return actualDepartureDate;
    }

    public void setActualDepartureDate(LocalDate actualDepartureDate) {
        this.actualDepartureDate = actualDepartureDate;
    }

    public LocalDate getDateOfInspectionOperationSignature() {
        return dateOfInspectionOperationSignature;
    }

    public void setDateOfInspectionOperationSignature(LocalDate dateOfInspectionOperationSignature) {
        this.dateOfInspectionOperationSignature = dateOfInspectionOperationSignature;
    }

    public LocalDate getDateOfBunkeringOperationSignature() {
        return dateOfBunkeringOperationSignature;
    }

    public void setDateOfBunkeringOperationSignature(LocalDate dateOfBunkeringOperationSignature) {
        this.dateOfBunkeringOperationSignature = dateOfBunkeringOperationSignature;
    }
}
