package be.kdg.prog6.boundedcontextLandside.adapter.out.wbt;

import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.AppointmentJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.domain.WBTId;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "WBTs")
public class WBTJpaEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal entranceWeight;

    private BigDecimal exitWeight;

    @OneToOne(optional = false)
    private AppointmentJpaEntity appointment;

    public WBTJpaEntity() {
    }

    public WBTJpaEntity(UUID id, BigDecimal entranceWeight, BigDecimal exitWeight, AppointmentJpaEntity appointment) {
        this.id = id;
        this.entranceWeight = entranceWeight;
        this.exitWeight = exitWeight;
        this.appointment = appointment;
    }

    public static WBTJpaEntity of(WBT wbt) {
        return new WBTJpaEntity(
                wbt.getWbtId().id(),
                wbt.getEntranceWeight(),
                wbt.getExitWeight(),
                new AppointmentJpaEntity(wbt.getAppointmentId().id())
        );
    }

    public WBT toDomain() {
        return new WBT(
                new WBTId(this.id),
                new AppointmentId(this.getAppointment().getId()),
                this.entranceWeight,
                this.exitWeight
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public AppointmentJpaEntity getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentJpaEntity appointment) {
        this.appointment = appointment;
    }
}