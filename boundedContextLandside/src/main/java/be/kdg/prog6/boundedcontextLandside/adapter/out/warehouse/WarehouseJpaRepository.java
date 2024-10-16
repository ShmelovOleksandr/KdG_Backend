package be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseJpaRepository extends JpaRepository<WarehouseJpaEntity, Integer> {

    @Query("select w from WarehouseJpaEntity w join fetch w.owner where w.id = ?1")
    Optional<WarehouseJpaEntity> findByIdWithOwnerFetched(UUID id);

    @Query("select w from WarehouseJpaEntity w join fetch w.owner s where s.id = :id and w.materialTypeStored = :materialType")
    Optional<WarehouseJpaEntity> findBySellerIdAndMaterialTypeStored(UUID id, MaterialType materialType);
}
