public class Software extends Product{
	
	private String NameOS;
	//private int identifier;

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



	public Software(String nombre, String OS){
		super(nombre);
		NameOS = OS;
	}


	
	/**
	 * @return the nameOS
	 */
	public String getNameOS() {
		return NameOS;
	}


	/**
	 * @param nameOS the nameOS to set
	 */
	public void setNameOS(String nameOS) {
		NameOS = nameOS;
	}


	@Override
	public String toString() {
		return ("[Software " +super.toString()+" NameOS=" + NameOS + "]\n");
	}

	
	public Software copy() {
		Software same = new Software(nameProduct, NameOS);
		return same;
	}

}
