package usermanager.builder;

import usermanager.dto.UDatosContactoDTO;
import usermanager.entity.UDatosContacto;


public class UDatosContactoBuilder   {


public static UDatosContactoDTO of ( UDatosContacto e ) {
UDatosContactoDTO dto = UDatosContactoDTO.builder()
.idDTO(UDatosContactoPKBuilder.of(e.getId()))
.dcDireccionDTO(e.getDcDireccion())
.dcEstadoDTO(e.getDcEstado())
.dcTelFijoDTO(e.getDcTelFijo())
.dcTelMovilDTO(e.getDcTelMovil())
.UPersonaDTO(UPersonaBuilder.of(e.getUPersona()))
.build();
return dto;
}

public static UDatosContacto of ( UDatosContactoDTO e ) {
UDatosContacto dto = UDatosContacto.builder()
.id(UDatosContactoPKBuilder.of(e.getIdDTO()))
.dcDireccion(e.getDcDireccionDTO())
.dcEstado(e.getDcEstadoDTO())
.dcTelFijo(e.getDcTelFijoDTO())
.dcTelMovil(e.getDcTelMovilDTO())
.UPersona(UPersonaBuilder.of(e.getUPersonaDTO()))
.build();
return dto;
}
}