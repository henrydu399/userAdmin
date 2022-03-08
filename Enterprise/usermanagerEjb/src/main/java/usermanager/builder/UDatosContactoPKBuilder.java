package usermanager.builder;

import usermanager.dto.UDatosContactoPKDTO;
import usermanager.entity.UDatosContactoPK;


public class UDatosContactoPKBuilder   {


public static UDatosContactoPKDTO of ( UDatosContactoPK e ) {
UDatosContactoPKDTO dto = UDatosContactoPKDTO.builder()
.dcIdDTO(e.getDcId())
.dcIdTipoIdentificacionDTO(e.getDcIdTipoIdentificacion())
.dcNumeroIdentificacionDTO(e.getDcNumeroIdentificacion())
.build();
return dto;
}

public static UDatosContactoPK of ( UDatosContactoPKDTO e ) {
UDatosContactoPK dto = UDatosContactoPK.builder()
.dcId(e.getDcIdDTO())
.dcIdTipoIdentificacion(e.getDcIdTipoIdentificacionDTO())
.dcNumeroIdentificacion(e.getDcNumeroIdentificacionDTO())
.build();
return dto;
}
}