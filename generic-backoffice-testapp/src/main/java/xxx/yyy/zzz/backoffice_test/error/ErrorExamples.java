package xxx.yyy.zzz.backoffice_test.error;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ErrorExamples {
	
	public void divByZero(){
		int a=5;
		int b=0;
		int c=  a/b;
	}
	
	public void nullPointerEx(){
		Date d = null;
		String s= d.toString();
	}
	
	public void fileNotFound() throws Exception{
		FileInputStream f1 = new FileInputStream("fichier_qui_nexiste_pas.txt");
	}
	
	public void classNotFound() throws ClassNotFoundException{
		Class.forName("pp.ClasseQuiNexistePas");
	}
	
	public void noDataBaseConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DriverManager.getConnection("jdbc:mysql://localhost/wrongDB", "root", "formation");
	}
	
    public void wrongPassordForDataBaseConnection()throws SQLException{
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DriverManager.getConnection("jdbc:mysql://localhost/minibank_db", "root", "not_formation");
	}
    
    public void jndiLookupException() throws NamingException{
    	Context ic = new InitialContext();
    	Object o= ic.lookup("wrong_jdni_name");
    	
    }

}
