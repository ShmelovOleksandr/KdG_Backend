package be.kdg.prog6.boundedcontextWarehouse.port.out.persistance;

import be.kdg.prog6.boundedcontextWarehouse.domain.PDT;

public interface PersistPDTPort {
    PDT save(PDT pdt);
}
