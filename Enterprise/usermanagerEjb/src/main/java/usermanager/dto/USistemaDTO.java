package usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.sql.Timestamp;
import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class USistemaDTO implements Serializable {

private int sIdDTO;
private String sNombreDTO;
private List<URoleDTO> URolesDTO;
private List<UUserDTO> UUsersDTO;

}