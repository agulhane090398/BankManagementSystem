package bankingATM;
import java.sql.*;


public class Connectionset 
{
	Connection c;
	Statement s;
	
	public Connectionset()
	{
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");

			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/asm","root","root");
//			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectBanking","root","root");
			s=c.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
	
//	OR
	
//	public static void main(String[] args) 
//	{
//		 Connection con = null;
//		 Statement s;
//
//		    String url = "jdbc:mysql://localhost:3306/projectBanking";
//		    String username = "root";
//		    String password = "root";
//
//		    try {
//		      try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		      con = DriverManager.getConnection(url, username, password);
//
//		      System.out.println("Connected!");
//
//		    } catch (SQLException ex) {
//		        throw new Error("Error ", ex);
//		    } finally {
//		      try {
//		        if (con != null) {
//		            con.close();
//		        }
//		      } catch (SQLException ex) {
//		          System.out.println(ex.getMessage());
//		      }
//		    }
//
//		
//	}
}
