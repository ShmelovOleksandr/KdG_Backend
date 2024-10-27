package be.kdg.prog6.boundedcontextWaterside.adapter.out.po;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface POJpaRepository extends JpaRepository<POJpaEntity, UUID> {
}
