package be.kdg.prog6.boundedcontextLandside.adapter.out.wbt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WBTJpaRepository extends JpaRepository<WBTJpaEntity, UUID> {
}
