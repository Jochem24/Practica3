package FileManagement;
import java.io.*;


public class MyObjectOutputStream extends ObjectOutputStream{

	protected void writeStreamHeader() throws IOException{
		
	}
	
	public MyObjectOutputStream() throws IOException, SecurityException {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyObjectOutputStream(OutputStream out)throws IOException{
		super(out);
	}
}
