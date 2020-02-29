<%-- 
    Document   : index
    Created on : Nov 22, 2019, 10:30:25 AM
    Author     : Arthur Kyagulanyi
--%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserting Data into a DB</title>
    </head>
    <body onload="displayResults()">
        <h1>Inserting Data into a DB</h1>
        <%!
            public class User {

                String URL = "jdbc:mysql://localhost:3306/<Put Here The Name Of Your Database>";
                String USERNAME = "root";
                String PASSWORD = "";

                Connection con = null;
                PreparedStatement insertUsers = null;
                ResultSet rs = null;

                public User() {
                    try {
                        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertUsers = con.prepareStatement(
                                "INSERT INTO <Put here the name of your database table>(u_fname,u_lname,u_username,u_password,u_telephone,u_email)"
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
        %>
        <%
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
        %>

        <form name="myForm" action="index.jsp" method="POST">
            <table border="0">

                <tbody>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="first" value=""  size="50"/> </td>
                    </tr>
                    <tr>
                        <td>Last Name : </td>
                        <td><input type="text" name="last" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Username : </td>
                        <td><input type="text" name="username" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="pass" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Telephone : </td>
                        <td><input type="text" name="telephone" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Email : </td>
                        <td><input type="text" name="email" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="hidden" value="<%=result%>" />
            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <SCRIPT lang="JavaScript">
            <!--
    function displayResults() {

                if (document.myForm.hidden.value  == 1) {
                    alert("Data Was Inserted");
                }
            }
            //-- >
        </SCRIPT>
    </body>
</html>
