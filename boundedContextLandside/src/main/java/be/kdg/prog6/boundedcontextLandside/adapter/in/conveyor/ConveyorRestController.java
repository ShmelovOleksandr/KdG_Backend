package be.kdg.prog6.boundedcontextLandside.adapter.in.conveyor;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.in.DumpPayloadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO
// Mapping is shit
@RestController
@RequestMapping("/api/v1/conveyors")
public class ConveyorRestController {
    private final DumpPayloadUseCase dumpPayloadUseCase;

    @Autowired
    public ConveyorRestController(DumpPayloadUseCase dumpPayloadUseCase) {
        this.dumpPayloadUseCase = dumpPayloadUseCase;
    }


    @PostMapping
    public ResponseEntity<Void> handlePayloadDump(@RequestBody ConveyorDumpAnnouncementDto conveyorDumpAnnouncementDto) {
        dumpPayloadUseCase.handlePayloadDelivery(new AppointmentId(conveyorDumpAnnouncementDto.appointmentId()), new WarehouseId(conveyorDumpAnnouncementDto.warehouseId()));
        return ResponseEntity.noContent().build();
    }
}
