package usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UTipoDocumentoDTO implements Serializable {

private byte tdIdDTO;
private String tdPrefijoDTO;
private String tdTipoDTO;
private List<UPersonaDTO> UPersonasDTO;

}