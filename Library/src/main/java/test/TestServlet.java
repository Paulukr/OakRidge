package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String text = "";
		readPropertiesFile(response);

	}
	   private static final String PROP_FILE="config.properties";  
	   public void readPropertiesFile(HttpServletResponse response){  
	       try{  
	         InputStream is = TestServlet.class.getResourceAsStream(PROP_FILE);  
	         Properties prop = new Properties();  
	             prop.load(is);  
	         String directory = prop.getProperty("Directory");  
	             String numberOfFiles = prop.getProperty("NumberOfFiles");  
	         String  fileExtension = prop.getProperty("Extension");  
	             is.close();  
	      /* code to use values read from the file*/  
	             response.getWriter().append("Properties: ").append(directory);
	       }catch(Exception e){  
	    	   System.out.println("Failed to read from " + PROP_FILE + " file.");  
	    	   try {
	    		   response.getWriter().append("Properties: ").append("Failed to read from " + PROP_FILE + " file.");
	    	   } catch (IOException e1)
	    	   {
	    		   e1.printStackTrace();
	    	   }
	       }
		InputStream inputStream = null;
		try {
			try {
				Properties prop = new Properties();
				String propFileName = "config.properties";

				inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					response.getWriter().append("Stream Properties: ")
							.append("property file '" + propFileName + "' not found in the classpath");
				}
			} catch (Exception e) {
				response.getWriter().append("Stream Properties: ").append("Exception: " + e);
			} finally {
				if (inputStream != null)
					try {
						inputStream.close();
					} catch (IOException e) {
					}
			}
		} catch (Exception e) {
		}
	}

}
