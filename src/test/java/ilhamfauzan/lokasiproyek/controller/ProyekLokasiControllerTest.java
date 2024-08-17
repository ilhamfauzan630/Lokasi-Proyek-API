package ilhamfauzan.lokasiproyek.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ilhamfauzan.lokasiproyek.model.AddProyekLokasiRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.repository.ProyekLokasiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProyekLokasiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() { proyekLokasiRepository.deleteAll(); }

    @Test
    void testPostProyekLokasiSuccess() throws Exception {
        AddProyekLokasiRequest request = new AddProyekLokasiRequest();

        request.setProyekId(2);
        request.setLokasiId(8);

        mockMvc.perform(
                post("/api/proyeklokasi")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo( result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertEquals("success", response.getData());
        });
    }

    @Test
    void testPostProyekLokasiNotFound() throws Exception {
        AddProyekLokasiRequest request = new AddProyekLokasiRequest();

        request.setProyekId(3);
        request.setLokasiId(5);

        mockMvc.perform(
                post("/api/proyeklokasi")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isNotFound()
        ).andDo( result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getErrors());
        });
    }

}