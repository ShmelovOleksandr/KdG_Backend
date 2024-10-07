package be.kdg.prog6.boundedcontextLandside.adapter.out.mapping.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.WarehouseJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.Material;
import be.kdg.prog6.boundedcontextLandside.domain.SellerId;
import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;


public class WarehouseJpaToDomainConverter implements Converter<WarehouseJpaEntity, Warehouse> {
    @Override
    public Warehouse convert(MappingContext<WarehouseJpaEntity, Warehouse> mappingContext) {
        WarehouseJpaEntity warehouseJpaEntity = mappingContext.getSource();
        return new Warehouse(
                new WarehouseId(warehouseJpaEntity.getId()),
                new SellerId(warehouseJpaEntity.getOwner().getId()),
                new Material(
                        warehouseJpaEntity.getMaterialTypeStored(),
                        warehouseJpaEntity.getCurrentCapacity()
                ),
                warehouseJpaEntity.getMaxCapacity()
        );
    }
}
