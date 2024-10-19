package be.kdg.prog6.boundedcontextWarehouse.adapter.in;

import be.kdg.prog6.boundedcontextWarehouse.domain.AppointmentId;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;
import be.kdg.prog6.boundedcontextWarehouse.port.in.HandleConveyorPayloadDumpPort;
import be.kdg.prog6.common.events.ConveyorPayloadDumpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WarehouseDumpListener {
    private static final Logger log = LoggerFactory.getLogger(WarehouseDumpListener.class);

    public static final String MATERIAL_DUMPED_QUEUE = "material_dumped";

    private final HandleConveyorPayloadDumpPort handleConveyorPayloadDumpPort;

    @Autowired
    public WarehouseDumpListener(HandleConveyorPayloadDumpPort handleConveyorPayloadDumpPort) {
        this.handleConveyorPayloadDumpPort = handleConveyorPayloadDumpPort;
    }

    @RabbitListener(queues = MATERIAL_DUMPED_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
    public void warehouseUpdated(ConveyorPayloadDumpEvent event) {
        log.info("WarehouseEvent has been received {}", event);
        handleConveyorPayloadDumpPort.handleConveyorPayloadDump(
                new AppointmentId(event.appointmentId()),
                LocalDateTime.parse(event.timestampString()),
                new WarehouseId(event.warehouseId())
        );
    }

}
