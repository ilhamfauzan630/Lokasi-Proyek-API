package ilhamfauzan.lokasiproyek.controller;

import ilhamfauzan.lokasiproyek.entity.ProyekLokasi;
import ilhamfauzan.lokasiproyek.model.AddProyekLokasiRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.service.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProyekLokasiController {
    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @PostMapping(
            path = "/api/proyeklokasi",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> postProyekLokasi(@RequestBody AddProyekLokasiRequest request) {
        proyekLokasiService.postProyekLokasi(request);
        return WebResponse.<String>builder().data("success").build();
    }

    @GetMapping(
            path = "/api/proyeklokasi",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<ProyekLokasi>> getAllProyekLokasi() {
        List<ProyekLokasi> listProyekLokasi = proyekLokasiService.getAllProyekLokasi();
        return WebResponse.<List<ProyekLokasi>>builder()
                .data(listProyekLokasi)
                .build();
    }

    @DeleteMapping(
            path = "/api/proyeklokasi/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteProyeklokasi(@PathVariable("id") Integer id) {
        proyekLokasiService.deleteProyekLokasi(id);
        return WebResponse.<String>builder()
                .data("proyek_lokasi berhasi dihapus")
                .build();
    }
}
