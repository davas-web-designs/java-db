
import java.sql.*;

public class preparedQueries{
    public static void main(String[] args){

	try{

	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");

	    PreparedStatement s = c.prepareStatement("SELECT * FROM tabla1 WHERE nombre = ? AND edad = ?");

	    s.setString(1,"Juanito");
	    s.setInt(2, 27);
	    
	    ResultSet r = s.executeQuery();

	    while(r.next()){
		System.out.println(r.getString("nombre"));
	    }

	    r.close();
	}
	catch(Exception e){
	    System.out.println("no furula");

	    e.printStackTrace();
	}
    }
}

