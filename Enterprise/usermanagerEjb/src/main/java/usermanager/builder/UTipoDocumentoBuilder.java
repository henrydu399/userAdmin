package usermanager.builder;

import usermanager.dto.UTipoDocumentoDTO;
import usermanager.entity.UTipoDocumento;


public class UTipoDocumentoBuilder   {


public static UTipoDocumentoDTO of ( UTipoDocumento e ) {
UTipoDocumentoDTO dto = UTipoDocumentoDTO.builder()
.tdIdDTO(e.getTdId())
.tdPrefijoDTO(e.getTdPrefijo())
.tdTipoDTO(e.getTdTipo())

.build();
return dto;
}

public static UTipoDocumento of ( UTipoDocumentoDTO e ) {
UTipoDocumento dto = UTipoDocumento.builder()
.tdId(e.getTdIdDTO())
.tdPrefijo(e.getTdPrefijoDTO())
.tdTipo(e.getTdTipoDTO())

.build();
return dto;
}
}