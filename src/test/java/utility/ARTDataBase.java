package utility;

import com.google.gson.internal.bind.SqlDateTypeAdapter;
import maindriver.CommonFunctions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class ARTDataBase {

    public static Connection connection = null;
    public static ResultSet rs = null;
    public static Statement stmt = null;
    CommonFunctions commonFunctions = new CommonFunctions();

    public static void connecttodb() throws SQLException, ClassNotFoundException {
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static LinkedList<String> executestatementPartners() throws SQLException, ClassNotFoundException {
        LinkedList<String> partnerDetails = new LinkedList<String>();
//        try {
//            ReadExcel.OpenExcel(Constant.ExcelFilepath);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        connecttodb();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from Partner where mobileNumber=+966"+ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,0)+"");
            try {
                ResultSet rs = stmt.executeQuery();
                try {
                    while (rs.next()) {
                        Constant.partnerID = String.valueOf(rs.getInt(1));
                        System.out.println("the partner ID " + Constant.partnerID);
                        partnerDetails.add(rs.getString(2));
                        partnerDetails.add(rs.getString(6));
                        partnerDetails.add(rs.getString(3));

                    }
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException e) {

                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (SQLException e) {

                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }        return partnerDetails;
    }


    public static void executestatementContact_Prospect() throws SQLException, ClassNotFoundException {
        connecttodb();
        try {
            PreparedStatement stmt1 = connection.prepareStatement("select contactId,contactType from Contacts where partnerId= " + Constant.partnerID + "");
            try {
                ResultSet rs = stmt1.executeQuery();
                try {
                    while (rs.next()) {
                        Constant.contactId = String.valueOf(rs.getString(3));
                        Constant.ContactType = rs.getString(16);
                        System.out.println("the partner ID is " + Constant.partnerID);
                        System.out.println("the contact ID is " + Constant.contactId);
                        System.out.println("the contact type before converted to prospect is " + Constant.ContactType);
                    }
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException e) {

                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (SQLException e) {

                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }

        public static LinkedList<String> executeContactStatement() throws SQLException, ClassNotFoundException {
        LinkedList<String> contactDetails = new LinkedList<String>();
        connecttodb();
        try
        {
            PreparedStatement
                    stmt = connection.prepareStatement("select * from Contacts where partnerId= "+Constant.partnerID+"and"+"contactId="+Constant.contactId+"");
            try {
                ResultSet rs = stmt.executeQuery();
                try {
                    while(rs.next())
                    {
                    contactDetails.add(rs.getString(3));
                    contactDetails.add(rs.getString(4).substring(4));
                    contactDetails.add(rs.getString(5));
                    contactDetails.add(rs.getString(7));
                    contactDetails.add(rs.getString(8));
                    contactDetails.add(rs.getString(9));
                    contactDetails.add(String.valueOf(rs.getInt(10)));
                    contactDetails.add(String.valueOf(rs.getInt(11)));
                    contactDetails.add(rs.getString(12));
                    contactDetails.add(rs.getString(13));
                    contactDetails.add(rs.getString(14));
                    Constant.contactDeleted = String.valueOf(rs.getString(24));
                    System.out.println("the contact deleted value is  " + Constant.contactDeleted);
                    Constant.ContactType = rs.getString(16);
                    System.out.println("the contact type after prospect conversation is " + Constant.ContactType);
                }
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException e) {

                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (SQLException e) {

                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }        return contactDetails;
    }



    public static LinkedList<String> executestatementContacts() throws SQLException {
        LinkedList<String> contactDetails = new LinkedList<String>();
        PreparedStatement stmt=null;
        ResultSet rs = null;
        try {
        stmt = connection.prepareStatement("select * from Contacts where partnerId=2470 and contactId=2995");
                System.out.println("select * from Contacts where partnerId= "+Constant.partnerID+ "");
        rs = stmt.executeQuery();
            while (rs.next()) {
                contactDetails.add(rs.getString(3));
                contactDetails.add(rs.getString(4).substring(4));
                contactDetails.add(rs.getString(5));
                contactDetails.add(rs.getString(7));
                contactDetails.add(rs.getString(8));
                contactDetails.add(rs.getString(9));
                contactDetails.add(String.valueOf(rs.getInt(10)));
                contactDetails.add(String.valueOf(rs.getInt(11)));
                contactDetails.add(rs.getString(12));
                contactDetails.add(rs.getString(13));
                contactDetails.add(rs.getString(14));
                Constant.ContactType = rs.getString(16);
                Constant.contactDeleted = String.valueOf(rs.getString(24));
                System.out.println("the contact deleted value is  " + Constant.contactDeleted);
                System.out.println("the contact type is " + Constant.ContactType);

            }

        }catch (SQLException e)
        {}
//        try {
//            if (rs != null)
//            {
                rs.close();
//            }} catch (SQLException e){};
//        try {
//            if (stmt != null) {
                stmt.close();
//            }
//        }catch (SQLException e){}


        return contactDetails;
    }


    public static void closeDBconnection()
    {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e)
        {
        }
    }


    public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException {
        ReadExcelDemo.OpenExcel(Constant.ExcelFilepath);
       // ReadExcelDemo.getExcelvaluestoArray(Constant.contactSheetName);
        List excelcontactvalues = ReadExcelDemo.excelvalues(4);
       // ReadExcelDemo.getExcelvaluestoArray(Constant.saudiOnboardingSheetName);
        List excelpartnervalues = ReadExcelDemo.excelvalues(4);


        connecttodb();
        try {
            LinkedList<String> partnervalue = ARTDataBase.executestatementPartners();
            for(int i=0, j=1;i<partnervalue.size() && j<excelpartnervalues.size();i++,j++)
            {
                System.out.println("the partner values of excel are " + excelpartnervalues.get(j));
                System.out.println("the partner values of database are  " + partnervalue.get(i));

                //   Assert.assertEquals(partnervalue.get(i),excelpartnervalues.get(j).toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        connecttodb();
        try {

            LinkedList<String> contactsvalue = ARTDataBase.executeContactStatement();
            for(int i=0, j=0;i<contactsvalue.size() && j<excelcontactvalues.size();i++,j++)
            {
                System.out.println("the contact values of database are  " + contactsvalue.get(i).toString());
                System.out.println("the contact values of excel are " + excelcontactvalues.get(j));
                //Assert.assertEquals(contactsvalue.get(i),excelcontactvalues.get(j).toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

}

