package be.kdg.prog6.boundedcontextWarehouse.adapter.out.mapping.converters;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.WarehouseJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.domain.SellerId;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;


public class WarehouseJpaToDomainConverter implements Converter<WarehouseJpaEntity, Warehouse> {
    @Override
    public Warehouse convert(MappingContext<WarehouseJpaEntity, Warehouse> mappingContext) {
        WarehouseJpaEntity warehouseJpaEntity = mappingContext.getSource();
        return new Warehouse(
                new WarehouseId(warehouseJpaEntity.getId()),
                new SellerId(warehouseJpaEntity.getSeller().getId()),
                warehouseJpaEntity.getMaxCapacity(),
                warehouseJpaEntity.getMaterialTypeStored()
        );
    }
}
