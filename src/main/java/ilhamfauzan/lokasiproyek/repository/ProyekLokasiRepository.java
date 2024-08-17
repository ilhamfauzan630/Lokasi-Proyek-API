package ilhamfauzan.lokasiproyek.repository;

import ilhamfauzan.lokasiproyek.entity.ProyekLokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, Integer> {
}
