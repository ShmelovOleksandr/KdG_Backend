package be.kdg.prog6.boundedcontextLandside.adapter.in.conveyor;

import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.in.DumpPayloadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/conveyors")
public class ConveyorRestController {
    private final DumpPayloadUseCase dumpPayloadUseCase;

    @Autowired
    public ConveyorRestController(DumpPayloadUseCase dumpPayloadUseCase) {
        this.dumpPayloadUseCase = dumpPayloadUseCase;
    }

    @PostMapping("/{warehouseId}")
    public ResponseEntity<Void> handlePayloadDump(@PathVariable UUID warehouseId) {
        dumpPayloadUseCase.handlePayloadDelivery(new WarehouseId(warehouseId));
        return ResponseEntity.noContent().build();
    }
}
