package administradorUsers.enums;

public enum MethodsEnum {
	
	SAVE("GUARDAR"),
	EDITH("EDITAR"),
	DELETE("BORRAR"),
	DESACTIVATE ("DESACTIVAR"),
	GETBYID("BUSCAR POR ID"),
	GETALL ("TRAER TODO"),
	FIND_CUSTOM("BUSCAR FILTRO");
	
	private String valueName;
	

	private MethodsEnum(String valueName) {
		this.valueName = valueName;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	
	

}
