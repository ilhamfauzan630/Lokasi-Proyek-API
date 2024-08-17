package ilhamfauzan.lokasiproyek.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.repository.LokasiRepository;
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
class LokasiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        lokasiRepository.deleteAll();
    }
    @Test
    void testAddLocationSuccess() throws Exception{
        AddLokasiRequest request = new AddLokasiRequest();
        request.setNamaLokasi("lokasi1");
        request.setNegara("indonesia");
        request.setProvinsi("jawa barat");
        request.setKota("bandung");

        mockMvc.perform(
            post("/api/lokasi")
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
    void testAddLocationBadRequest() throws Exception{
        AddLokasiRequest request = new AddLokasiRequest();
        request.setNamaLokasi("");
        request.setNegara("");
        request.setProvinsi("");
        request.setKota("");

        mockMvc.perform(
                post("/api/lokasi")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo( result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getErrors());
        });
    }
}