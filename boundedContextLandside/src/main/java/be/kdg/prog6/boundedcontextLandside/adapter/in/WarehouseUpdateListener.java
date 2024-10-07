package be.kdg.prog6.boundedcontextLandside.adapter.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WarehouseUpdateListener {
    private static final Logger log = LoggerFactory.getLogger(WarehouseUpdateListener.class);

    public static final String MATERIAL_UPDATED_QUEUE = "material_updated";

    @RabbitListener(queues = MATERIAL_UPDATED_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void piggyBankUpdated(final WarehouseUpdatedEvent event) {
        log.info(
                "Warehouse with id {} now contains {} tons of {}",
                event.warehouseId().id(),
                event.material().tons(),
                event.material().materialType()
        );
    }

}
