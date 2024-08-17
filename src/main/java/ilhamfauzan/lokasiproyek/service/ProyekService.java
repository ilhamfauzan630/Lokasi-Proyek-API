package ilhamfauzan.lokasiproyek.service;

import ilhamfauzan.lokasiproyek.entity.Lokasi;
import ilhamfauzan.lokasiproyek.entity.Proyek;
import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.model.AddProyekRequest;
import ilhamfauzan.lokasiproyek.repository.ProyekRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void postProyekService(AddProyekRequest request) {
        Set<ConstraintViolation<AddProyekRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }

        Proyek proyek = new Proyek();
        proyek.setNamaProyek(request.getNamaProyek());
        proyek.setClient(request.getClient());
        proyek.setTglMulai(request.getTglMulai());
        proyek.setTglSelesai(request.getTglSelesai());
        proyek.setPimpinanProyek(request.getPimpinanProyek());
        proyek.setKeterangan(request.getKeterangan());
        proyek.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return  proyekRepository.findAll();
    }

    public Proyek updateProyek(Integer id, AddProyekRequest request) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "proyek tidak ditemukan"));

        proyek.setNamaProyek(request.getNamaProyek());
        proyek.setClient(request.getClient());
        proyek.setTglMulai(request.getTglMulai());
        proyek.setTglSelesai(request.getTglSelesai());
        proyek.setPimpinanProyek(request.getPimpinanProyek());
        proyek.setKeterangan(request.getKeterangan());

        return proyekRepository.save(proyek);
    }

    public void deleteProyek(Integer id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "lokasi tidak ditemukan"));
        proyekRepository.delete(proyek);
    }
}
