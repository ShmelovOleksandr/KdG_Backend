package be.kdg.prog6.boundedcontextWarehouse.adapter.in;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;
import be.kdg.prog6.boundedcontextWarehouse.port.in.WarehouseMaterialsUpdater;
import be.kdg.prog6.common.events.WarehouseUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WarehouseUpdateListener {
    private static final Logger log = LoggerFactory.getLogger(WarehouseUpdateListener.class);

    public static final String MATERIAL_UPDATED_QUEUE = "material_updated";

    private final WarehouseMaterialsUpdater warehouseMaterialsUpdater;

    public WarehouseUpdateListener(WarehouseMaterialsUpdater warehouseMaterialsUpdater) {
        this.warehouseMaterialsUpdater = warehouseMaterialsUpdater;
    }

    @RabbitListener(queues = MATERIAL_UPDATED_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void warehouseUpdated(WarehouseUpdatedEvent event) {
        log.info("WarehouseEvent has been received {}", event);
        warehouseMaterialsUpdater.updateWarehouse(
                new WarehouseId(event.warehouseId()),
                WarehouseActivityType.valueOf(event.activityType()),
                MaterialType.valueOf(event.materialType()),
                event.tons()
        );
    }

}
