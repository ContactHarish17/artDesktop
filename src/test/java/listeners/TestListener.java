package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tesults.tesults.*;



public class TestListener implements ITestListener {

    // A list to hold your test cases.
    List<Map<String,Object>> testCases = new ArrayList<Map<String, Object>>();
    ITestResult result;

    @Override
    public void onTestStart(ITestResult result) {

        if (result.getStatus() == ITestResult.STARTED) {
            System.out.println("on test method " + getTestMethodName(result) + " start");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("I'M a  test method " + getTestMethodName(result) + " success");
        Map<String, Object> testCase = new HashMap<String, Object>();
        testCase.put("name", getTestMethodName(result));
        testCase.put("suite", "ART Desktop UI Automation");
        testCase.put("result", "pass");

        String Deviceos_Name = System.getProperty("DeviceOS");
        String Device_Name = System.getProperty("DeviceName");

        List<String> files = new ArrayList<String>();
//        File resource = new File("SmokeTest.html");
//        String filePath = resource.getAbsolutePath();
//        System.out.println("Resource File path : " + resource.getAbsolutePath());
//       // files.add(filePath);
        testCase.put("_DeviceName", Device_Name);
        testCase.put("_DeviceOS", Deviceos_Name);
        testCase.put("files",files);
        testCases.add(testCase);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String originalMessage=null;
        if (result.getStatus() == ITestResult.FAILURE)
        {
            Throwable throwable = result.getThrowable();
            originalMessage = throwable.getMessage();
        }
        // System.out.println("I'M a  test method " + getTestMethodName(result) + " failure");
        System.out.println("The name of the testcase failed is :"+getTestMethodName(result));
        Map<String, Object> testCase = new HashMap<String, Object>();
        testCase.put("name", getTestMethodName(result));//getTestMethodName(result));
        testCase.put("suite", "ART Desktop");
        testCase.put("result", "fail");
        // testCase.put("reason",originalMessage);
        testCases.add(testCase);

    }



    @Override
    public void onTestSkipped(ITestResult result) {

        // System.out.println("I'M a  test method " + getTestMethodName(result) + " skipped");
        System.out.println("The name of the testcase Skipped is :"+getTestMethodName(result));
        Map<String, Object> testCase = new HashMap<String, Object>();
        testCase.put("name", getTestMethodName(result));//getTestMethodName(result));
        testCase.put("suite", "ART Desktop");
        testCase.put("result", "unknown");
        testCases.add(testCase);

    }



    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("test failed but within success % " + getTestMethodName(result));

    }



    @Override
    public void onStart(ITestContext context) {

        System.out.println("I'M a  start of test " + context.getName());

    }



    @Override
    public void onFinish(ITestContext context) {



        System.out.println("on finish of test " + context.getName());
        // Map<String, Object> to hold your test results data.
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("target", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjhjOWFlNDE5LTE0YjUtNDIyOS1iNTczLTgxODY3OWVmODZmNi0xNTc5OTU1MTA2MTczIiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiZDQ4ZTI0ZTItMjcwYS00M2MyLTk1NTEtOTczNmM4YjkxYTA1IiwidHlwZSI6InQifQ.zy8tVDnqnhNWGq7Qur7agNlC1ZERoo_IES7hIk4f2qc");

        Map<String, Object> results = new HashMap<String, Object>();
        results.put("cases", testCases);
        data.put("results", results);

        // Upload
        Map<String, Object> response = Results.upload(data);
        System.out.println("success: " + response.get("success"));
        System.out.println("message: " + response.get("message"));
        System.out.println("errors: " + response.get("errors"));
        System.out.println("warnings: " + response.get("warnings"));


        // System.out.println("errors: " + ((List<String>) response.get("errors")).size());
        // System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());


    }



    private static String getTestMethodName(ITestResult result) {

        return result.getMethod().getConstructorOrMethod().getName();

    }



}
