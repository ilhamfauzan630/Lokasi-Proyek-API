package ilhamfauzan.lokasiproyek.service;

import ilhamfauzan.lokasiproyek.model.LokasiRequest;
import ilhamfauzan.lokasiproyek.repository.LokasiRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private Validator validator;
    public void postLokasi(LokasiRequest request) {
        Set<ConstraintViolation<LokasiRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            // error
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
