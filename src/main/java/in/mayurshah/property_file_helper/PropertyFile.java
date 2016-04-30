package in.mayurshah.property_file_helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class PropertyFile extends Properties {
	private File file;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2931577611898480740L;
	
	public PropertyFile() throws IOException {
		this("config.properties");
		
	}
	public PropertyFile(Properties properties){
		super(properties);
		
	}
	public PropertyFile(File file) throws IOException{
		super();
		this.file = file;
		if(file.exists()){
			InputStream inputStream = new FileInputStream(file);
			load(inputStream);
			inputStream.close();
		}
	}
	public PropertyFile(String fileName) throws IOException{
		this(new File(fileName));
	}
	
	public void store() throws IOException{
		OutputStream out = new FileOutputStream(file);
		super.store(out, "Write file.");
		out.close();
	}
	
	
}
