package ilhamfauzan.lokasiproyek.controller;

import ilhamfauzan.lokasiproyek.entity.Proyek;
import ilhamfauzan.lokasiproyek.model.AddProyekRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping(
            path = "/api/proyek",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> postProyek(@RequestBody AddProyekRequest request) {
        proyekService.postProyekService(request);
        return WebResponse.<String>builder().data("success").build();
    }

    @GetMapping(
            path = "/api/proyek",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<Proyek>> getAllProyek() {
        List<Proyek> listProyek = proyekService.getAllProyek();
        return WebResponse.<List<Proyek>>builder()
                .data(listProyek)
                .build();
    }

    @PutMapping(
            path = "/api/proyek/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Proyek> updateProyek(@PathVariable("id") Integer id, @RequestBody AddProyekRequest request) {
        Proyek updateProyek = proyekService.updateProyek(id, request);
        return WebResponse.<Proyek>builder()
                .data(updateProyek)
                .build();
    }

    @DeleteMapping(
            path = "/api/proyek/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteProyek(@PathVariable("id") Integer id) {
        proyekService.deleteProyek(id);
        return WebResponse.<String>builder()
                .data("proyek berhasi dihapus")
                .build();
    }
 }
