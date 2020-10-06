package utility;

import maindriver.CommonFunctions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DatabaseConnection
{



    public static void main(String args[])
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        CommonFunctions commonFunctions = new CommonFunctions();
        List<String> propertyvalues = commonFunctions.arrayProperties("./contactdata.properties");
        LinkedList<String> values = databaseConnection.contactDatabaseTable();
        System.out.println("the values Size is " + values.size());
        System.out.println("the propertyvalues Size is " + propertyvalues.size());
        for(int i=0,j=0;i<values.size() && j < propertyvalues.size();i++,j++)
        {
            System.out.println("the values of I are  " + values.get(i));
            System.out.println("the values of J are " + propertyvalues.get(j));
           // Assert.assertEquals(values.get(i),propertyvalues.get(j));

        }
    }

    Properties properties = null;


    {
        try {
            FileInputStream fileInputStream = new FileInputStream("./db.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String username = properties.getProperty("user");
    String password = properties.getProperty("password");
    String dbURL = properties.getProperty("databaseURL");

    public LinkedList<String> contactDatabaseTable()
    {
        Connection connection = null;
        LinkedList<String>result = new LinkedList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Contacts where partnerId = \"2473\" and isDeleted=0");
            while (rs.next())
            {
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(7));
                result.add(rs.getString(9));
                result.add(rs.getString(10));
                result.add(rs.getString(11));
                result.add(rs.getString(12));
                result.add(rs.getString(13));
                result.add(rs.getString(14));



            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {

        }
        return result;
    }



}






