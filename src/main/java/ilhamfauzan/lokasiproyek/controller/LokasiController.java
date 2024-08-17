package ilhamfauzan.lokasiproyek.controller;

import ilhamfauzan.lokasiproyek.entity.Lokasi;
import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping(
            path = "/api/lokasi",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> postLokasi(@RequestBody AddLokasiRequest request) {
        lokasiService.postLokasi(request);
        return WebResponse.<String>builder().data("success").build();
    }

    @GetMapping(
            path = "/api/lokasi",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<Lokasi>> getAllLokasi(){
        List<Lokasi> listLokasi = lokasiService.getAllLokasi();
        return WebResponse.<List<Lokasi>>builder()
                .data(listLokasi)
                .build();
    }

    @PutMapping(
            path = "/api/lokasi/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Lokasi> updateLokasi(@PathVariable("id") Integer id, @RequestBody AddLokasiRequest request) {
        Lokasi putLokasi = lokasiService.updateLokasi(id, request);
        return WebResponse.<Lokasi>builder()
                .data(putLokasi)
                .build();
    }

    @DeleteMapping(
            path = "/api/lokasi/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteLokasi(@PathVariable("id") Integer id) {
        lokasiService.deleteLokasi(id);
        return WebResponse.<String>builder()
                .data("lokasi berhasi dihapus")
                .build();
    }
}
