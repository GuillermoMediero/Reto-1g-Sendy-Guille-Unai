/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ketro
 */
public class BaseDatos {
     private Connection con;

    
   public Connection conectar(){
       try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@SrvOracle:1521:ORCL ";
            String login="eqdaw04";
            String password = "eqdaw04";
            con = DriverManager.getConnection(url,login,password);
 
            if (con==null){
                throw new Exception("Problemas con la conexión");
            }
          }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
           return null;
       }
       return con;
   }
   
    public Connection getCon()
   {
       return con;
   }
    
   public void desconectar(){
       try
       {
            con.close();
       }
       catch(Exception e)
       {
           System.out.println("Problemas cerrando la conexión");
       }
   }
   
  
}
