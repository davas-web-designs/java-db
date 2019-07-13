
import java.sql.*;

public class readDb{
    public static void main(String[] args){

	try{

	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");

	    Statement s = c.createStatement();

	    ResultSet r = s.executeQuery("SELECT * FROM tabla1");

	    while(r.next()){
		System.out.println(r.getString("nombre"));
	    }
	}
	catch(Exception e){
	    System.out.println("no furula");

	    e.printStackTrace();
	}
    }
}


