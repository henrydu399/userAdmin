package usermanager.builder;

import usermanager.dto.USistemaDTO;
import usermanager.entity.USistema;

public class USistemaBuilder {

	public static USistemaDTO of(USistema e) {
		USistemaDTO dto = USistemaDTO.builder().sIdDTO(e.getSId()).sNombreDTO(e.getSNombre())

				.build();
		return dto;
	}

	public static USistema of(USistemaDTO e) {
		USistema dto = USistema.builder().sId(e.getSIdDTO()).sNombre(e.getSNombreDTO())

				.build();
		return dto;
	}
}