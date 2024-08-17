package ilhamfauzan.lokasiproyek.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

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

    @Column(name = "tgl_mulai")
    private Timestamp tglMulai;

    @Column(name = "tgl_selesai")
    private Timestamp tglSelesai;

    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;

    private String keterangan;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
