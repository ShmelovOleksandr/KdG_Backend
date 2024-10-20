package be.kdg.prog6.boundedcontextLandside.adapter.out.weighting_bridge;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.port.out.messaging.TransferDeliveredWeightPort;
import be.kdg.prog6.common.events.DeliveredMaterialWeightedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class WeightDeliveredEventPublisher implements TransferDeliveredWeightPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeightDeliveredEventPublisher.class);
    private static final String EXCHANGE_NAME = "appointment_events";


    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public WeightDeliveredEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishDeliveredWeight(AppointmentId appointmentId, BigDecimal weight) {
        final String ROUTING_KEY = "appointment.%s.material.weighted".formatted(appointmentId.id());
        LOGGER.info("Notifying RabbitMQ: {}", ROUTING_KEY);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, new DeliveredMaterialWeightedEvent(
                UUID.randomUUID(),
                appointmentId.id(),
                weight
        ));
    }
}
