package be.kdg.prog6.boundedcontextLandside;

import be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto.AppointmentPostDto;
import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWarehousePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class AppointmentRestControllerIntegrationTest extends AbstractDatabaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private PersistWarehousePort persistWarehousePort;


    @Test
    void shouldCreateAppointmentIfValidDataIsPassed() throws Exception {
        //Arrange
        final UUID SELLER_ID = UUID.randomUUID();
        final String LICENSE_PLATE = "test";
        final MaterialType MATERIAL_TYPE = MaterialType.PETCOKE;
        final LocalDate DATE = LocalDate.of(2100, 1, 1);
        final int PREFERRED_HOUR = 12;

        AppointmentPostDto appointmentPostDto = new AppointmentPostDto(
                SELLER_ID,
                LICENSE_PLATE,
                MATERIAL_TYPE,
                DATE,
                PREFERRED_HOUR
        );

        persistWarehousePort.save(new Warehouse(
                new WarehouseId(UUID.randomUUID()),
                new SellerId(SELLER_ID),
                new Material(MATERIAL_TYPE, new BigDecimal(0)),
                new BigDecimal(500)
        ));

        //Act
        String appointmentJson = mapper.writeValueAsString(appointmentPostDto);
        ResultActions resultActions = mockMvc.perform(post("/api/v1/appointments").content(appointmentJson).contentType(APPLICATION_JSON_UTF8).with(csrf()));

        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.sellerId", equalTo(SELLER_ID.toString())))
                .andExpect(jsonPath("$.licensePlate", equalTo(LICENSE_PLATE)))
                .andExpect(jsonPath("$.materialType", equalTo(MATERIAL_TYPE.toString())))
                .andExpect(jsonPath("$.scheduledDate", equalTo(DATE.toString())))
                .andExpect(jsonPath("$.preferredHour", equalTo(PREFERRED_HOUR)));
    }

}
