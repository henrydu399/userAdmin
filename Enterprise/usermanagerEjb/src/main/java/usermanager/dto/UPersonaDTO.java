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
public class UPersonaDTO implements Serializable {

private UPersonaPKDTO idDTO;
private int pEdadDTO;
private Timestamp pFechaCreacionDTO;
private Date p_fecha_nacimientoDTO;
private byte p_hijosDTO;
private String pPrimerApellidoDTO;
private String pPrimerNombreDTO;
private String pSegundoApellidoDTO;
private String pSegundoNombreDTO;
private String pTelefonoCelularDTO;
private List<UDatosContactoDTO> UDatosContactosDTO;
private UEstadoCivileDTO UEstadoCivileDTO;
private UTipoDocumentoDTO UTipoDocumentoDTO;
private List<UUserDTO> UUsersDTO;

}