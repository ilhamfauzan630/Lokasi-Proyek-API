package ilhamfauzan.lokasiproyek.controller;

import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.model.WebResponse;
import ilhamfauzan.lokasiproyek.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
