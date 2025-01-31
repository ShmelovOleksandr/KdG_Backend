package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivity;
import be.kdg.prog6.boundedcontextWarehouse.port.out.messaging.NotifyWarehouseUpdatePort;
import be.kdg.prog6.common.events.WarehouseUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;


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
        final String ROUTING_KEY = "warehouse." + warehouse.getId().id() + ".material.updated";
        LOGGER.info("Notifying RabbitMQ: {}", ROUTING_KEY);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, new WarehouseUpdatedEvent(
                UUID.randomUUID(),
                warehouse.getId().id(),
                warehouseActivity.warehouseActivityType().toString(),
                warehouse.getMaterialTypeStored().toString(),
                warehouseActivity.tons()
        ));
    }
}
