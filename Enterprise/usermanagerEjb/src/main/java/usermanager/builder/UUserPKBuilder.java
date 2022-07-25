package usermanager.builder;

import usermanager.dto.UUserPKDTO;
import usermanager.entity.UUserPK;


public class UUserPKBuilder   {


public static UUserPKDTO of ( UUserPK e ) {
UUserPKDTO dto = UUserPKDTO.builder()
.uIdDTO(e.getUId())
.uIdTipoIdentificacionDTO(e.getUIdTipoIdentificacion())
.uNumeroIdentificacionDTO(e.getUNumeroIdentificacion())
.build();
return dto;
}

public static UUserPK of ( UUserPKDTO e ) {
UUserPK dto = UUserPK.builder()
.uId(e.getUIdDTO())
.uIdTipoIdentificacion(e.getUIdTipoIdentificacionDTO())
.uNumeroIdentificacion(e.getUNumeroIdentificacionDTO())
.build();
return dto;
}
}