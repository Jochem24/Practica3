public class Hardware extends Product{
	
	private HardwareType Type;
	
	
	
	

	/**
	 * @return the type
	 */
	public HardwareType getType() {
		return Type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(HardwareType type) {
		Type = type;
	}

	

	public Hardware(String nombre, HardwareType tipo) {
		super(nombre);
		Type = tipo;
	}
	
	/**
	 * @return the identifier
	 */
	//public int getIdentifier() {
	//	return identifier;
	//}

	/**
	 * @param identifier the identifier to set
	 */
	//public void setIdentifier(int identifier) {
	//	this.identifier = identifier;
	//}

	@Override
	public String toString() {
		return ("[Hardware " +super.toString()+" Type = "+ Type+"]\n");
	}
	
	@Override
	public Hardware copy() {
		Hardware same = new Hardware(nameProduct, Type);
		return same;
	}
}

