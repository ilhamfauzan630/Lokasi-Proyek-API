package ilhamfauzan.lokasiproyek.controller;

import ilhamfauzan.lokasiproyek.model.AddProyekLokasiRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.service.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
