package be.kdg.prog6.boundedcontextLandside.adapter.out.weighting_bridge;

import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.port.out.AnnounceWeightingBridgeEntrancePassagePort;
import be.kdg.prog6.common.events.WeightingBridgePassageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class WeightingBridgePassageEventPublisher implements AnnounceWeightingBridgeEntrancePassagePort {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeightingBridgePassageEventPublisher.class);
    private static final String EXCHANGE_NAME = "weighting_bridge_events";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public WeightingBridgePassageEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void announceWeightingBridgeEntrancePassage(Warehouse destinaitonWarehouse, BigDecimal truckWeight) {
        final String ROUTING_KEY = "weightingbridge.passed";
        LOGGER.info("");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, new WeightingBridgePassageEvent(
                UUID.randomUUID(),
                LocalDateTime.now(),
                destinaitonWarehouse.getWarehouseId().id(),
                WeightingBridgePassageEvent.Type.ENTRANCE,
                truckWeight
        ));
    }
}
