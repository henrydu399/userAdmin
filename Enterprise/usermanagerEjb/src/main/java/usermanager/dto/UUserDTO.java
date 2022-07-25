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
public class UUserDTO implements Serializable {

private UUserPKDTO idDTO;
private String uEmailDTO;
private String uTokenSecurityDTO;
private UPersonaDTO UPersonaDTO;
private USistemaDTO USistemaDTO;
private URoleDTO URoleDTO;

}