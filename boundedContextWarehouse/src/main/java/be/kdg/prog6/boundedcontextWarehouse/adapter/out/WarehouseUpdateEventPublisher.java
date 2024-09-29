package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivity;
import be.kdg.prog6.boundedcontextWarehouse.port.out.messaging.NotifyWarehouseUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
public class WarehouseUpdateEventPublisher implements NotifyWarehouseUpdatePort {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseUpdateEventPublisher.class);

    private static final String EXCHANGE_NAME = "warehouse_events";


    private final RabbitTemplate rabbitTemplate;

    public WarehouseUpdateEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void notifyWarehouseUpdated(Warehouse warehouse, WarehouseActivity warehouseActivity) {
        final String ROUTING_KEY = "warehouse." + warehouse.getId() + ".activity.updated";
        LOGGER.info("Notifying RabbitMQ: {}", ROUTING_KEY);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, new WarehouseActivityCreatedEvent(
                warehouse.getId(),
                warehouseActivity.warehouseActivityType(),
                warehouseActivity.tons()
        ));
    }
}
