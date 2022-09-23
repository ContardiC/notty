package notty.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import notty.bean.NoteBean;

public class Crud {
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION="jdbc:mysql://localhost:3306/notty";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="root";
	
	public void insertNote(NoteBean note) throws Exception{
		Statement stmt=null;
		Connection conn=null;
		String query="";
		conn=getDBConnection();
		//conn.setAutoCommit(false);
		
		//stmt=conn.createStatement();
		//query="";
		//stmt.executeUpdate(query);
	
	}
	private static Connection getDBConnection(){
		Connection dbConnection=null;
		try{
			Class.forName(DB_DRIVER);
		}catch(ClassNotFoundException e){
			System.out.println("JDBC Driver Not Found!");
		}
		try{
			dbConnection = DriverManager.getConnection(DB_CONNECTION,DB_USER, DB_PASSWORD);
			System.out.println("DB connected!!!!");
		}catch(SQLException e){
			System.out.println("DB not connected!!!!");
		}
		return dbConnection;
	}
	
	

}
