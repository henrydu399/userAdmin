package usermanager.builder;

import java.util.ArrayList;
import java.util.List;



import usermanager.dto.USistemaDTO;
import usermanager.entitys.USistema;

public class SystemaBuilder {
	
	public static List<USistemaDTO> getList(List<USistema> list){
		List<USistemaDTO> listOut = null;
		if (list != null && list.size() >0 ) {
			listOut =  new ArrayList<USistemaDTO>();
			for(USistema temp : list ) {
				listOut.add(get(temp) );
			}
		}
		return listOut;
		
	}
	
	public static USistemaDTO get(USistema in) {		
		USistemaDTO out = USistemaDTO.builder()
				.sNombre(in.getSNombre())
				.sId(in.getSId())
				.build();
		return out;
	}

}
