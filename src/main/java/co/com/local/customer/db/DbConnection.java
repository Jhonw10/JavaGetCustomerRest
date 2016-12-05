package co.com.local.customer.db;

import java.sql.*;
public class DbConnection {
	
	 /**Parametros de conexion*/
	   static String bd = "xe";
	   static String login = "hr";
	   static String password = "admin";
	   static String url = "jdbc:oracle:thin:@local.sura.com:1521:"+bd;
	 
	   Connection connection = null;
	 
	   /** Constructor de DbConnection */
	   public DbConnection() {
	      try{
	         //obtenemos el driver de para mysql
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //obtenemos la conexión
	         connection = DriverManager.getConnection(url,login,password);
	 
	         if (connection!=null){
	            System.out.println("Conexión a base de datos "+bd+" OK\n");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }
	   /**Permite retornar la conexión*/
	   public Connection getConnection(){
	      return connection;
	   }
	 
	   public void desconectar(){
	      connection = null;
	   }	   
}
