package usermanager.builder;

import usermanager.dto.UFuncioneDTO;
import usermanager.entity.UFuncione;


public class UFuncioneBuilder   {


public static UFuncioneDTO of ( UFuncione e ) {
UFuncioneDTO dto = UFuncioneDTO.builder()
.fIdDTO(e.getFId())
.fDescripcionDTO(e.getFDescripcion())
.fNombreDTO(e.getFNombre())
.URoleDTO(URoleBuilder.of(e.getURole()))

.build();
return dto;
}

public static UFuncione of ( UFuncioneDTO e ) {
UFuncione dto = UFuncione.builder()
.fId(e.getFIdDTO())
.fDescripcion(e.getFDescripcionDTO())
.fNombre(e.getFNombreDTO())
.URole(URoleBuilder.of(e.getURoleDTO()))

.build();
return dto;
}
}