package usermanager.builder;

import usermanager.dto.UUserDTO;
import usermanager.entity.UUser;


public class UUserBuilder   {


public static UUserDTO of ( UUser e ) {
UUserDTO dto = UUserDTO.builder()
.idDTO(UUserPKBuilder.of(e.getId()))
.uEmailDTO(e.getUEmail())
.uTokenSecurityDTO(e.getUTokenSecurity())
.UPersonaDTO(UPersonaBuilder.of(e.getUPersona()))
.USistemaDTO(USistemaBuilder.of(e.getUSistema()))
.URoleDTO(URoleBuilder.of(e.getURole()))
.build();
return dto;
}

public static UUser of ( UUserDTO e ) {
UUser dto = UUser.builder()
.id(UUserPKBuilder.of(e.getIdDTO()))
.uEmail(e.getUEmailDTO())
.uTokenSecurity(e.getUTokenSecurityDTO())
.UPersona(UPersonaBuilder.of(e.getUPersonaDTO()))
.USistema(USistemaBuilder.of(e.getUSistemaDTO()))
.URole(URoleBuilder.of(e.getURoleDTO()))
.build();
return dto;
}
}