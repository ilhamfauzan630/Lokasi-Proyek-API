package ilhamfauzan.lokasiproyek.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.model.AddProyekRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.repository.ProyekRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProyekControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() { proyekRepository.deleteAll(); }

    @Test
    void testAddProyekSuccess() throws Exception{
        AddProyekRequest request = new AddProyekRequest();
        request.setNamaProyek("Proyek x");
        request.setClient("Client 1");
        request.setTglMulai(LocalDateTime.of(2024, 8, 1, 10, 0));
        request.setTglSelesai(LocalDateTime.of(2024, 12, 31, 18, 0));
        request.setPimpinanProyek("Pimpinan y");
        request.setKeterangan("Proyek pembangunan");

        mockMvc.perform(
                post("/api/proyek")
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
}