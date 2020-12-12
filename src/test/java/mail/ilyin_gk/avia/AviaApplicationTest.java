package mail.ilyin_gk.avia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class AviaApplicationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void crudTest() throws Exception {
        mockMvc.perform(get("/avian/passengers"))
                .andExpect(
                        content()
                                .json("[{\n" +
                                        "    \"id\": 1,\n" +
                                        "    \"flightId\": 1,\n" +
                                        "    \"firstName\": \"Petrov\",\n" +
                                        "    \"secondName\": \"Ivan\",\n" +
                                        "    \"passportNumber\": 980712345,\n" +
                                        "    \"passengerOnBoard\": false,\n" +
                                        "    \"baggageOnBoard\": true\n" +
                                        "  },\n" +
                                        "  {\n" +
                                        "    \"id\": 2,\n" +
                                        "    \"flightId\": 2,\n" +
                                        "    \"firstName\": \"Suvorov\",\n" +
                                        "    \"secondName\": \"Aleksey\",\n" +
                                        "    \"passportNumber\": 634512345,\n" +
                                        "    \"passengerOnBoard\": false,\n" +
                                        "    \"baggageOnBoard\": false\n" +
                                        "  },\n" +
                                        "  {\n" +
                                        "    \"id\": 3,\n" +
                                        "    \"flightId\": 2,\n" +
                                        "    \"firstName\": \"Ivanov\",\n" +
                                        "    \"secondName\": \"Nikolay\",\n" +
                                        "    \"passportNumber\": 987852323,\n" +
                                        "    \"passengerOnBoard\": true,\n" +
                                        "    \"baggageOnBoard\": true\n" +
                                        "  },\n" +
                                        "  {\n" +
                                        "    \"id\": 4,\n" +
                                        "    \"flightId\": 3,\n" +
                                        "    \"firstName\": \"Patin\",\n" +
                                        "    \"secondName\": \"Ivan\",\n" +
                                        "    \"passportNumber\": 980712345,\n" +
                                        "    \"passengerOnBoard\": false,\n" +
                                        "    \"baggageOnBoard\": true\n" +
                                        "  },\n" +
                                        "  {\n" +
                                        "    \"id\": 5,\n" +
                                        "    \"flightId\": 3,\n" +
                                        "    \"firstName\": \"Volkov\",\n" +
                                        "    \"secondName\": \"Aleksey\",\n" +
                                        "    \"passportNumber\": 634512345,\n" +
                                        "    \"passengerOnBoard\": true,\n" +
                                        "    \"baggageOnBoard\": false\n" +
                                        "  },\n" +
                                        "  {\n" +
                                        "    \"id\": 6,\n" +
                                        "    \"flightId\": 3,\n" +
                                        "    \"firstName\": \"Selin\",\n" +
                                        "    \"secondName\": \"Robert\",\n" +
                                        "    \"passportNumber\": 934562323,\n" +
                                        "    \"passengerOnBoard\": false,\n" +
                                        "    \"baggageOnBoard\": true\n" +
                                        "  }]")
                );

    }
}