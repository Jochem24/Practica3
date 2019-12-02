
public class Client {
	
	private int ID;
	private String Email, PostalAddress;
	
	/** 
	 * @param ID The identifier of the user.
	 * @param Email The email address of the user.
	 * @param PostalAddress The postal address of the user.
	 */
	public Client(int ID,String Email,String PostalAddress) {
		this.ID = ID;
		this.Email = Email;
		this.PostalAddress = PostalAddress;
	}

	/**
	 * Get the value of the ID
	 * @return The integer value of the valuable ID;
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Change the value of ID.
	 * @param iD The new value of ID.
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get the value of the email address.
	 * @return The String value of Email.
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * Change the email address.
	 * @param email The new name of the email address.
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * Get the value of the postal address.
	 * @return The String value of PostalAddress.
	 */
	public String getPostalAddress() {
		return PostalAddress;
	}

	/**
	 * Change the value of the variable postal address.
	 * @param postalAddress The new postal address.
	 */
	public void setPostalAddress(String postalAddress) {
		PostalAddress = postalAddress;
	}

	/**
	 * Write the data of the constructor into a String format.
	 */
	public String toString() {
		return "Client [ID=" + ID + ", Email=" + Email + ", PostalAddress=" + PostalAddress + "]";
	}
	
	/**
	 * Copy the data of an existing class.
	 * @return A new object of the current instance.
	 */
	public Client copy() {
		Client clone = new Client(ID, Email, PostalAddress);
		return(clone);
	}
}
