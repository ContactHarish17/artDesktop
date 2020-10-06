package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ReadingGeneratedOTP {

    //Constants constants = new Constants();
    public static void main(String[] args) {

        try {
            String OTPValue = ReadingGeneratedOTP.call_me();
            System.out.println("The Generated OTP is :" + OTPValue);
            for ( int i=0;i<OTPValue.length();i++)
            {
                Character Chars = OTPValue.charAt(i);
                System.out.println("the numbers are " + Chars);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public static String call_me() throws Exception {

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }};

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }
        URL url = new URL("https://api-sit.alrajhitakaful.com:9445/v1/partners/login/otp");
        final String POST_PARAMS = "" +
                "{" +
                "\n" + "\"mobileNumber\": \"+966582176890\",\r\n" +
                "    \"channel\": \"Digital Partner Portal\",\r\n" +
                "    \"businessFunction\": \"Login\",\r\n" +
                "    \"language\": \"ar\"" + "\n}";

        byte[] postDataBytes = POST_PARAMS.getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("X-ART-API-KEY","1DCczyFMrjzJm8iW7jc9EP5agDrVZtWn");
        conn.setRequestProperty("Authorization","Basic");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        System.out.println(response);

        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");


        JSONObject form_data = myResponse.getJSONObject("result");
        String OTP = form_data.getString("otp");
        System.out.println("OTP Generated- "+form_data.getBoolean("isOTPGenerated"));
        return OTP;


    }
}

