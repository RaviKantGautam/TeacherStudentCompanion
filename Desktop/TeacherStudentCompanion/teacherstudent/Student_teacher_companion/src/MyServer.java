
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.vmm.JHTTPServer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

class MyServer extends JHTTPServer{
    
    public MyServer(int port) throws Exception {
        super(port);
    
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
       Response res=null;
        if(uri.contains("GetResource"))
        {
            try {
                uri=uri.substring(1);
                uri=uri.substring(uri.indexOf("/")+1);
                System.out.println(uri);
                res = sendCompleteFile(uri);
                return res;
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(uri.contains("login"))
        {
            try {
                String u,p;
                u=parms.getProperty("user");
                p=parms.getProperty("password");
                
                if(u.equals("ravi") && p.equals("lumia"))
                {
                    res = new Response(HTTP_OK,"text/plain","successfull");
                    
                }
                else{
                    res = new Response(HTTP_OK,"text/plain","fail");
                }
                return res;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(uri.contains("signup")){
            String u,p;
            u=parms.getProperty("user");
            p=parms.getProperty("password");
            
            System.out.println("** Sign up **");
            System.out.println(u+" "+p);
            
            String ans = saveFileOnServerWithRandomName(files, parms, "f1", "src/uploads");
            res = new Response(HTTP_OK,"text/plain","sign up succesfull"+ans);
            return res;
        }
        else if(uri.contains("database")){
            try {
                /////////////## CODE ## /////////
                Class.forName("com.sql.jdbc.Driver");
                System.out.println("Driver load successfully");
                
                Connection conn = (Connection) DriverManager.getConnection("jdbc://127.0.0.1:3306/test","root"," ");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select* from EMP");
                System.out.println("ResultSet created");
                //////////// ## END CODE ##///////
                String ename;
                String ema;
                String mob;
                String pass;
                
                
                while(rs.next()){
                    ename = rs.getString("name");
                    ema = rs.getString("email");
                    mob = rs.getString("mobile");
                    pass = rs.getString("password");
                    
                    System.out.println(ename+" "+ema+" "+mob+" "+pass);
                    
                }
                
                
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        
            else{
            res = new Response(HTTP_OK,"text/plain", "hello to the server");
            return res;
        }
        return null;
   } 
 
}