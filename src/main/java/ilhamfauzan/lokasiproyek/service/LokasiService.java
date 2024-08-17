package ilhamfauzan.lokasiproyek.service;

import ilhamfauzan.lokasiproyek.entity.Lokasi;
import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.repository.LokasiRepository;
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
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void postLokasi(AddLokasiRequest request) {
        Set<ConstraintViolation<AddLokasiRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            // error
            throw new ConstraintViolationException(constraintViolations);
        }

        Lokasi lokasi = new Lokasi();
        lokasi.setNamaLokasi(request.getNamaLokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());
        lokasi.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi updateLokasi(Integer id, AddLokasiRequest request) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lokasi tidak ditemukan"));

        lokasi.setNamaLokasi(request.getNamaLokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());

        return lokasiRepository.save(lokasi);
    }

    public void deleteLokasi(Integer id) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "lokasi tidak ditemukan"));
        lokasiRepository.delete(lokasi);
    }
}
