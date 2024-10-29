package be.kdg.prog6.boundedcontextWaterside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWaterside.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextWaterside.port.out.NotifyWarehouseUpdatePort;
import be.kdg.prog6.boundedcontextWaterside.domain.OrderItem;
import be.kdg.prog6.boundedcontextWaterside.domain.WarehouseId;
import be.kdg.prog6.common.events.WarehouseUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
    public void notifyWarehouseMaterialDecreased(WarehouseId warehouseId, OrderItem orderItem) {
        final String ROUTING_KEY = "warehouse." + warehouseId.id() + ".material.updated";
        LOGGER.info("Notifying RabbitMQ: {}", ROUTING_KEY);

        BigDecimal tons;
        switch (orderItem.uom()) {
            case KG -> tons = new BigDecimal(orderItem.quantity()/1000);
            case KT -> tons = new BigDecimal(orderItem.quantity()*1000);
            default -> tons = new BigDecimal(orderItem.quantity());
        }

        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, new WarehouseUpdatedEvent(
                UUID.randomUUID(),
                warehouseId.id(),
                WarehouseActivityType.DECREASE.toString(),
                orderItem.materialType().toString(),
                tons
        ));
    }
}
