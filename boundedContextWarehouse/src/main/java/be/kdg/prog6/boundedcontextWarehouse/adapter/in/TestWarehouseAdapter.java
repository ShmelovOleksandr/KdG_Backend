package be.kdg.prog6.boundedcontextWarehouse.adapter.in;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.WarehouseJpaRepository;
import be.kdg.prog6.boundedcontextWarehouse.domain.Material;
import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.SellerId;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class TestWarehouseAdapter {
    private final ReceiveMaterialUseCase receiveMaterialUseCase;

    @Autowired
    public TestWarehouseAdapter(ReceiveMaterialUseCase receiveMaterialUseCase) {
        this.receiveMaterialUseCase = receiveMaterialUseCase;
    }

    @GetMapping
    public void test() {
        receiveMaterialUseCase.receiveMaterial(new ReceiveMaterialCommand(
                new SellerId(UUID.fromString("ddf45d07-948e-4cdc-b93e-4a02e9337415")),
                new Material(MaterialType.PETCOKE, new BigDecimal(25))
        ));
    }
}
