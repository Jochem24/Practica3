public class Hardware extends Product{
	
	HardwareType Type;

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

	

	public Hardware(String nombre, double value, int available, HardwareType tipo) {
		super(nombre, value, available);
		Type = tipo;
	}
	
	@Override
	public String toString() {
		return ("Hardware " +super.toString()+" Type = "+ Type);
	}
	
	@Override
	public Hardware copy() {
		Hardware same = new Hardware(nameProduct, priceProduct, stockProduct, Type);
		return same;
	}
}