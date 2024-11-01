package be.kdg.prog6.boundedcontextWaterside.adapter.in.po;

import be.kdg.prog6.boundedcontextWaterside.adapter.in.po.dto.POGetDto;
import be.kdg.prog6.boundedcontextWaterside.domain.PO;
import be.kdg.prog6.boundedcontextWaterside.port.in.GetAllFulfilledPOsUseCase;
import be.kdg.prog6.boundedcontextWaterside.port.in.GetAllOutstandingPOsUseCase;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pos")
@CrossOrigin("http://localhost:5173")
public class PORestController {
    private final GetAllFulfilledPOsUseCase getAllFulfilledPOsUseCase;
    private final GetAllOutstandingPOsUseCase getAllOutstandingPOsUseCase;

    @Autowired
    public PORestController(GetAllFulfilledPOsUseCase getAllFulfilledPOsUseCase, GetAllOutstandingPOsUseCase getAllOutstandingPOsUseCase) {
        this.getAllFulfilledPOsUseCase = getAllFulfilledPOsUseCase;
        this.getAllOutstandingPOsUseCase = getAllOutstandingPOsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<POGetDto>> getPOs(@RequestParam(required = false) Boolean outstanding, @RequestParam(required = false) Boolean fulfilled) {
        List<PO> pos;
//        if (outstanding)
//            pos = getAllOutstandingPOsUseCase.getAllOutstandingPOs();
//        else if (fulfilled)
//            pos = getAllFulfilledPOsUseCase.getAllFulfilledPOs();
        if(outstanding == null && fulfilled != null && fulfilled)
            pos = getAllFulfilledPOsUseCase.getAllFulfilledPOs();
        else if (outstanding != null && fulfilled == null && outstanding)
            pos = getAllOutstandingPOsUseCase.getAllOutstandingPOs();
        else
            //TODO change to getAllPOs()
            pos = getAllOutstandingPOsUseCase.getAllOutstandingPOs();

        return ResponseEntity.ok(pos.stream().map(POGetDto::of).toList());
    }
}
