package be.kdg.prog6.boundedcontextWaterside.adapter.out.po;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface POJpaRepository extends JpaRepository<POJpaEntity, UUID> {

    @Query("select po from POJpaEntity po join fetch po.customer join fetch po.seller join fetch po.so join fetch po.orderLines where po.so != null ")
    List<POJpaEntity> findAllBySoNotNull();

    @Query(value = "select * from pos where so_id is null ", nativeQuery = true)
    List<POJpaEntity> findAllBySoNull();
}
