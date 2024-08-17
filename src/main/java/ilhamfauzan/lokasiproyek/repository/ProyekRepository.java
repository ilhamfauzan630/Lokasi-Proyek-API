package ilhamfauzan.lokasiproyek.repository;

import ilhamfauzan.lokasiproyek.entity.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, String> {
}
