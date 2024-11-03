package be.kdg.prog6.boundedcontextLandside.adapter.in.exception_handler;

import be.kdg.prog6.boundedcontextLandside.domain.exception.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ExceptionHandlerManager {
    @ExceptionHandler(value = { AppointmentForGivenLicensePlateNotFoundException.class })
    public ErrorResponse handleArtistNotFoundException(AppointmentForGivenLicensePlateNotFoundException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { IllegalHourException.class })
    public ErrorResponse handleArtistNotFoundException(IllegalHourException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { NoFreeAppointmentsSlots.class })
    public ErrorResponse handleArtistNotFoundException(NoFreeAppointmentsSlots ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { WarehouseCapacityLimitException.class })
    public ErrorResponse handleArtistNotFoundException(WarehouseCapacityLimitException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { WarehouseMaterialTypeMismatchException.class })
    public ErrorResponse handleArtistNotFoundException(WarehouseMaterialTypeMismatchException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { WarehouseMaxMaterialIsZeroException.class })
    public ErrorResponse handleArtistNotFoundException(WarehouseMaxMaterialIsZeroException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ErrorResponse handleArtistNotFoundException(EntityNotFoundException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = { RuntimeException.class })
    public ErrorResponse handleArtistNotFoundException(RuntimeException ex, WebRequest request) {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
    }
}
