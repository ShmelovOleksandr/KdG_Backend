package be.kdg.prog6.boundedcontextWaterside.adapter.out.so;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SOJpaRepository extends JpaRepository<SOJpaEntity, UUID> {
}
