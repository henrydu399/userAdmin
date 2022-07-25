package usermanager.builder;

import usermanager.dto.USubFuncioneDTO;
import usermanager.entity.USubFuncione;


public class USubFuncioneBuilder   {


public static USubFuncioneDTO of ( USubFuncione e ) {
USubFuncioneDTO dto = USubFuncioneDTO.builder()
.idDTO(USubFuncionePKBuilder.of(e.getId()))
.subfNombreDTO(e.getSubfNombre())
.UFuncioneDTO(UFuncioneBuilder.of(e.getUFuncione()))
.build();
return dto;
}

public static USubFuncione of ( USubFuncioneDTO e ) {
USubFuncione dto = USubFuncione.builder()
.id(USubFuncionePKBuilder.of(e.getIdDTO()))
.subfNombre(e.getSubfNombreDTO())
.UFuncione(UFuncioneBuilder.of(e.getUFuncioneDTO()))
.build();
return dto;
}
}