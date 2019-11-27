public class Software extends Product{
	
	private String NameOS;
	

	public Software(String nombre, double value, int available, String OS){
		super(nombre, value, available);
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
		return ("Software " +super.toString()+" NameOS=" + NameOS + "]");
	}

	
	public Software copy() {
		Software same = new Software(nameProduct, priceProduct, stockProduct, NameOS);
		return same;
	}

}