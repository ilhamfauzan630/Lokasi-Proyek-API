package ilhamfauzan.lokasiproyek.repository;

import ilhamfauzan.lokasiproyek.entity.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}
