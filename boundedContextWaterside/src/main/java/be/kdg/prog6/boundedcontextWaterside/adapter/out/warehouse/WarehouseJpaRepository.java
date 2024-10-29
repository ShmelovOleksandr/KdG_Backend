package be.kdg.prog6.boundedcontextWaterside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWaterside.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseJpaRepository extends JpaRepository<WarehouseJpaEntity, UUID> {
    @Query("select w from WarehouseJpaEntity w join fetch w.owner where w.owner.sellerId=:ownerId and w.materialType=:materialType")
    Optional<WarehouseJpaEntity> findByOwner_SellerIdAndMaterialType(UUID ownerId, MaterialType materialType);
}
