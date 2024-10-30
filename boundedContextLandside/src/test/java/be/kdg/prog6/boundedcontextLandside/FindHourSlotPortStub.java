package be.kdg.prog6.boundedcontextLandside;

import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindHourSlotPort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FindHourSlotPortStub implements FindHourSlotPort {
    public static final LocalDate HOUR_SLOT_DATE = LocalDate.of(2100, 1, 1);
    public static final int HOUR_SLOT_HOUR = 12;
    public static final AppointmentId APPOINTMENT_ID = new AppointmentId(UUID.randomUUID());
    public static final SellerId SELLER_ID = new SellerId(UUID.randomUUID());
    public static final LicensePlate LICENSE_PLATE = new LicensePlate("test");
    public static final MaterialType MATERIAL_TYPE = MaterialType.PETCOKE;
    public static final LocalDate APPOINTMENT_DATE = LocalDate.of(2100, 1, 1);
    public static final Hour ARRIVAL_HOUR = new Hour(HOUR_SLOT_HOUR);

    @Override
    public HourSlot findCurrentHourSlot() {
        return new HourSlot(HOUR_SLOT_DATE, HOUR_SLOT_HOUR, new ArrayList<>(List.of(
                new Appointment(
                        APPOINTMENT_ID,
                        SELLER_ID,
                        LICENSE_PLATE,
                        MATERIAL_TYPE,
                        APPOINTMENT_DATE,
                        ARRIVAL_HOUR
                )
        )));
    }

    @Override
    public HourSlot findHourSlotByDateAndHour(LocalDate date, Hour hour) {
        return null;
    }
}
