package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.dom.FacilityDetail;

public interface GetCurrentTruckNumberUseCase {
    FacilityDetail findCurrentTruckNumberInTheFacility();
}
