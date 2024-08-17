package ilhamfauzan.lokasiproyek.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyek")
public class Proyek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama_proyek")
    private String namaProyek;

    private String client;

    @Column(name = "tgl_mulai", columnDefinition = "DATETIME")
    private LocalDateTime tglMulai;

    @Column(name = "tgl_selesai", columnDefinition = "DATETIME")
    private LocalDateTime tglSelesai;

    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;

    private String keterangan;

    @Column(name = "created_at", columnDefinition = "TEXT")
    private Timestamp createdAt;
}
