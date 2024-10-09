package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters;

import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse.WarehouseJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.Material;
import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class WarehouseDomainToJpaConverter implements Converter<Warehouse, WarehouseJpaEntity> {
    @Override
    public WarehouseJpaEntity convert(MappingContext<Warehouse, WarehouseJpaEntity> mappingContext) {
        Warehouse warehouse = mappingContext.getSource();
        Material currentlyStoredMaterial = warehouse.getCurrentlyStoredMaterial();

        return new WarehouseJpaEntity(
                warehouse.getWarehouseId().id(),
                new SellerJpaEntity(warehouse.getOwnerId().id()),
                warehouse.getMaximumMaterialTons(),
                currentlyStoredMaterial.getTons(),
                currentlyStoredMaterial.getMaterialType()
        );
    }
}
