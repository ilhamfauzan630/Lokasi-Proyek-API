package ilhamfauzan.lokasiproyek.service;

import ilhamfauzan.lokasiproyek.entity.Proyek;
import ilhamfauzan.lokasiproyek.model.AddProyekRequest;
import ilhamfauzan.lokasiproyek.repository.ProyekRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
}
