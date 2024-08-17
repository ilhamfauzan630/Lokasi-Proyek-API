package ilhamfauzan.lokasiproyek.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProyekRequest {

    @NotBlank
    @Size(max = 100)
    private String namaProyek;

    @NotBlank
    @Size(max = 100)
    private String client;

    private LocalDateTime tglMulai;

    private LocalDateTime tglSelesai;

    @NotBlank
    @Size(max = 100)
    private String pimpinanProyek;

    @NotBlank
    private String keterangan;
}
