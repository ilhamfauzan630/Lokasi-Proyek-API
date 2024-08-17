package ilhamfauzan.lokasiproyek.service;

import ilhamfauzan.lokasiproyek.entity.Lokasi;
import ilhamfauzan.lokasiproyek.entity.Proyek;
import ilhamfauzan.lokasiproyek.entity.ProyekLokasi;
import ilhamfauzan.lokasiproyek.model.AddProyekLokasiRequest;
import ilhamfauzan.lokasiproyek.repository.LokasiRepository;
import ilhamfauzan.lokasiproyek.repository.ProyekLokasiRepository;
import ilhamfauzan.lokasiproyek.repository.ProyekRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class ProyekLokasiService {
    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void postProyekLokasi(AddProyekLokasiRequest request) {
        Set<ConstraintViolation<AddProyekLokasiRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }

        // Temukan entitas Proyek berdasarkan ID
        Proyek proyek = proyekRepository.findById(request.getProyekId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek not found"));

        // Temukan entitas Lokasi berdasarkan ID
        Lokasi lokasi = lokasiRepository.findById(request.getLokasiId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lokasi not found"));

        ProyekLokasi proyekLokasi = new ProyekLokasi();
        proyekLokasi.setProyek(proyek);
        proyekLokasi.setLokasi(lokasi);

        proyekLokasiRepository.save(proyekLokasi);
    }

    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    public void deleteProyekLokasi(Integer id) {
        ProyekLokasi proyeklokasi = proyekLokasiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "proyek_lokasi tidak ditemukan"));
        proyekLokasiRepository.delete(proyeklokasi);
    }
}
