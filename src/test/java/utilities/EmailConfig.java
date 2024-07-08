

package utilities;

//import org.selenium.constants.FrameworkConstants;


/**
 * Data for Sending EMail after execution
 */
public class EmailConfig {
	
	private static final String Project_Name = "Automation Test Suite Report -Merx Application";

	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "587";

	public static final String FROM = "pullaiag@pepkorit.com";
	public static final String PASSWORD = "";

	/* "**********@gmail.com", */
	public static final String[] TO = {"prakashk@pepkorit.com","vinaym@pepkorit.com","anjaiahm@pepkorit.com"};
	public static final String SUBJECT = Project_Name;
}