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
public class USubFuncioneDTO implements Serializable {

private USubFuncionePKDTO idDTO;
private String subfNombreDTO;
private UFuncioneDTO UFuncioneDTO;

}