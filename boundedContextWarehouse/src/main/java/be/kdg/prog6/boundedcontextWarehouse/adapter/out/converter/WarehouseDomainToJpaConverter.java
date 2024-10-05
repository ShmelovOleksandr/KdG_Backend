package be.kdg.prog6.boundedcontextWarehouse.adapter.out.converter;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.SellerJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.adapter.out.WarehouseActivityJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.adapter.out.WarehouseActivityWindowJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.adapter.out.WarehouseJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityWindow;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class WarehouseDomainToJpaConverter implements Converter<Warehouse, WarehouseJpaEntity> {
    @Override
    public WarehouseJpaEntity convert(MappingContext<Warehouse, WarehouseJpaEntity> mappingContext) {
        Warehouse warehouse = mappingContext.getSource();

        WarehouseActivityWindow warehouseActivityWindow = warehouse.getWarehouseActivityWindow();
        WarehouseActivityWindowJpaEntity warehouseActivityWindowJpaEntity = new WarehouseActivityWindowJpaEntity(
                warehouseActivityWindow.getWarehouseId().id(),
                warehouseActivityWindow.getActivities().stream().map(
                        warehouseActivity -> new WarehouseActivityJpaEntity(
                                warehouseActivity.warehouseActivityId().id(),
                                warehouseActivity.warehouseId().id(),
                                warehouseActivity.warehouseActivityType(),
                                warehouseActivity.tons()
                        )
                ).toList()
        );

        return new WarehouseJpaEntity(
                warehouse.getId().id(),
                new SellerJpaEntity(warehouse.getOwnerId().id()),
                warehouse.getMaxCapacity(),
                warehouse.getCurrentTons(),
                warehouse.getMaterialTypeStored(),
                warehouseActivityWindowJpaEntity
        );
    }
}
