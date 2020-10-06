package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertyFile
{

          Properties properties = null;


    {
        try {
            FileInputStream fileInputStream = new FileInputStream("./contactdata.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String partnermobilenumber = properties.getProperty("partnerNumber");

    public String contactfullname = properties.getProperty("fullname");
    public String contactmobilenumber = properties.getProperty("mobilenumber");
    public String contactemail = properties.getProperty("email");
    public String organisation = properties.getProperty("organisation");
    public String spouse = properties.getProperty("spouses");
    public String kids = properties.getProperty("kids");
    public String nationalID = properties.getProperty("nationalID");
    public String twitter = properties.getProperty("twitter");
    public String facebook = properties.getProperty("facebook");

}
