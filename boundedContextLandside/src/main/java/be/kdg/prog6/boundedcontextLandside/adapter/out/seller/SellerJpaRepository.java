package be.kdg.prog6.boundedcontextLandside.adapter.out.seller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerJpaRepository extends JpaRepository<SellerJpaEntity, UUID> {
}
