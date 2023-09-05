package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertiesDataTest
{

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url=pobj.getProperty("url");
		String browser=pobj.getProperty("browser");
		String user=pobj.getProperty("username");
		String pwd=pobj.getProperty("password");
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(user);
		System.out.println(pwd);
		
	}

}