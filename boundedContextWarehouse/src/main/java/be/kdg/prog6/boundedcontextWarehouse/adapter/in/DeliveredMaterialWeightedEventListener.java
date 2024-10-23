package be.kdg.prog6.boundedcontextWarehouse.adapter.in;

import be.kdg.prog6.boundedcontextWarehouse.domain.AppointmentId;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialWeightCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialWeightUseCase;
import be.kdg.prog6.common.events.DeliveredMaterialWeightedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveredMaterialWeightedEventListener {
    private static final Logger logger = LoggerFactory.getLogger(DeliveredMaterialWeightedEventListener.class);
    public static final String MATERIAL_WEIGHTED_QUEUE = "material_weighted";

    private final ReceiveMaterialWeightUseCase receiveMaterialWeightUseCase;

    @Autowired
    public DeliveredMaterialWeightedEventListener(ReceiveMaterialWeightUseCase receiveMaterialWeightUseCase) {
        this.receiveMaterialWeightUseCase = receiveMaterialWeightUseCase;
    }

    @RabbitListener(queues = MATERIAL_WEIGHTED_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void handleWeightedMaterial(DeliveredMaterialWeightedCommand event) {
        logger.info("WarehouseEvent has been received {}", event);
        receiveMaterialWeightUseCase.receiveMaterialWeight(new ReceiveMaterialWeightCommand(
                new AppointmentId(event.appointmentId()),
                event.deliveredWeight()
        ));
    }
}
