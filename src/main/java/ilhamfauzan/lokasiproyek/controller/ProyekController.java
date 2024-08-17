package ilhamfauzan.lokasiproyek.controller;

import ilhamfauzan.lokasiproyek.model.AddProyekRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
