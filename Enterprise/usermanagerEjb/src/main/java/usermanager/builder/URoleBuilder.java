package usermanager.builder;

import usermanager.dto.URoleDTO;
import usermanager.entity.URole;


public class URoleBuilder   {


public static URoleDTO of ( URole e ) {
URoleDTO dto = URoleDTO.builder()
.rIdDTO(e.getRId())
.rDescripcionDTO(e.getRDescripcion())
.rNombreDTO(e.getRNombre())

.USistemaDTO(USistemaBuilder.of(e.getUSistema()))

.build();
return dto;
}

public static URole of ( URoleDTO e ) {
URole dto = URole.builder()
.rId(e.getRIdDTO())
.rDescripcion(e.getRDescripcionDTO())
.rNombre(e.getRNombreDTO())

.USistema(USistemaBuilder.of(e.getUSistemaDTO()))

.build();
return dto;
}
}