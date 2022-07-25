package usermanager.builder;

import usermanager.dto.UPersonaPKDTO;
import usermanager.entity.UPersonaPK;


public class UPersonaPKBuilder   {


public static UPersonaPKDTO of ( UPersonaPK e ) {
UPersonaPKDTO dto = UPersonaPKDTO.builder()
.pIdTipoIdentificacionDTO(e.getPIdTipoIdentificacion())
.pNumeroIdentificacionDTO(e.getPNumeroIdentificacion())
.build();
return dto;
}

public static UPersonaPK of ( UPersonaPKDTO e ) {
UPersonaPK dto = UPersonaPK.builder()
.pIdTipoIdentificacion(e.getPIdTipoIdentificacionDTO())
.pNumeroIdentificacion(e.getPNumeroIdentificacionDTO())
.build();
return dto;
}
}