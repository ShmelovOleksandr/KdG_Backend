package be.kdg.prog6.boundedcontextLandside.adapter.out.weighting_bridge;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.out.messaging.AnnounceConveyorPayloadDumpPort;
import be.kdg.prog6.common.events.ConveyorPayloadDumpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ConveyorPayloadDumpPortEventPublisher implements AnnounceConveyorPayloadDumpPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConveyorPayloadDumpPortEventPublisher.class);
    private static final String EXCHANGE_NAME = "warehouse_events";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ConveyorPayloadDumpPortEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void announceConveyorPayloadDump(AppointmentId appointmentId, WarehouseId destinaitonWarehouseId) {
        final String ROUTING_KEY = "warehouse.%s.material.dumped".formatted(destinaitonWarehouseId.id());
        LOGGER.info("Notifying RabbitMQ: {}", ROUTING_KEY);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, new ConveyorPayloadDumpEvent(
                UUID.randomUUID(),
                LocalDateTime.now().toString(),
                appointmentId.id(),
                destinaitonWarehouseId.id()
        ));
    }
}
