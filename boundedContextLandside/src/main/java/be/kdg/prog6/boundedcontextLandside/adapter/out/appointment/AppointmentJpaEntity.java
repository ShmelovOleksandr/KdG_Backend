package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {
    @Id
    @Column(unique = true, nullable = false, columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private String truckLicensePlate;
    private MaterialType expectedMaterialType;
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private SellerJpaEntity seller;

    public AppointmentJpaEntity() {
    }

    public AppointmentJpaEntity(UUID id, String truckLicensePlate, MaterialType expectedMaterialType, LocalDateTime appointmentDate, SellerJpaEntity seller) {
        this.id = id;
        this.truckLicensePlate = truckLicensePlate;
        this.expectedMaterialType = expectedMaterialType;
        this.appointmentDate = appointmentDate;
        this.seller = seller;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTruckLicensePlate() {
        return truckLicensePlate;
    }

    public void setTruckLicensePlate(String truckLicensePlate) {
        this.truckLicensePlate = truckLicensePlate;
    }

    public MaterialType getExpectedMaterialType() {
        return expectedMaterialType;
    }

    public void setExpectedMaterialType(MaterialType expectedMaterialType) {
        this.expectedMaterialType = expectedMaterialType;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public SellerJpaEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerJpaEntity seller) {
        this.seller = seller;
    }
}
