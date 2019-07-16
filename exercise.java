import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

		

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());

		name = new JTextField(20);

		menus.add(name);

		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		botonConsulta=new JButton("Consulta");	
		
		MakeRequest event = new MakeRequest();
	
		botonConsulta.addActionListener(event);

		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
	}	
		

	
	private JTextField name;
	
	private JTextArea resultado;	
	
	private JButton botonConsulta;

	private dbConnection db = new dbConnection();

	private class MakeRequest implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			db.consult(name.getText());
		}
	}	
}


class dbConnection{

	public dbConnection(){
		try{

		    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "password");

		    System.out.println("We are connected");
		}
		catch(Exception e){
		    System.out.println("no furula");

		    e.printStackTrace();
		}
	}

	public void consult(String n){
		int number = Integer.parseInt(n);
		
		try{
			PreparedStatement s = c.prepareStatement("SELECT * FROM employees WHERE emp_no = ?");
			
			s.setInt(1,number);

			ResultSet r = s.executeQuery();

			while(r.next()){
				 System.out.println("My name is: " + r.getString("first_name"));
			}

			r.close();
			System.out.println("These are all the results");
		}catch(Exception e){
			System.out.println("Failing to do the search in db");
			e.printStackTrace();
		}

	}

	//int countColumns(String table){
	//	try{
	//		PreparedStatement s = c.prepareStatement("SELECT * FROM departements");

			//s.setString(1, table);
			
	//		ResultSet r = s.executeQuery();

	//		return r.getMetaData().getColumnCount();
	//	}catch(Exception e){
	//	        System.out.println("no furula");

	//	        e.printStackTrace();
		
	//		return 0;
		
	//	}
	
		
	//}

	//String[] columnNames

	private Connection c;
	
}

