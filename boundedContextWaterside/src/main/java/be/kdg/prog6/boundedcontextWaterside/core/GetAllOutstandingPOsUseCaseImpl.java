package be.kdg.prog6.boundedcontextWaterside.core;

import be.kdg.prog6.boundedcontextWaterside.domain.PO;
import be.kdg.prog6.boundedcontextWaterside.port.in.GetAllOutstandingPOsUseCase;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindPOPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetAllOutstandingPOsUseCaseImpl implements GetAllOutstandingPOsUseCase {
    private final FindPOPort findPOPort;

    @Autowired
    public GetAllOutstandingPOsUseCaseImpl(FindPOPort findPOPort) {
        this.findPOPort = findPOPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PO> getAllOutstandingPOs() {
        return findPOPort.findAllOutstandingPOs();
    }
}
