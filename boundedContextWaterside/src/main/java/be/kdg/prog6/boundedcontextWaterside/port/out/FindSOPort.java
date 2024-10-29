package be.kdg.prog6.boundedcontextWaterside.port.out;

import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.domain.SOId;

public interface FindSOPort {
    SO findSOById(SOId soId);
}
