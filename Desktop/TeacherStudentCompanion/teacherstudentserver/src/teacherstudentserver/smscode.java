
package teacherstudentserver;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class smscode
{

    public static void send(String mobno, String msg)
    {
         try
        {
            String urlParameters = "username=Harpreettest&password=7I8BDEZH&message="+msg+"&phone_numbers="+mobno;
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            String request = "http://server1.vmm.education/VMMCloudMessaging/AWS_SMS_Sender";
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream()))
            {
                wr.write(postData);
            }

            DataInputStream dis = new DataInputStream(conn.getInputStream());
            while (true)
            {
                String s = dis.readLine();
                if (s == null)
                {
                    break;
                }
                System.out.println(s);

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        try
        {
            String urlParameters = "username=Harpreettest&password=7I8BDEZH&message=hello&phone_numbers=9872042013";
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            String request = "http://server1.vmm.education/VMMCloudMessaging/AWS_SMS_Sender";
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream()))
            {
                wr.write(postData);
            }

            DataInputStream dis = new DataInputStream(conn.getInputStream());
            while (true)
            {
                String s = dis.readLine();
                if (s == null)
                {
                    break;
                }
                System.out.println(s);

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
