package usermanager.builder;

import usermanager.dto.USubFuncionePKDTO;
import usermanager.entity.USubFuncionePK;


public class USubFuncionePKBuilder   {


public static USubFuncionePKDTO of ( USubFuncionePK e ) {
USubFuncionePKDTO dto = USubFuncionePKDTO.builder()
.subfIdDTO(e.getSubfId())
.subfIdFuncionDTO(e.getSubfIdFuncion())
.build();
return dto;
}

public static USubFuncionePK of ( USubFuncionePKDTO e ) {
USubFuncionePK dto = USubFuncionePK.builder()
.subfId(e.getSubfIdDTO())
.subfIdFuncion(e.getSubfIdFuncionDTO())
.build();
return dto;
}
}