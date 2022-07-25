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
public class UEstadoCivileDTO implements Serializable {

private byte ecIdDTO;
private String ecBombreDTO;
private List<UPersonaDTO> UPersonasDTO;

}