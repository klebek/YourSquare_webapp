package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.AdRepository;
import dao.MessageRepository;
import dao.UserRepository;
import model.User;

public class App 
{
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/workdb";

	   static final String USER = "root";
	   static final String PASS = "root";
	   
    public static void main( String[] args )
    {
    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	try {
			Connection connection = DriverManager.getConnection(url);
			UserRepository userRepo = new UserRepository(connection);
			MessageRepository msgRepo = new MessageRepository(connection);
			AdRepository adRepo = new AdRepository(connection);
			
			User janek = new User();
			janek.setName("Jan");
			janek.setSurname("Kowalski");

	        System.out.println( "zapisuje janka" );
			userRepo.add(janek);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "Koniec" );
        
    }
}