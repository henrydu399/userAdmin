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
public class URoleDTO implements Serializable {

private int rIdDTO;
private String rDescripcionDTO;
private String rNombreDTO;
private List<UFuncioneDTO> UFuncionesDTO;
private USistemaDTO USistemaDTO;
private List<UUserDTO> UUsersDTO;

}