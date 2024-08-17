package ilhamfauzan.lokasiproyek.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProyekLokasiRequest {
    @NotNull
    private Integer proyekId;

    @NotNull
    private Integer lokasiId;
}
