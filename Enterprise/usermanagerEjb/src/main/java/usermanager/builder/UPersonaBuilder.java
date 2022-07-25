package usermanager.builder;

import usermanager.dto.UPersonaDTO;
import usermanager.entity.UPersona;


public class UPersonaBuilder   {


public static UPersonaDTO of ( UPersona e ) {
UPersonaDTO dto = UPersonaDTO.builder()
.idDTO(UPersonaPKBuilder.of(e.getId()))
.pEdadDTO(e.getPEdad())
.pFechaCreacionDTO(e.getPFechaCreacion())
.p_fecha_nacimientoDTO(e.getP_fecha_nacimiento())
.p_hijosDTO(e.getP_hijos())
.pPrimerApellidoDTO(e.getPPrimerApellido())
.pPrimerNombreDTO(e.getPPrimerNombre())
.pSegundoApellidoDTO(e.getPSegundoApellido())
.pSegundoNombreDTO(e.getPSegundoNombre())
.pTelefonoCelularDTO(e.getPTelefonoCelular())

.UEstadoCivileDTO(UEstadoCivileBuilder.of(e.getUEstadoCivile()))
.UTipoDocumentoDTO(UTipoDocumentoBuilder.of(e.getUTipoDocumento()))

.build();
return dto;
}

public static UPersona of ( UPersonaDTO e ) {
UPersona dto = UPersona.builder()
.id(UPersonaPKBuilder.of(e.getIdDTO()))
.pEdad(e.getPEdadDTO())
.pFechaCreacion(e.getPFechaCreacionDTO())
.p_fecha_nacimiento(e.getP_fecha_nacimientoDTO())
.p_hijos(e.getP_hijosDTO())
.pPrimerApellido(e.getPPrimerApellidoDTO())
.pPrimerNombre(e.getPPrimerNombreDTO())
.pSegundoApellido(e.getPSegundoApellidoDTO())
.pSegundoNombre(e.getPSegundoNombreDTO())
.pTelefonoCelular(e.getPTelefonoCelularDTO())

.UEstadoCivile(UEstadoCivileBuilder.of(e.getUEstadoCivileDTO()))
.UTipoDocumento(UTipoDocumentoBuilder.of(e.getUTipoDocumentoDTO()))

.build();
return dto;
}
}