package usermanager.builder;

import usermanager.dto.UEstadoCivileDTO;
import usermanager.entity.UEstadoCivile;


public class UEstadoCivileBuilder   {


public static UEstadoCivileDTO of ( UEstadoCivile e ) {
UEstadoCivileDTO dto = UEstadoCivileDTO.builder()
.ecIdDTO(e.getEcId())
.ecBombreDTO(e.getEcBombre())

.build();
return dto;
}

public static UEstadoCivile of ( UEstadoCivileDTO e ) {
UEstadoCivile dto = UEstadoCivile.builder()
.ecId(e.getEcIdDTO())
.ecBombre(e.getEcBombreDTO())

.build();
return dto;
}
}