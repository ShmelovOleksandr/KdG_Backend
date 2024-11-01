package be.kdg.prog6.boundedcontextWaterside.core;

import be.kdg.prog6.boundedcontextWaterside.domain.PO;
import be.kdg.prog6.boundedcontextWaterside.port.in.GetAllFulfilledPOsUseCase;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindPOPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFulfilledPOsUseCaseImpl implements GetAllFulfilledPOsUseCase {
    private final FindPOPort findPOPort;

    @Autowired
    public GetAllFulfilledPOsUseCaseImpl(FindPOPort findPOPort) {
        this.findPOPort = findPOPort;
    }

    @Override
    public List<PO> getAllFulfilledPOs() {
        return findPOPort.findAllFulfilledPOs();
    }
}
