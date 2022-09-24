package notty.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import notty.bean.NoteBean;

public class Crud {
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION="jdbc:mysql://localhost:3306/notty";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="root";
	
	public void insertNote(NoteBean note) throws Exception{
		Statement stmt=null;
		Connection conn=null;
		String title=note.getTitle();
		String body=note.getBody();
		String query="INSERT INTO notes(title,body) VALUES('"+title+"','"+body+"')";
		conn=getDBConnection();
		conn.setAutoCommit(false);
		stmt=conn.createStatement();
		stmt.executeUpdate(query);
		conn.commit();
		System.out.println("INSERT NOTE!!!!");
		if(conn!=null){
			conn.close();
		}
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
	public ArrayList<NoteBean> listNotes() throws SQLException,IOException{
		Statement stmt=null;
		Connection conn=null;
		try{
			conn=getDBConnection();
			stmt=conn.createStatement();
			String query="SELECT * FROM notes";
			ResultSet noteList=stmt.executeQuery(query);
			ArrayList<NoteBean> noteListInDB=new ArrayList<NoteBean>();
			while(noteList.next()){
				NoteBean note=new NoteBean();
				String title=noteList.getString("title");
				String body=noteList.getString("body");
				note.setTitle(title);
				note.setBody(body);
				noteListInDB.add(note);
			}
			return noteListInDB;
		}catch(SQLException e){
			throw new SQLException(e.getErrorCode()+":"+e.getMessage());
		}catch(Exception err){
			throw new SQLException("-->"+err.getMessage());
		}finally{
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}
	
	

}
