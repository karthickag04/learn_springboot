<%@ page import="java.sql.*" %>

<html>
<head>
<title>JSP MySQL Demo</title>

<style>
table{
border-collapse:collapse;
margin-bottom:40px;
}
th,td{
border:1px solid black;
padding:8px;
}
th{
background:#eee;
}
</style>

</head>
<body>

<h2>JSP MySQL Database Connection Demo</h2>

<%

String url = "jdbc:mysql://192.168.1.8:3306/team05";
String username = "test01";
String password = "Test@123p";

Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try{

Class.forName("com.mysql.cj.jdbc.Driver");

con = DriverManager.getConnection(url,username,password);

stmt = con.createStatement();

out.println("<h3>Database Connected Successfully</h3>");

/* ================= USERS ================= */

out.println("<h2>Users Table</h2>");
rs = stmt.executeQuery("SELECT * FROM users");

out.println("<table>");
out.println("<tr>");
out.println("<th>ID</th>");
out.println("<th>Name</th>");
out.println("<th>Password</th>");
out.println("<th>Email</th>");
out.println("<th>Age</th>");
out.println("<th>Status</th>");
out.println("<th>Created</th>");
out.println("</tr>");

while(rs.next())
{
out.println("<tr>");
out.println("<td>"+rs.getInt("user_id")+"</td>");
out.println("<td>"+rs.getString("user_name")+"</td>");
out.println("<td>"+rs.getString("password")+"</td>");
out.println("<td>"+rs.getString("email")+"</td>");
out.println("<td>"+rs.getInt("age")+"</td>");
out.println("<td>"+rs.getString("status")+"</td>");
out.println("<td>"+rs.getTimestamp("created_at")+"</td>");
out.println("</tr>");
}

out.println("</table>");



/* ================= ORDERS ================= */

out.println("<h2>Orders Table</h2>");
rs = stmt.executeQuery("SELECT * FROM orders");

out.println("<table>");
out.println("<tr>");
out.println("<th>Order ID</th>");
out.println("<th>User ID</th>");
out.println("<th>Date</th>");
out.println("<th>Amount</th>");
out.println("</tr>");

while(rs.next())
{
out.println("<tr>");
out.println("<td>"+rs.getInt("order_id")+"</td>");
out.println("<td>"+rs.getInt("user_id")+"</td>");
out.println("<td>"+rs.getTimestamp("order_date")+"</td>");
out.println("<td>"+rs.getDouble("amount")+"</td>");
out.println("</tr>");
}

out.println("</table>");



/* ================= PRODUCTS ================= */

out.println("<h2>Products Table</h2>");
rs = stmt.executeQuery("SELECT * FROM products");

out.println("<table>");
out.println("<tr>");
out.println("<th>ID</th>");
out.println("<th>Name</th>");
out.println("<th>Price</th>");
out.println("<th>Stock</th>");
out.println("</tr>");

while(rs.next())
{
out.println("<tr>");
out.println("<td>"+rs.getInt("product_id")+"</td>");
out.println("<td>"+rs.getString("product_name")+"</td>");
out.println("<td>"+rs.getDouble("price")+"</td>");
out.println("<td>"+rs.getInt("stock")+"</td>");
out.println("</tr>");
}

out.println("</table>");



/* ================= ORDER ITEMS ================= */

out.println("<h2>Order Items Table</h2>");
rs = stmt.executeQuery("SELECT * FROM order_items");

out.println("<table>");
out.println("<tr>");
out.println("<th>ID</th>");
out.println("<th>Order ID</th>");
out.println("<th>Product ID</th>");
out.println("<th>Quantity</th>");
out.println("</tr>");

while(rs.next())
{
out.println("<tr>");
out.println("<td>"+rs.getInt("order_item_id")+"</td>");
out.println("<td>"+rs.getInt("order_id")+"</td>");
out.println("<td>"+rs.getInt("product_id")+"</td>");
out.println("<td>"+rs.getInt("quantity")+"</td>");
out.println("</tr>");
}

out.println("</table>");



}
catch(Exception e)
{
out.println("Error : "+e);
}

finally
{
try{
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
if(con!=null) con.close();
}catch(Exception ex){}
}

%>

</body>
</html>