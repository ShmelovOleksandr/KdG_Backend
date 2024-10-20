package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WarehouseJpaRepository extends JpaRepository<WarehouseJpaEntity, UUID> {
    @Query("select w from WarehouseJpaEntity w " +
            "join fetch w.seller " +
            "join fetch w.warehouseActivityWindow wa " +
            //TODO Because of the line below the return value is Optional.empty
//            "join fetch w.warehouseActivityWindow.activities " +
            "where w.id = ?1")
    Optional<WarehouseJpaEntity> findByIdFetched(UUID id);

    @Query("select w from WarehouseJpaEntity w join fetch w.seller join fetch w.warehouseActivityWindow where w.seller.id = ?1 and w.materialTypeStored = ?2")
    Optional<WarehouseJpaEntity> findAllBySeller_IdAndMaterialTypeStored(UUID sellerId, MaterialType materialTypeStored);
}
