
import java.sql.*;

public class writeToDb{
    public static void main(String[] args){

	try{

	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");

	    Statement s = c.createStatement();

	    String instruction = "INSERT INTO tabla1 (nombre, edad) VALUES ('Jhon', 25)";
	 
	    s.executeUpdate(instruction);
	}
	catch(Exception e){
	    System.out.println("no furula");

	    e.printStackTrace();
	}
    }
}

