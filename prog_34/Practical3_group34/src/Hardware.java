
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
		super(nombre, value);
		Type = tipo;
	}
	public String toString() {
		return (super.toString()+"Type = "+ Type);
	}
}

