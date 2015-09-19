package ar.edu.itba.it.paw.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Dao {

	protected Connection connection;

	public Dao() {
		connect();
	}

	protected void connect() {
		
		
		Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/db_connection.properties");
           // /FoodNow/src/main/webapp/WEB-INF/db_connection.properties
         //   /FoodNow/src/main/java/ar/edu/itba/it/paw/dao/Dao.java
            props.load(fis);
 
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
 
            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
            
            System.out.println("Conected to the database...");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e){
        	e.printStackTrace();
        } catch(SQLException e) {
        	e.printStackTrace();
        }
        
		this.connection = con;

	}

	public void closeConnection() throws SQLException {
		connection.close();

	}
}
