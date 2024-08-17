package ilhamfauzan.lokasiproyek.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyek_lokasi")
public class ProyekLokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "proyek_id", referencedColumnName = "id")
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", referencedColumnName = "id")
    private Lokasi lokasi;
}