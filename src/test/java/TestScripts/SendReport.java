package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

public class SendReport {


   public static void main() throws MessagingException {
//Recipient's Mail id
        String receipientTo = "harish.ramakrishna@mindtree.com";
//Sender's Mail id
        String senderFrom = "contactharish17@gmail.com";
//Path of PDF test report
        String path = "D:\\artDesktop\\ARTDesktopAutomation_Test_Report.pdf";
//Getting System properties
        Properties prop = System.getProperties();
//Setting up smtp host
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
//Creating a new session for smtp
        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
//Instance of From Internet address
        InternetAddress frmAddress = new InternetAddress(senderFrom);
//Instance of To Internet address
        InternetAddress toAddress = new InternetAddress(receipientTo);
//Setting up sender's address
        msg.setFrom(frmAddress);
//Setting up recipient's address
        msg.addRecipient(Message.RecipientType.TO, toAddress);
//Setting email's subject
        msg.setSubject("ART Desktop Automation Status Report");
        BodyPart msgBody = new MimeBodyPart();
//Setting email's message body
        msgBody.setText("This is Automated Test report Generated , After test execution!");
//Instance of second part
        Multipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(msgBody);
//Another mail body
        msgBody = new MimeBodyPart();
//Path to pdf file for attachment
        DataSource source = new FileDataSource(path);
        DataHandler dataHandler = new DataHandler(source);
        msgBody.setDataHandler(dataHandler);
        msgBody.setFileName(path);
        multiPart.addBodyPart(msgBody);
        msg.setContent(multiPart);
//Authentication and connection establishment to the sender's mail
        Transport transport = session.getTransport("smtps");
        transport.connect("smtp.gmail.com",465,"contactharish17@gmail.com","Yashaswini81");
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        System.out.println("Mail Sent");
    }


}
