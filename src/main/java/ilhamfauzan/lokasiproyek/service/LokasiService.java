package ilhamfauzan.lokasiproyek.service;

import ilhamfauzan.lokasiproyek.entity.Lokasi;
import ilhamfauzan.lokasiproyek.model.AddLokasiRequest;
import ilhamfauzan.lokasiproyek.repository.LokasiRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
}
