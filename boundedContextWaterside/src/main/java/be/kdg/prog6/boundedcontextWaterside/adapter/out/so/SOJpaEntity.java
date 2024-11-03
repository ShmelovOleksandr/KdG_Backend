package be.kdg.prog6.boundedcontextWaterside.adapter.out.so;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.po.POJpaEntity;
import be.kdg.prog6.boundedcontextWaterside.domain.POId;
import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.domain.SOId;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "SOs")
public class SOJpaEntity {
    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private UUID soId;

    @OneToOne
    @JoinColumn(name = "poId", referencedColumnName = "poId")
    private POJpaEntity po;

    @Column(nullable = false)
    private String vesselNumber;

    @Column(nullable = false)
    private LocalDate estimatedArrivalDate;

    @Column(nullable = false)
    private LocalDate estimatedDepartureDate;

    private LocalDate actualArrivalDate;
    private LocalDate actualDepartureDate;
    private LocalDate dateOfInspectionOperationSignature;
    private LocalDate dateOfBunkeringOperationSignature;

    public SOJpaEntity() {
    }

    public SOJpaEntity(UUID soId, POJpaEntity po, String vesselNumber, LocalDate estimatedArrivalDate, LocalDate estimatedDepartureDate, LocalDate actualArrivalDate, LocalDate actualDepartureDate, LocalDate dateOfInspectionOperationSignature, LocalDate dateOfBunkeringOperationSignature) {
        this.soId = soId;
        this.po = po;
        this.vesselNumber = vesselNumber;
        this.estimatedArrivalDate = estimatedArrivalDate;
        this.estimatedDepartureDate = estimatedDepartureDate;
        this.actualArrivalDate = actualArrivalDate;
        this.actualDepartureDate = actualDepartureDate;
        this.dateOfInspectionOperationSignature = dateOfInspectionOperationSignature;
        this.dateOfBunkeringOperationSignature = dateOfBunkeringOperationSignature;
    }

    public static SOJpaEntity of(SO so) {
        return new SOJpaEntity(
                so.getId().id(),
                new POJpaEntity(so.getPurchaseOrderId().id()),
                so.getVesselNumber(),
                so.getEstimatedArrivalDate(),
                so.getEstimatedDepartureDate(),
                so.getActualArrivalDate(),
                so.getActualDepartureDate(),
                so.getDateOfInspectionOperationSignature(),
                so.getDateOfBunkeringOperationSignature()
        );
    }

    public SO toDomain() {
        return new SO(
                new SOId(this.soId),
                new POId(this.po.getPoId()),
                this.vesselNumber,
                this.estimatedArrivalDate,
                this.estimatedDepartureDate,
                this.actualArrivalDate,
                this.actualDepartureDate,
                this.dateOfInspectionOperationSignature,
                this.dateOfBunkeringOperationSignature
        );
    }

    public UUID getSoId() {
        return soId;
    }

    public void setSoId(UUID soId) {
        this.soId = soId;
    }

    public POJpaEntity getPo() {
        return po;
    }

    public void setPo(POJpaEntity po) {
        this.po = po;
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
