package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            public class User {

                String URL = "jdbc:mysql://localhost:3306/traindatabase";
                String USERNAME = "root";
                String PASSWORD = "";

                Connection con = null;
                PreparedStatement insertUsers = null;
                ResultSet rs = null;

                public User() {
                    try {
                        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertUsers = con.prepareStatement(
                                "INSERT INTO user(u_fname,u_lname,u_username,u_password,u_telephone,u_email)"
                                + "VALUES (?,?,?,?,?,?) ");

                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }

                public int setUsers(String first, String last, String username, String pass, String telephone, String email) {
                    int result = 0;
                    try {
                        insertUsers.setString(1, first);
                        insertUsers.setString(2, last);
                        insertUsers.setString(3, username);
                        insertUsers.setString(4, pass);
                        insertUsers.setString(5, telephone);
                        insertUsers.setString(6, email);
                        result = insertUsers.executeUpdate();

                    } catch (SQLException e) {
                        System.out.print(e);

                    }
                    return result;
                }

            }
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inserting Data into a DB</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"displayResults()\">\n");
      out.write("        <h1>Inserting Data into a DB</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            int result = 0;

            if (request.getParameter("submit") != null) {
                String firstname = new String();
                String lastname = new String();
                String uname = new String();
                String passw = new String();
                String tele = new String();
                String Email = new String();

                if (request.getParameter("first") != null) {
                    firstname = request.getParameter("first");
                }
                if (request.getParameter("last") != null) {
                    lastname = request.getParameter("last");
                }
                if (request.getParameter("username") != null) {
                    uname = request.getParameter("username");
                }
                if (request.getParameter("pass") != null) {
                    passw = request.getParameter("pass");
                }
                if (request.getParameter("telephone") != null) {
                    tele = request.getParameter("telephone");
                }
                if (request.getParameter("email") != null) {
                    Email = request.getParameter("email");
                }

                User user = new User();
                result = user.setUsers(firstname, lastname, uname, passw, tele, Email);
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form name=\"myForm\" action=\"index.jsp\" method=\"POST\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>First Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"first\" value=\"\"  size=\"50\"/> </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Last Name : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"last\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Username : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"username\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password: </td>\n");
      out.write("                        <td><input type=\"password\" name=\"pass\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Telephone : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"telephone\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"email\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print(result);
      out.write("\" />\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"submit\" />\n");
      out.write("        </form>\n");
      out.write("        <SCRIPT lang=\"JavaScript\">\n");
      out.write("            <!--\n");
      out.write("    function displayResults() {\n");
      out.write("\n");
      out.write("                if (document.myForm.hidden.value  == 1) {\n");
      out.write("                    alert(\"Data Was Inserted\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            //-- >\n");
      out.write("        </SCRIPT>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
