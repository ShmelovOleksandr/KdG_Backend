package be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseJpaRepository extends JpaRepository<WarehouseJpaEntity, Integer> {

    @Query("select w from WarehouseJpaEntity w join fetch w.owner where w.id = ?1")
    Optional<WarehouseJpaEntity> findByIdWithOwnerFetched(UUID id);
}
