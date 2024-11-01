package be.kdg.prog6.boundedcontextWaterside.adapter.in.po.dto;

import be.kdg.prog6.boundedcontextWaterside.domain.*;

import java.time.LocalDate;
import java.util.UUID;

public record POGetDto(
        String poNumber,
        UUID poId,
        LocalDate date,
//        Customer customer,
//        Seller seller,
        String vesselNumber,
//        List<OrderItem>orderLines
        UUID respectiveSOId
) {
    public static POGetDto of(PO po) {
        return new POGetDto(
                po.getPoNumber(),
                po.getPoId().id(),
                po.getDate(),
                po.getVesselNumber(),
                po.getRespectiveSO() != null ? po.getRespectiveSO().getId().id() : null
        );
    }
}
