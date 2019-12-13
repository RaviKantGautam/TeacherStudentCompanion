package teacherstudentserver;


import com.vmm.JHTTPServer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;

class MyServer extends JHTTPServer {

    public MyServer(int port) throws Exception {
        super(port);

    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = null;
        System.out.println(uri);
        if (uri.contains("GetResource")) {
            try {
                uri = uri.substring(1);
                uri = uri.substring(uri.indexOf("/") + 1);
                System.out.println(uri);
                res = sendCompleteFile(uri);
                return res;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("adminlogin")) {
            String ans = "";

            try {
                String u, p;
                u = parms.getProperty("user");
                p = parms.getProperty("pass");

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from admin where email='" + u + "' and password='" + p + "'");
                System.out.println(u+" "+p);

                if (rs.next()) {
                    ans = "success";
                } else {
                    ans = "fail";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("teacherlogin")) {
            String ans = "";

            try {
                String u, p;
                u = parms.getProperty("Username");
                p = parms.getProperty("Password");

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where Username='" + u + "' and Password='" + p + "'");

                if (rs.next()) {
                    ans = "success";
                } else {
                    ans = "fail";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("studentlogin")) {
            String ans = "";

            try {
                String u, p;
                System.out.println("hello");
                u = parms.getProperty("rollno");
                p = parms.getProperty("pass");
                System.out.println(u + " " + p);
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber='" + u + "' and password='" + p + "'");

                if (rs.next()) {
                    ans = "success";
                } else {
                    ans = "fail";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("adddepartment")) {
            String ans = "";

            try {
                String dn, des, hod, em, mob;
                dn = parms.getProperty("dn");
                des = parms.getProperty("des");
                hod = parms.getProperty("hod");
                em = parms.getProperty("em");
                mob = parms.getProperty("mob");

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from department where departmentname='" + dn + "'");

                if (rs.next()) {
                    ans = "fail";
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("departmentname", dn);
                    rs.updateString("description", des);
                    rs.updateString("departmenthead", hod);
                    rs.updateString("email", em);
                    rs.updateString("phoneno", mob);

                    rs.insertRow();
                    ans = "success";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("fetchdepartment")) {
            String anws = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from department");

                while (rs.next()) {
                    String dn = rs.getString("departmentname");
                    String des = rs.getString("description");
                    String hod = rs.getString("departmenthead");
                    String em = rs.getString("email");
                    String mob = rs.getString("phoneno");

                    anws = anws + dn + "#&%" + des + "#&%" + hod + "#&%" + em + "#&%" + mob + "^";

                }

                System.out.println(anws);
                res = new Response(HTTP_OK, "text/plain", anws);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("getfacultyinfo")) {
            String anws = "", user, dn, cn, em, phno, addr, exp, qul;
            user = parms.getProperty("username");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where username = '" + user + "'");

                while (rs.next()) {
                    user = rs.getString("Username");
                    dn = rs.getString("departmentname");
                    cn = rs.getString("coursename");
                    em = rs.getString("email");
                    phno = rs.getString("phone");
                    addr = rs.getString("address");
                    exp = rs.getString("experience");
                    qul = rs.getString("qualification");
                    String photo = rs.getString("photo");

                    anws = anws + user + "#&%" + dn + "#&%" + cn + "#&%" + em + "#&%" + addr + "#&%" + exp + "#&%" + qul + "#&%" + phno + "#&%" + photo;

                }

                System.out.println(anws);
                res = new Response(HTTP_OK, "text/plain", anws);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/deletedepartment")) {
            String ans = null, dn;
            dn = parms.getProperty("dn");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from department where departmentname='" + dn + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";

                } else {
                    ans = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("getfacultyinfo")) {
            String anws = "", user, rollno, dept, cour, em, phno, addr;
            rollno = parms.getProperty("rollno");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollno = '" + rollno + "'");

                while (rs.next()) {
                    user = rs.getString("Username");
                    rollno = rs.getString("rollno");
                    dept = rs.getString("departmentname");
                    cour = rs.getString("coursename");
                    em = rs.getString("email");
                    phno = rs.getString("phone");
                    addr = rs.getString("address");
                    String photo = rs.getString("photo");

                    anws = anws + user + "#&%" + rollno + "#&%" + dept + "#&%" + cour + "#&%" + em + "#&%" + phno + "#&%" + addr + "#&%" + photo;

                }

                System.out.println(anws);
                res = new Response(HTTP_OK, "text/plain", anws);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/departmentnames")) {
            String ans = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select departmentname from department");
                System.out.println("Resultset created");

                while (rs.next()) {
                    String dn = rs.getString("departmentname");
                    ans = ans + dn + "^";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/addcourse")) {
            String ans = "";
            String dn = parms.getProperty("dn");
            String cn = parms.getProperty("cn");
            String des = parms.getProperty("des");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from courses where coursename= '" + cn + "'");

                System.out.println("Resultset created");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "unsuccessfull");

                } else {
                    rs.moveToInsertRow();
                    rs.updateString("departmentname", dn);
                    rs.updateString("coursename", cn);
                    rs.updateString("description", des);
                    rs.insertRow();
                    ans = "success";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/deletecourse")) {
            String ans = null, dn;
            dn = parms.getProperty("dn");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from courses where departmentname='" + dn + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";

                } else {
                    ans = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/fetchcourses")) {
            String anws = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from courses");

                while (rs.next()) {
                    String cn = rs.getString("coursename");
                    String dn = rs.getString("departmentname");
                    String des = rs.getString("description");

                    anws = anws + cn + "#&%" + dn + "#&%" + des + "^";

                }

                System.out.println(anws);
                res = new Response(HTTP_OK, "text/plain", anws);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/coursedepartment")) {
            String ans = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from courses");
                System.out.println("Resultset created");

                while (rs.next()) {
                    String cn = rs.getString("coursename");
                    String dn = rs.getString("departmentname");
                    String des = rs.getString("description");

                    ans = ans + dn + "^" + cn + "^" + des + "&*";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("deletestudent")) {
            String ans = null, rollno;
            rollno = parms.getProperty("rollno");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where roll number='" + rollno + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";

                } else {
                    ans = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        }

else if (uri.contains("deleteFaculty")) {
            String ans = null, user;
            user = parms.getProperty("user");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where Username='" + user + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";

                } else {
                    ans = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("deleteFaculty")) {
            String ans = null, rollno;
            rollno = parms.getProperty("rollno");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber='" + rollno + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";

                } else {
                    ans = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("fetchtesnotes")) {
            String ans = "";
            String user = parms.getProperty("username");
            try {

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from notedetails where username ='" + user + "'");

                while (rs.next()) {
                    String nid = rs.getString("nid");

                    String title = rs.getString("title");
                    String des = rs.getString("description");
                    String type = rs.getString("type");
                    String file = rs.getString("file");

                    ans = ans + title + "#&%" + des + "#&%" + type + "#&%" + file + "#&%" + nid + "#&%" + "^";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("fetchFaculty")) {
            String ans = "";
            String dept = parms.getProperty("dept");
            String course = parms.getProperty("course");
            try {

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where departmentname ='" + dept + "' and coursename ='" + course + "'");

                while (rs.next()) {
                    String user = rs.getString("Username");

                    String em = rs.getString("email");
                    String ph = rs.getString("phone");
                    String addr = rs.getString("address");
                    String qul = rs.getString("qualification");
                    String exp = rs.getString("experience");
                    String photo = rs.getString("photo");

                    ans = ans + user + "#&%" + em + "#&%" + addr + "#&%" + qul + "#&%" + exp + "#&%" + ph + "#&%" + dept + "#&%" + course + "#&%" + photo + "^";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/addFaculty")) {
            int j = (int) (1000.0 + (9999.0 - 1000.0) * Math.random());
            String ans = "";
            String user = parms.getProperty("user");

            String em = parms.getProperty("em");
            String ph = parms.getProperty("ph");
            String addr = parms.getProperty("addr");
            String qul = parms.getProperty("qul");
            String exp = parms.getProperty("exp");
            String dn = parms.getProperty("dn");
            String cn = parms.getProperty("cn");
            String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/content");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where Username = '" + user + "'");

                System.out.println("Resultset created");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "unsuccessfull");

                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Username", user);
                    rs.updateString("Password", "" + j);
                    rs.updateString("email", em);
                    rs.updateString("phone", ph);
                    rs.updateString("address", addr);
                    rs.updateString("qualification", qul);
                    rs.updateString("experience", exp);
                    rs.updateString("departmentname", dn);
                    rs.updateString("coursename", cn);
                    rs.updateString("photo", "src/content/" + filename);
                    rs.insertRow();
                    smscode.send(ph,"Your password to login is"+j);
                    ans = "success";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("fetchstudentinfo")) {

            String ans = "";

            String dn = parms.getProperty("dept");
            String cn = parms.getProperty("cn");
            System.out.println(dn + " " + cn);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where departmentname ='" + dn + "' and coursename ='" + cn + "'");

                System.out.println("Resultset created");
                while (rs.next()) {
                    String rollno = rs.getString("rollnumber");

                    String em = rs.getString("email");
                    String ph = rs.getString("phonenumber");
                    String addr = rs.getString("address");

                    String photo = rs.getString("photo");
                    String sem = rs.getString("semester");
                    ans = ans + rollno + "#&%" + em + "#&%" + addr + "#&%" + ph + "#&%" + dn + "#&%" + cn + "#&%" + sem + "#&%" + photo + "^";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("addnotes")) {
            String ans = "";
            String tt = parms.getProperty("title");
            String user = parms.getProperty("username");
            String desc = parms.getProperty("description");
            String ftype = parms.getProperty("type");
            String studentdata = parms.getProperty("studentdata");
            String filename = saveFileOnServerWithRandomName(files, parms, "file", "src/content");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from notes");
                System.out.println("Resultset created");

                rs.moveToInsertRow();
                rs.updateString("title", tt);
                rs.updateString("description", desc);
                rs.updateString("type", ftype);
                rs.updateString("file", "src/content/" + filename);
                rs.updateString("username", user);
                rs.insertRow();
                ResultSet rs1 = stmt.executeQuery("select max(nid) as max from notes");
                if (rs1.next()) {
                    int nid = rs1.getInt("max");

                    StringTokenizer st = new StringTokenizer(studentdata, "^");
                    ResultSet rs2 = stmt.executeQuery("select * from noteDetails");
                    while (st.hasMoreTokens()) {
                        rs2.moveToInsertRow();
                        rs2.updateInt("rollno", Integer.parseInt(st.nextToken()));
                        rs2.updateInt("nid", nid);
                        rs2.insertRow();
                    }

                }
                ans = "success";

                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("studentname")) {
            String ans = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select rollnumber from student");
                System.out.println("Resultset created");

                while (rs.next()) {
                    String dn = rs.getString("rollnumber");
                    ans = ans + dn + "^";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("fetchcoursenames")) {
            String dept = parms.getProperty("dept");
            System.out.println(dept);
            String ans = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from courses where departmentname= '" + dept + "'");
                System.out.println("Resultset created");

                while (rs.next()) {
                    String cn = rs.getString("coursename");

                    ans = ans + cn + "^";

                }
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("facultychangepassword")) {
            String username = parms.getProperty("username");
            String oldpass = parms.getProperty("oldpass");
            String newpass = parms.getProperty("newpass");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where username = '" + username + "' and password = '" + oldpass + "'");

                if (rs.next()) {
                    rs.updateString("password", newpass);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;

        } else if (uri.contains("studentchangepassword")) {
            String rollno = parms.getProperty("rollno");
            String oldpass = parms.getProperty("oldpass");
            String newpass = parms.getProperty("newpass");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber='" + rollno + "' and password='" + oldpass + "'");

                if (rs.next()) {
                    rs.updateString("password", newpass);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;

        } else if (uri.contains("Facultyeditprofile")) {
            String username = parms.getProperty("username");
            String addr = parms.getProperty("address");
            String em = parms.getProperty("em");
            String phn = parms.getProperty("phn");
            String quali = parms.getProperty("quali");
            String status = parms.getProperty("status");
            //String photo= parms.getProperty("photo");
            String ex = parms.getProperty("ex");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from faculty where Username = '" + username + "'");

                if (rs.next()) {
                    rs.updateString("address", addr);
                    rs.updateString("email", em);
                    rs.updateString("phone", phn);
                    rs.updateString("qualification", quali);
                    rs.updateString("experience", ex);
                    if (status.equals("true")) {
                        String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/content");
                        rs.updateString("photo", "src/content/" + filename);
                    }
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;

        } else if (uri.contains("getstudentinfo")) {
            String anws = "", rollno, dept, cour, em, phno, addr, photo;
            rollno = parms.getProperty("rollnumber");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber = '" + rollno + "'");

                while (rs.next()) {
                    rollno = rs.getString("rollnumber");

                    dept = rs.getString("departmentname");
                    cour = rs.getString("coursename");
                    em = rs.getString("email");
                    phno = rs.getString("phonenumber");
                    addr = rs.getString("address");
                    photo = rs.getString("photo");

                    anws = anws + rollno + "#&%" + dept + "#&%" + cour + "#&%" + em + "#&%" + phno + "#&%" + addr + "#&%" + photo;

                }

                System.out.println(anws);
                res = new Response(HTTP_OK, "text/plain", anws);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("studenteditprofile")) {

            String rollno = parms.getProperty("rollno");
            String email = parms.getProperty("email");
            String phno = parms.getProperty("phno");
            String addr = parms.getProperty("addr");
            String status = parms.getProperty("status");

            //String photo= parms.getProperty("photo");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber = '" + rollno + "'");

                if (rs.next()) {
                    rs.updateString("rollnumber", rollno);
                    rs.updateString("email", email);
                    rs.updateString("phonenumber", phno);
                    rs.updateString("address", addr);
                    if (status.equals("true")) {
                        String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/content");
                        rs.updateString("photo", "src/content/" + filename);
                    }
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("viewnotes")) {

            String ans = "";
            String rollno = parms.getProperty("rollno");
            System.out.println(rollno);
            //String photo= parms.getProperty("photo");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from notedetails where rollno = '" + rollno + "'");

                while (rs.next()) {
                    String nid = rs.getString("nid");

                    String datetime = rs.getString("datetime");
                    System.out.println(nid + " " + datetime);
                    Statement stmt1 = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("select * from notes where nid = '" + nid + "'");
                    if (rs1.next()) {
                        String title = rs1.getString("title");
                        String username = rs1.getString("username");

                        String description = rs1.getString("description");
                        String type = rs1.getString("type");
                        String file = rs1.getString("file");

                        ans = ans + title + "!&" + username + "!&" + description + "!&" + type + "!&" + file + "!&" + nid + "!&" + datetime + "^";
                    }
                }
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("addStudent")) {
            int j = (int) (1000.0 + (9999.0 - 1000.0) * Math.random());
            String ans = "";
            String rollno = parms.getProperty("rollno");

            String em = parms.getProperty("em");
            String phno = parms.getProperty("phno");
            String addr = parms.getProperty("addr");
            String sem = parms.getProperty("sem");

            String dn = parms.getProperty("dn");
            String cn = parms.getProperty("cn");
            String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/content");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber = '" + rollno + "'");

                System.out.println("Resultset created");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "unsuccessfull");

                } else {
                    rs.moveToInsertRow();
                    rs.updateString("rollnumber", rollno);
                    rs.updateString("Password", "" + j);
                    rs.updateString("email", em);
                    rs.updateString("phonenumber", phno);
                    rs.updateString("address", addr);
                    rs.updateString("semester", sem);

                    rs.updateString("departmentname", dn);
                    rs.updateString("coursename", cn);
                    rs.updateString("photo", "src/content/" + filename);
                    rs.insertRow();
                      smscode.send(phno,"Your password to login is"+j);
                    ans = "success";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("deletenotes")) {
            String ans = null, nid;
            nid = parms.getProperty("nid");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from notes where nid='" + nid + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";

                } else {
                    ans = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("noteshistory")) {

            String ans = "";
            String username = parms.getProperty("username");

            //String photo= parms.getProperty("photo");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");

                ResultSet rs1 = stmt.executeQuery("select * from notes where username = '" + username + "'");
                while(rs1.next()) {
                    String title = rs1.getString("title");
                    String description = rs1.getString("description");
                    String type = rs1.getString("type");
                    String file = rs1.getString("file");
                    String nid = rs1.getString("nid");
                    ans = ans + title + "!&" + description + "!&" + type + "!&" + file + "!&" + nid + "^";
                }

                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("searchstudentinfo")) {

            String ans = "";

            String rollnumber = parms.getProperty("rollnumber");
            System.out.println(" " + rollnumber);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver load successfully");

                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema", "root", "ravi");
                System.out.println("connection built");
                Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                ResultSet rs = stmt.executeQuery("select * from student where rollnumber ='" + rollnumber + "'");

                System.out.println("Resultset created");
                if (rs.next()) {
                    String rollno = rs.getString("rollnumber");

                    String em = rs.getString("email");
                    String ph = rs.getString("phonenumber");
                    String addr = rs.getString("address");
                    String dn = rs.getString("departmentname");
                    String cn = rs.getString("coursename");

                    String photo = rs.getString("photo");
                    String sem = rs.getString("semester");
                    ans = ans + rollno + "#&%" + em + "#&%" + addr + "#&%" + ph + "#&%" + dn + "#&%" + cn + "#&%" + sem + "#&%" + photo ;

                }
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // res = new Response(HTTP_OK, "text/plain", "hello to the server");

        }

        return res;
    }

}
