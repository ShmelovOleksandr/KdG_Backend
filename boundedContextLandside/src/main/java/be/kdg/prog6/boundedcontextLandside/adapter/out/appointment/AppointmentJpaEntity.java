package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.*;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {
    @Id
    @Column(unique = true, nullable = false, columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(nullable = false)
    private String truckLicensePlate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaterialType expectedMaterialType;

    @Column(nullable = false)
    private LocalDate date;

    private LocalDateTime entranceTime;

    private LocalDateTime departureTime;

    @ManyToOne(optional = false)
    private HourSlotJpaEntity hourSlot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id")
    private SellerJpaEntity seller;

    public AppointmentJpaEntity() {
    }

    public AppointmentJpaEntity(UUID id) {
        this.id = id;
    }

    public AppointmentJpaEntity(UUID id, String truckLicensePlate, MaterialType expectedMaterialType, LocalDate date, LocalDateTime entranceTime, LocalDateTime departureTime, HourSlotJpaEntity hourSlot, SellerJpaEntity seller) {
        this.id = id;
        this.truckLicensePlate = truckLicensePlate;
        this.expectedMaterialType = expectedMaterialType;
        this.date = date;
        this.entranceTime = entranceTime;
        this.departureTime = departureTime;
        this.hourSlot = hourSlot;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public HourSlotJpaEntity getHourSlot() {
        return hourSlot;
    }

    public void setHourSlot(HourSlotJpaEntity hourSlot) {
        this.hourSlot = hourSlot;
    }

    public SellerJpaEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerJpaEntity seller) {
        this.seller = seller;
    }

    public Appointment toDomain() {
        return new Appointment(
                new AppointmentId(this.id),
                new SellerId(this.seller.getId()),
                new LicensePlate(this.truckLicensePlate),
                this.expectedMaterialType,
                this.date,
                new Hour(this.hourSlot.getHour()),
                this.entranceTime,
                this.departureTime
        );
    }

    public static AppointmentJpaEntity of(Appointment appointment) {
        HourSlotJpaEntity hourSlot = HourSlotJpaEntity.of(new HourSlot(appointment.getArrivalHour().hourNumber()));
        hourSlot.setAppointmentManager(new AppointmentManagerJpaEntity(appointment.getDate()));

        return new AppointmentJpaEntity(
                appointment.getAppointmentId().id(),
                appointment.getLicensePlate().licensePlateString(),
                appointment.getMaterialType(),
                appointment.getDate(),
                appointment.getEntranceTime(),
                appointment.getDepartureTime(),
                hourSlot,
                SellerJpaEntity.of(appointment.getSellerId())
        );
    }

}
